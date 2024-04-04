package org.example.handlers;

import lombok.AllArgsConstructor;
import org.example.model.ISubscriber;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.TopicSubscriber;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Flow;

@AllArgsConstructor
public class Queue {
    private Map<String, TopicHandler> topics;
    public Topic addTopic(String topicName) {
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topics.put(topic.getTopicId(), topicHandler);
        System.out.println("Created topic: " + topic.getTopicName());
        return topic;
    }

    public void addSubscriber(ISubscriber subscriber, Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
    }

    public void publish(Topic topic, Message message) {
        topic.addMessage(message);
        TopicHandler handler = topics.get(topic.getTopicId());
        new Thread(handler::publishMessage).start();
    }

    public void resetOffset(Topic topic, ISubscriber subscriber, Integer newOffset) {
        for(TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            if(topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                new Thread(() -> topics.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}
