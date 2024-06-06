package org.example.model;

public interface Subscriber {
    public void consume(Message message) throws InterruptedException;

    public String getId();
}
