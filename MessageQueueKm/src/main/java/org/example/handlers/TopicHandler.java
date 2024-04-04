package org.example.handlers;

import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private Topic topic;
    private Map<String, SubscriberWorker> workers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        workers = new HashMap<>();
    }

    public void publishMessage() {
        for (TopicSubscriber subscriber : topic.getSubscribers()) {
            startSubscriberWorker(subscriber);
        }
    }

    public void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        String subcriberId = topicSubscriber.getSubscriber().getId();
        if (!workers.containsKey(subcriberId)) {
            SubscriberWorker worker = new SubscriberWorker(topic, topicSubscriber);
            workers.put(subcriberId, worker);
            new Thread(worker).start();
        }
        workers.get(subcriberId).wakeIfNeeded();
    }
}
