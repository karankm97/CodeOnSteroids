package org.example.model;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
    AtomicInteger offset;
    private final Subscriber subscriber;

    public TopicSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public void consume(Message message) throws InterruptedException {
        subscriber.consume(message);
    }
}
