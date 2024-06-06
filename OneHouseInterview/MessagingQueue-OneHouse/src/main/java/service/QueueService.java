package service;

import exceptions.TopicNotFound;
import handlers.TopicHandler;
import model.ISubscriber;
import model.Topic;
import model.TopicSubscriber;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class QueueService {
    Map<String, TopicHandler> topicHandlerMap;

    public QueueService() {
        topicHandlerMap = new ConcurrentHashMap<>();
    }

    //create topic
    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlerMap.put(topic.getTopicId(), topicHandler);
        System.out.println("Created topic with name: " + topic.getTopicName());
        return topic;
    }

    //add subscriber to topic
    public void addSubscriber(ISubscriber subscriber, Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println("Added subscriber to topic: " + topic.getTopicName() + " subcriber: " + subscriber.getId());
    }

    //publish message to topic
    public void publishMessage(Topic topic, String message) {
        topic.addMessage(message);
        if(!topicHandlerMap.containsKey(topic.getTopicId())) {
            throw new TopicNotFound();
        }
        new Thread(() -> topicHandlerMap.get(topic.getTopicId()).publish()).start();
    }
}
