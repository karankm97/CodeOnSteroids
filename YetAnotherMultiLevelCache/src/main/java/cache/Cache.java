package cache;

import model.ReadResponse;
import model.WriteResponse;

public interface Cache<K,V> {
    public WriteResponse put(K key, V value);

    public ReadResponse<V> get(K key);

    public void delete(K key);
}
