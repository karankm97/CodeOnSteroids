package org.example.storage;

import org.example.exception.NotFoundException;
import org.example.exception.StorageFullException;

public interface IStorage<K, V> {
    public void putInStorage(K key, V value) throws StorageFullException;

    public V getFromStorage(K key) throws NotFoundException;

    public void removeFromStorage(K key) throws NotFoundException;
}
