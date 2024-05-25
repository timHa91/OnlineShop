package org.example.lruCache.impl;

import org.example.lruCache.LRUCache;

import java.util.LinkedHashMap;

public class LRUCacheImpl extends LinkedHashMap<Integer,Integer> implements LRUCache {

    private int capacity;

    public LRUCacheImpl() {
        super(16, 0.75F, true);
    }

    @Override
    public int get(int key) {
        Integer result = super.get(key);
        if (result == null) {
            return -1;
        }
        return result;
    }

    @Override
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
