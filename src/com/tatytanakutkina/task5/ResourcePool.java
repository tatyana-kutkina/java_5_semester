package com.tatytanakutkina.task5;


import java.util.AbstractMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ResourcePool<T> {

    private LinkedBlockingQueue<AbstractMap.SimpleEntry<T, Long>> available;
    private LinkedBlockingQueue<T> inUse;

    private int size;
    private boolean shutdownCalled;
    private ObjectFactory<T> objectFactory;
    private ExecutorService executor = Executors.newCachedThreadPool();
    long keepAliveTime;

    public ResourcePool(int size, ObjectFactory<T> objectFactory) {
        this.size = size;
        available = new LinkedBlockingQueue<>(size);
        this.objectFactory = objectFactory;
        initializeObjects();
        shutdownCalled = false;
    }

    public ResourcePool(int size, ObjectFactory<T> objectFactory, long keepAliveTime) {
        this(size, objectFactory);
        this.keepAliveTime = keepAliveTime;
    }


    public T getObject() {
        if (!shutdownCalled) {
            long now = System.currentTimeMillis();
            long time;
            T t = null;
            try {
                AbstractMap.SimpleEntry<T, Long> object = available.take();
                time = object.getValue();
                if (now - time > keepAliveTime) {
                    available.remove(object);
                    // implement expire(object) method???
                } else {
                    t = object.getKey();
                    inUse.add(t);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return t;
        }
        throw new IllegalStateException("The resource pool is already shutdown");
    }

    public void returnObject(T t) {
        if (t == null) {
            System.out.println("Object is null");
            return;
        }
        inUse.remove(t);
        long now = System.currentTimeMillis();
        available.offer(new AbstractMap.SimpleEntry<>(t, now));
    }

    private void initializeObjects() {
        for (int i = 0; i < size; i++) {
            long now = System.currentTimeMillis();
            AbstractMap.SimpleEntry<T, Long> newObject
                    = new AbstractMap.SimpleEntry<>(objectFactory.createNew(), now);
            available.add(newObject);
        }
    }

    public void shutdown() {
        shutdownCalled = true;
        executor.shutdownNow();
    }
}
