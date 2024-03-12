package org.example.cache.factories;

//import com.example.cache.Cache;

import org.example.cache.Cache;
import org.example.cache.policies.LRUEvictionPolicy;
import org.example.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
