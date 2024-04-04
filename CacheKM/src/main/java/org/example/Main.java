package org.example;

import org.example.cache.ICache;
import org.example.factory.CacheFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CacheFactory cacheFactory = new CacheFactory();
        ICache<Integer, String> cache = cacheFactory.getDefaultCache(5);

        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        cache.put(4, "4");
        cache.put(5, "5");
        cache.get(1);
        cache.put(6, "6");
    }
}