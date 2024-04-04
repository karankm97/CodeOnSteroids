package org.example.cache;

import org.example.exception.NotFoundException;
import org.example.exception.StorageFullException;
import org.example.storage.IStorage;
import org.example.strategy.ICachingStrategy;

public class DefaultCache<K,V> implements ICache<K,V> {
    /*
    * Caching Strategy
    * Storage
    * */

    ICachingStrategy<K> cachingStrategy;
    IStorage<K, V> storage;

    public DefaultCache(ICachingStrategy<K> cachingStrategy, IStorage<K,V> storage) {
        this.cachingStrategy = cachingStrategy;
        this.storage = storage;
    }

    public V get(K key) {
        try {
            V value = storage.getFromStorage(key);
            cachingStrategy.keyAccessed(key);
            return value;
        } catch (NotFoundException ex) {
            System.out.println("Did not find key");
            return null;
        }
    }

    public void put(K key, V value) {
        try {
            storage.putInStorage(key, value);
            cachingStrategy.keyAccessed(key);
            System.out.println("Put operation successful for key: " + key + " and value: " + value);
        } catch (StorageFullException ex) {
            System.out.println("Storage is full. Need to evict!");
            K keyToEvict = cachingStrategy.evictKey();
            if(keyToEvict == null) {
                throw new RuntimeException("Unexpected State");
            }
            storage.removeFromStorage(keyToEvict);
            System.out.println("Successfully evicted the key: " + keyToEvict);
            put(key, value);
        }
    }

    public void remove(K key) {
        try {
            storage.removeFromStorage(key);
            cachingStrategy.removeKey(key);
        } catch (NotFoundException ex) {
            System.out.println("Key not found: " + key);
        }
    }
}
