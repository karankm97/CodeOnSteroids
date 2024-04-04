package org.example.storage;

import org.example.exception.NotFoundException;
import org.example.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashBasedStorage<K, V> implements IStorage<K, V> {
    Map<K, V> keyValueStore;
    Integer capacity;

    public HashBasedStorage(Integer capacity) {
        keyValueStore = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void putInStorage(K key, V value) throws StorageFullException {
        if(isStorageFull()) {
            throw new StorageFullException();
        }
        keyValueStore.put(key, value);
    }

    @Override
    public V getFromStorage(K key) throws NotFoundException {
        if(!keyValueStore.containsKey(key)) {
            throw new NotFoundException();
        }
        return keyValueStore.get(key);
    }

    @Override
    public void removeFromStorage(K key) throws NotFoundException {
        if(!keyValueStore.containsKey(key)) {
            throw new NotFoundException();
        }
        keyValueStore.remove(key);
    }

    private boolean isStorageFull() {
        return capacity == keyValueStore.size();
    }
}
