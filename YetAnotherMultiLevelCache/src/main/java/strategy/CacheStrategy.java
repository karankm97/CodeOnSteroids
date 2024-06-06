package strategy;

public interface CacheStrategy<K> {
    public void keyAccessed(K key);
    public K evictKey();
    public void deleteKey(K key);
}
