package org.example.provider;

import org.example.exceptions.StorageFullException;
import org.example.policy.EvictionPolicy;
import org.example.storage.Storage;

public class CacheProvider<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public CacheProvider(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void set(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            final Key keyToRemove = this.evictionPolicy.evictKey();
            if(keyToRemove == null) {
                throw new RuntimeException("Unexpected State");
            }

            this.storage.remove(keyToRemove);
            set(key, value);
        }
    }

    public Value get(Key key) {
        final Value value = this.storage.get(key);
        this.evictionPolicy.keyAccessed(key);
        return value;
    }

    public double getCurrentUsage() {
        return this.storage.getCurrentUsage();
    }
}
