package org.example.algorithms;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter {
    private int requestLimit; //max requests allowed in given time
    private long timeLimit; //no of mili seconds, basically size of our sliding window in ms

    private Queue<Long> slidingWindow;

    public SlidingWindow(int requestLimit, long timeLimit) {
        this.requestLimit = requestLimit;
        this.timeLimit = timeLimit;
        slidingWindow = new ConcurrentLinkedQueue<>();
    }
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        updateSlidingWindow(currentTime);
        if(slidingWindow.size() < requestLimit) {
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }

    private void updateSlidingWindow(long currentTime) {
        // we need to poll out all the entries which are outdated
        if(slidingWindow.isEmpty()) return;
        long oldestTime = slidingWindow.peek();
        long offSetTime = currentTime - oldestTime;
        while(offSetTime >= timeLimit) {
            slidingWindow.poll();
            if (slidingWindow.isEmpty()) return;
            offSetTime = currentTime - slidingWindow.peek();
        }
    }
}
