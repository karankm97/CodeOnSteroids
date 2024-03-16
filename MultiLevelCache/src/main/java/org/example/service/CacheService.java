package org.example.service;

import lombok.NonNull;
import org.example.model.ReadResponse;
import org.example.model.StatsResponse;
import org.example.model.WriteResponse;
import org.example.provider.ILevelCache;

import java.util.ArrayList;
import java.util.List;

public class CacheService<Key, Value> {
    private final ILevelCache<Key, Value> multiLevelCache;
    private final List<Double> lastReadTimes;
    private final List<Double> lastWriteTimes;
    private final int lasCount;

    public CacheService(@NonNull final ILevelCache<Key, Value> multiLevelCache, final int lasCount) {
        this.multiLevelCache = multiLevelCache;
        this.lasCount = lasCount;
        this.lastReadTimes = new ArrayList<>(lasCount);
        this.lastWriteTimes = new ArrayList<>(lasCount);
    }

    public WriteResponse set(@NonNull final Key key, @NonNull final Value value) {
        final WriteResponse writeResponse = multiLevelCache.set(key, value);
        addTimes(lastReadTimes, writeResponse.getTimeTaken());
        return writeResponse;
    }

    public ReadResponse<Value> get(@NonNull final Key key) {
        final ReadResponse<Value> readResponse = multiLevelCache.get(key);
        addTimes(lastReadTimes, readResponse.getTotalTime());
        return readResponse;
    }

    public StatsResponse stats() {
        return new StatsResponse(getAvgReadTime(), getAvgWriteTime(), multiLevelCache.getUsages());
    }

    private Double getAvgReadTime() {
        return getSum(lastReadTimes)/lastReadTimes.size();
    }

    private Double getAvgWriteTime() {
        return getSum(lastWriteTimes)/ lastWriteTimes.size();
    }

    private void addTimes(List<Double> times, Double time) {
        if(times.size() == this.lasCount) {
            times.remove(0);
        }

        times.add(time);
    }

    private Double getSum(List<Double> times) {
        Double sum = 0.0;
        for(Double time : times) {
            sum += time;
        }
        return sum;
    }
}
