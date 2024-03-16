package org.example.provider;

import lombok.NonNull;
import org.example.model.ReadResponse;
import org.example.model.WriteResponse;

import java.util.List;

public interface ILevelCache<Key, Value> {
    @NonNull
    WriteResponse set(Key key, Value value);

    @NonNull
    ReadResponse<Value> get(Key key);

    @NonNull
    List<Double> getUsages();
}
