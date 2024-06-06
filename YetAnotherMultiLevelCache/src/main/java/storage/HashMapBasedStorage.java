package storage;

import exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K,V> implements Storage<K,V> {
    Map<K,V> storage = new HashMap<>();
    Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        storage = new HashMap<>();
        this.capacity = capacity;
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
        return storage.get(key);
    }

    @Override
    public void delete(K key) {
        storage.remove(key);
    }
}
