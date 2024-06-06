package handlers;

import lombok.SneakyThrows;
import model.Topic;
import model.TopicSubscriber;

public class SubscriberWorker implements Runnable{
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
                int currentOffset = topicSubscriber.getOffset().get();
                while (currentOffset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }
                String message = topic.getMessages().get(currentOffset);
                topicSubscriber.getSubscriber().consume(message);
                topicSubscriber.getOffset().compareAndSet(currentOffset, currentOffset + 1); //CAS
            } while (true);
        }
    }

    synchronized public void wakeUp() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
