package storage;

public interface Storage<K, V> {
    public void put(K key, V value);

    public V get(K key);

    public void delete(K key);
}
