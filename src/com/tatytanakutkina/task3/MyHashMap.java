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


    // можно не делать
    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    @Override
    public Object remove(Object o) {
        return null;
    }

    @Override
    public void putAll(Map map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
