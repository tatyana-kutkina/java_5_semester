package com.tatytanakutkina.task3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap implements Map {

    MyHashTable<Object, Object> storage;

    public MyHashMap() {
        this.storage = new MyHashTable<>();
    }

    @Override
    public boolean isEmpty() {
        return storage.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return storage.contains(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return storage.add(key, value);
    }

    @Override
    public Object get(Object key) {
        return storage.get(key);
    }

    @Override
    public int size() {
        return storage.size();
    }


    @Override
    public boolean containsValue(Object o) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public Object remove(Object o) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public Set<Entry> entrySet() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }
}
