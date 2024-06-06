package org.example;

import java.util.ArrayList;
import java.util.List;

public class ApiFilterService<T> {
    //orders
    //users
    //products
    //data access object to get the data from
    IDbAdapter iDbAdapter;
    List<T> getData(String entity, List<Filter> filters) {
        //how to map entity to order, product, etc
        filters.contains(new Filter());
        return new ArrayList<>();
    }
}
