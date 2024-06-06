package org.example.handlers;

import lombok.SneakyThrows;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    Topic topic;
    Map<String, SubscriberWorker> subscriberWorkerMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        subscriberWorkerMap = new HashMap<>();
    }

    public void publish() {
        for(TopicSubscriber topicSubscriber : topic.getSubscribers()) {

        }
    }

    public void startWorker(TopicSubscriber subscriber) {
        String subscriberId = subscriber.getSubscriber().getId();
        if(!subscriberWorkerMap.containsKey(subscriberId)) {
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic, subscriber);
            subscriberWorkerMap.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }

        SubscriberWorker worker = subscriberWorkerMap.get(subscriberId);
        //wake up the thread if waitig
        worker.wakeUp();
    }
}
