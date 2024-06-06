package org.example.model;

public interface ISubscriber {
    public String getId();
    public void consumeMessage(Message msg) throws InterruptedException;
}
