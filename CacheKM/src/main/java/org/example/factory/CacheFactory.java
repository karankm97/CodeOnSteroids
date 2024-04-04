package org.example.factory;

import org.example.cache.DefaultCache;
import org.example.cache.ICache;
import org.example.storage.HashBasedStorage;
import org.example.storage.IStorage;
import org.example.strategy.ICachingStrategy;
import org.example.strategy.LRUCachingStrategy;

public class CacheFactory<K, V> {
    public  ICache<K, V> getDefaultCache(Integer capacity)  {
        return new DefaultCache<K,V>(new LRUCachingStrategy<K>(), new HashBasedStorage<K, V>(capacity));
    }
}
