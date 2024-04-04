package org.example.model;

public class SleepSubscriber implements  ISubscriber {
    private String id;

    public String getId() {
        return id;
    }

    public void consume(Message msg) throws  InterruptedException {
        System.out.println("Subscriber: " + id + " has started consuming msg: " + msg.getMessage());
        Thread.sleep(1000);
        System.out.println("Subscriber: " + id + " has consumed msg: " + msg.getMessage());
    }
}
