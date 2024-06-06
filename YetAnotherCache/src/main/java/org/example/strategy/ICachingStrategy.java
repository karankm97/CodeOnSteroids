package org.example.strategy;

public interface ICachingStrategy<K> {
    public void keyAccessed(K key);
    public K evictKey();

    public void removeKey(K key);
}
