package org.example;

import java.util.List;
import java.util.Map;

public interface IDbAdapter<T> {
    public List<T> get(String entity, List<Filter> filters);
}
