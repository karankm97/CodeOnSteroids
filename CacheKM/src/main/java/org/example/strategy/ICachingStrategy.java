package org.example.strategy;

public interface ICachingStrategy<K> {
    /*
    * This will tell that a key has been accessed, put or updated
    * so we can put it at the end of our DLL
    * */
    public void keyAccessed(K key);

    /*
    * This will return the key which needs to be evicted
    * The strategy is just an algo and does not take care
    * of operations related to storage eviction
    * however it maintains the LRU
    * */
    public K evictKey();

    public void removeKey(K key);
}
