package strategy;

public class LFUCacheStrategy<K> implements  CacheStrategy<K> {

    @Override
    public void keyAccessed(K key) {

    }

    @Override
    public K evictKey() {
        return null;
    }

    @Override
    public void deleteKey(K key) {

    }
}
