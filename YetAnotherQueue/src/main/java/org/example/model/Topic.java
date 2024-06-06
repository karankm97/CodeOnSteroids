package org.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    private String topicId;
    private String topicName;
    private List<Message> messageList;

    private List<TopicSubscriber> subscribers;

    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        messageList = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public synchronized void addMessage(Message msg) {
        messageList.add(msg);
    }

    public void addSubscriber(ISubscriber subscriber) {
        subscribers.add(new TopicSubscriber(subscriber));
    }
}
