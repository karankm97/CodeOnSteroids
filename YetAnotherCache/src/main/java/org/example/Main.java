package org.example;

import org.example.caches.DefaultCache;
import org.example.caches.ICache;
import org.example.storage.HashMapBasedStorage;
import org.example.storage.IStorage;
import org.example.strategy.ICachingStrategy;
import org.example.strategy.LFUCachingStrategy;
import org.example.strategy.LRUCachingStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        IStorage<Integer, Integer> storage = new HashMapBasedStorage<>(5);
//        ICachingStrategy<Integer> strategy = new LFUCachingStrategy<>();
//        ICache<Integer, Integer>  cache = new DefaultCache<>(storage, strategy);
//
//
//        cache.put(1, 1);
//        cache.get(1);
//        cache.get(1);
//        cache.get(1);
//        cache.put(2, 2);
//        cache.get(2);
//        cache.get(2);
//        cache.put(3, 3);
//        cache.put(4, 4);
//        cache.put(5, 5);
//        cache.put(6, 6);
//        cache.get(2);
//        cache.put(7, 7);
        try {
            f1();
        }
        finally {
            System.out.println("bye");
        }
    }

    public static void f1() {
        throw new RuntimeException("a");
    }
}