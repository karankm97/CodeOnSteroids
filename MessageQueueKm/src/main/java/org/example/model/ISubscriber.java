package org.example.model;

public interface ISubscriber {
    public String getId();
    public void consume(Message msg) throws InterruptedException;
}
