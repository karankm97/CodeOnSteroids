package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ShareBuffer {
    Queue<Integer> sharedQ;
    int bufferSize;

    public ShareBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
        sharedQ = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        System.out.println("Trying to produce");
        while(bufferSize == sharedQ.size()) {
            System.out.println("Buffer is full. Let's wait!");
            wait();
        }

        System.out.println("Producing started");
        sharedQ.add(item);
        System.out.println("Done producing. Notifying.");
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        System.out.println("Trying to consumer");
        while (sharedQ.size() == 0) {
            System.out.println("Buffer is empty. Let's wait!");
            wait();
        }

        System.out.println("Consuming: " + String.valueOf(sharedQ.poll()));
        System.out.println("Done consuming. Notifying");
        notify();
    }
}
