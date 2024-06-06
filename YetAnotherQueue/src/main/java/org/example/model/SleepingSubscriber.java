package org.example.model;

public class SleepingSubscriber implements ISubscriber {
    private String id;
    public String getId() {
        return id;
    }

    public void consumeMessage(Message msg) throws InterruptedException {
        System.out.println("Started consuming message: " + msg.getMsg() + " by subscriber: " + id);
        Thread.sleep(1000);
        System.out.println("Finished coming message: " + msg.getMsg() + " by subscriber: " + id);
    }
}
