package org.example.provider;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.LevelCacheData;
import org.example.model.ReadResponse;
import org.example.model.WriteResponse;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class DefaultLevelCache<Key, Value> implements ILevelCache<Key, Value> {
    private final LevelCacheData levelCacheData;
    private final CacheProvider<Key, Value> cacheProvider;

    @NonNull
    private final ILevelCache<Key, Value> next;

    @NonNull
    public WriteResponse set(Key key, Value value) {
        Double curTime = 0.0;
        Value curLevelValue = cacheProvider.get(key);
        curTime += levelCacheData.getReadTime();
        if (!value.equals(curLevelValue)) {
            cacheProvider.set(key, value);
            curTime += levelCacheData.getWriteTime();
        }

        curTime += next.set(key, value).getTimeTaken();
        return new WriteResponse(curTime);
    }

    @NonNull
    public ReadResponse<Value> get(Key key) {
        Double curTime = 0.0;
        Value curLevelValue = cacheProvider.get(key);
        curTime += levelCacheData.getReadTime();

        if (curLevelValue == null) {
            ReadResponse<Value> nextResponse = next.get(key);
            curTime += nextResponse.getTotalTime();
            curLevelValue = nextResponse.getValue();
            if (curLevelValue != null) {
                cacheProvider.set(key, curLevelValue); //not recursive set, be careful here
                curTime += levelCacheData.getWriteTime();
            }
        }

        return new ReadResponse<>(curLevelValue, curTime);
    }

    @NonNull
    public List<Double> getUsages() {
        final List<Double> usages;
        if(next == null) { //always false, can be removed
            usages = Collections.emptyList();
        } else {
            usages = next.getUsages();
        }
        usages.add(0, cacheProvider.getCurrentUsage());
        return usages;
    }
}
