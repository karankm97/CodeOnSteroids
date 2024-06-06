package org.example.storage;

import org.example.exception.KeyNotFoundException;
import org.example.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K,V> implements IStorage<K,V> {
    private Map<K, V> storage;
    private Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        if(capacity == storage.size()) {
            throw new StorageFullException();
        }
        storage.put(key, value);
    }

    @Override
    public V get(K key) {
        if(!storage.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        return storage.get(key);
    }

    @Override
    public void remove(K key) {
        if(!storage.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        storage.remove(key);
    }
}
