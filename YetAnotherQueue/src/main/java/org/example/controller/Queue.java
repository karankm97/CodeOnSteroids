package org.example.controller;

import org.example.handler.TopicHandler;
import org.example.model.ISubscriber;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    private Map<String, TopicHandler> handlerMap;

    public Queue() {
        handlerMap = new HashMap<>();
    }
    public void addTopic(String topicName) {
        String topicId = UUID.randomUUID().toString();
        Topic topic = new Topic(topicName, topicId);
        TopicHandler handler = new TopicHandler(topic);
        handlerMap.put(topicId, handler);
    }


    public void addSubscriber(Topic topic, ISubscriber subscriber) {
        topic.addSubscriber(subscriber);
    }

    public void publish(Topic topic, Message msg) {
        topic.addMessage(msg);
        TopicHandler handler = handlerMap.get(topic.getTopicId());
        new Thread(handler::publishToAll).start();
    }

    public void resetOffSet(Topic topic, ISubscriber subscriber, Integer newOffset) {
        for(TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            if(topicSubscriber.getSubscriber().getId().equals(subscriber.getId())) {
                topicSubscriber.getOffset().set(newOffset);
                TopicHandler handler = handlerMap.get(topic.getTopicId());
                new Thread(() -> handler.tryPublish(topicSubscriber)).start();
                break;
            }
        }
    }
}
