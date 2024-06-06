package cache;

import model.LevelCacheData;
import model.ReadResponse;
import model.WriteResponse;

public class LevelCache<K,V> implements Cache<K,V> {
    DefaultCache<K,V> cache;
    LevelCacheData data;

    Cache<K,V> next;

    public LevelCache(DefaultCache<K,V> cache, LevelCacheData data, Cache<K,V> next) {
        this.cache = cache;
        this.data = data;
        this.next = next;
    }
    @Override
    public WriteResponse put(K key, V value) {
        Integer time = 0;
        V val = cache.get(key);
        time += data.getReadTime();

        if(!val.equals(value)) {
            cache.put(key, value);
            time += data.getWriteTime();

        }

        time += next.put(key, val).getWriteTime();
        return new WriteResponse(time);
    }

    @Override
    public ReadResponse<V> get(K key) {
        Integer time = 0;
        V val = cache.get(key);
        time += data.getReadTime();

        if(val == null) {
            ReadResponse<V> resp = next.get(key);
            time += resp.getReadTime();
            val = resp.getValue();
            if(val != null) {
                cache.put(key, val);
                time += data.getWriteTime();
            }
        }

        return new ReadResponse<V>(val, time);
    }

    @Override
    public void delete(K key) {

    }
}
