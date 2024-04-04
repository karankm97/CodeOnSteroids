package org.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    private String topicId;
    private String topicName;
    private List<TopicSubscriber> subscribers;
    private List<Message> messages;

    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        subscribers = new ArrayList<>();
        messages = new ArrayList<>();
    }


    public void addSubscriber(TopicSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
