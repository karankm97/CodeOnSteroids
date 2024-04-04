package org.example;

import org.example.algorithms.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserSlidingWindow {
    Map<Integer, SlidingWindow> buckets;

    public UserSlidingWindow(int id) {
        buckets = new HashMap<>();
        buckets.put(id, new SlidingWindow(1000, 10));
    }

    void accessApplication(int id) {
        if(buckets.get(id).grantAccess()) {
            System.out.println("Able to access");
        } else {
            System.out.println("Too many requests");
        }
    }

}
