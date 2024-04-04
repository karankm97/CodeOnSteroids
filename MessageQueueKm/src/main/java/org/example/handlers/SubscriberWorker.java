package org.example.handlers;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

@AllArgsConstructor
public class SubscriberWorker implements Runnable {
    private Topic topic;
    private TopicSubscriber topicSubscriber;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int currentOffset = topicSubscriber.getOffset().get();
                while(currentOffset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }
                Message msg = topic.getMessages().get(currentOffset);
                topicSubscriber.getSubscriber().consume(msg);
                topicSubscriber.getOffset().compareAndSet(currentOffset, currentOffset+1);
            } while (true);
        }
    }

    public void wakeIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify(); //new message added
        }
    }
}
