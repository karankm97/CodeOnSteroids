package org.example.handler;

import lombok.SneakyThrows;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

public class SubscriberWorker implements Runnable {

    private Topic topic;
    private TopicSubscriber subscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber subscriber) {
        this.topic = topic;
        this.subscriber = subscriber;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (subscriber) {
            do {
                int currOffest = subscriber.getOffset().get();
                while(currOffest >= topic.getMessageList().size()) {
                    subscriber.wait();;
                }

                Message msg = topic.getMessageList().get(currOffest);
                subscriber.getSubscriber().consumeMessage(msg);
                subscriber.getOffset().compareAndSet(currOffest, currOffest + 1);
            } while(true);
        }
    }

    public void wakeUp() {
        synchronized (subscriber) {
            subscriber.notify();
        }
    }
}
