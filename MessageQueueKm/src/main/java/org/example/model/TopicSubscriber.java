package org.example.model;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
    private ISubscriber subscriber;
    private AtomicInteger offset;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        offset = new AtomicInteger(0);
    }
}
