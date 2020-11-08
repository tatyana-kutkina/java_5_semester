package com.tatytanakutkina.task2;

import java.util.*;

public class MyList implements List {

    Object[] listArray;
    int maxSize;
    int currentSize;
    private static final int defaultSize = 20;

    public MyList(int maxSize) {
        this.maxSize = maxSize;
        listArray = new Object[maxSize];
        currentSize = 0;
    }

    public MyList() {
        this(defaultSize);
    }


    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }


    @Override
    public boolean add(Object o) {
        if (currentSize >= maxSize) {
            this.resize();
        }
        listArray[currentSize++] = o;
        return true;

    }


    @Override
    public void add(int i, Object o) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (i > maxSize) {
            throw new IndexOutOfBoundsException("Index is greater than maximum allowable size");
        }
        if(i <= currentSize){
            if (currentSize >= maxSize) {
                this.resize();
            }
            System.arraycopy(listArray, i, listArray, i + 1, currentSize - i);

            listArray[i] = o;
            currentSize++;
        }
        else{
            throw new RuntimeException("Index is out of allowable zone");
        }


    }


    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < currentSize; i++) {
            if (listArray[i].equals(o)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Object get(int i) {
        if (i >= currentSize || i < 0) {
            throw new NoSuchElementException("Element with this index doesn't exist in the list");
        }
        return listArray[i];
    }


    @Override
    public Object remove(int i) {
        if (i >= currentSize || i < 0) {
            throw new NoSuchElementException("Element with this index doesn't exist in the list");
        }
        Object object = listArray[i];
        for (int j = i; j < currentSize - 1; j++) {
            listArray[j] = listArray[j + 1];
        }
        currentSize--;
        return object;
    }

    @Override
    public int size() {
        return currentSize;
    }

    public void resize() {
        Object[] b = new Object[2 * maxSize];
        if (maxSize >= 0) System.arraycopy(listArray, 0, b, 0, maxSize);
        listArray = b;
        maxSize *= 2;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public Object[] toArray(Object[] objects) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public Object set(int i, Object o) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public ListIterator listIterator(int i) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public List subList(int i, int i1) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }

    @Override
    public boolean containsAll(Collection collection) {
        throw new UnsupportedOperationException("Invalid operation for sorted MyList.");
    }
}
