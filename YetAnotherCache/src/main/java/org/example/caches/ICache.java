package org.example.caches;

public interface ICache<K,V> {
    public void put(K key, V value);
    public V get(K key);
    public void remove(K key);
}
