package org.example.storage;

public interface IStorage<K, V> {
    public void put(K key, V value);
    public V get(K key);
    public void remove(K key);
}
