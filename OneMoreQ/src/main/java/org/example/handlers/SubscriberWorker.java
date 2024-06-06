package org.example.handlers;

import lombok.SneakyThrows;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class SubscriberWorker implements Runnable {
    Topic topic;
    TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }
    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int offset = topicSubscriber.getOffset().get();
                while (offset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }
                Message message = topic.getMessages().get(offset);
                topicSubscriber.getSubscriber().consume(message);
                topicSubscriber.getOffset().compareAndSet(offset, offset + 1);
            } while(true);
        }
    }

    synchronized public void wakeUp() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify(); //does this mean only one is notified
        }
    }
}
