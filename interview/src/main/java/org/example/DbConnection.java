package org.example;

import java.util.List;

public interface DbConnection<T> {
    public List<T> submit(String query);
}
