package org.example.handler;

import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private Topic topic;
    private Map<String, SubscriberWorker> workerMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        workerMap = new HashMap<>();
    }

    public void publishToAll() {
        for(TopicSubscriber subscriber : topic.getSubscribers()) {
            //publish it
            tryPublish(subscriber);
        }
    }

    public void tryPublish(TopicSubscriber subscriber) {
        String uuid = subscriber.getSubscriber().getId();
        if(!workerMap.containsKey(uuid)) {
            //create and start thread
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic, subscriber);
            workerMap.put(uuid, subscriberWorker);
            new Thread(subscriberWorker).start();
        }

        //notify thread. offload this duty to subscriber worker
        workerMap.get(uuid).wakeUp();
    }
}
