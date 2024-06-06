package cache;

import exception.StorageFullException;
import storage.Storage;
import strategy.CacheStrategy;

public class DefaultCache<K,V> {
    CacheStrategy<K> strategy;
    Storage<K,V> storage;

    public DefaultCache(CacheStrategy<K> strategy, Storage<K,V> storage) {
        this.storage = storage;
        this.strategy = strategy;
    }

    public void put(K key, V value) {
        try {
            storage.put(key, value);
            strategy.keyAccessed(key);
        } catch (StorageFullException ex) {
            K keyToEvict = strategy.evictKey();
            storage.delete(key);
            put(key, value);
        }
    }

    public V get(K key) {
        V value = storage.get(key);
        if (value != null) {
            strategy.keyAccessed(key);
        }
        return value;
    }

    public void delete(K key) {
        strategy.deleteKey(key);
        storage.delete(key);
    }
}
