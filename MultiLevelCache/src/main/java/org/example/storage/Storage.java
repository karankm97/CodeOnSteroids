package org.example.storage;

import org.example.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key);
    Value get(Key key);
    double getCurrentUsage();
}
