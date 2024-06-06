package org.example.caches;

import org.example.exception.KeyNotFoundException;
import org.example.exception.StorageFullException;
import org.example.storage.IStorage;
import org.example.strategy.ICachingStrategy;

public class DefaultCache<K,V> implements ICache<K,V> {

    private ICachingStrategy<K> cachingStrategy;
    private IStorage<K,V> storage;

    public DefaultCache(IStorage<K,V> storage, ICachingStrategy<K> cachingStrategy) {
        this.cachingStrategy = cachingStrategy;
        this.storage = storage;
    }

    @Override
    public void put(K key, V value) {
        System.out.println("Trying to put key: " + key + " value: " + value);
        try {
            storage.put(key, value);
            cachingStrategy.keyAccessed(key);
        } catch (StorageFullException ex) {
            System.out.println("Storage full! Need to evict!");
            K keyToEvict = cachingStrategy.evictKey();
            storage.remove(keyToEvict);
            System.out.println("Successfully evicted key: " + keyToEvict);
            put(key, value);
        }
    }

    @Override
    public V get(K key) {
        System.out.println("Searching for key: " + key);
        try {
            cachingStrategy.keyAccessed(key);
            V value = storage.get(key);
            System.out.println("Key found with value: " + value);
            return value;
        } catch (KeyNotFoundException ex) {
            System.out.println("Given key not found!");
        }
        return null;
    }

//    public static void f1() {
//
//    }
//
//    public void f1() {
//
//    }

    @Override
    public void remove(K key) {
        System.out.println("Trying to delete key: " + key);
        try {
            storage.remove(key);
            cachingStrategy.removeKey(key);
            System.out.println("Successfully removed key: " +  key);
        } catch (KeyNotFoundException ex) {
            System.out.println("Given key not found!");
        }
    }
}
