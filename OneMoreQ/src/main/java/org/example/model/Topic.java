package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    private final String id;
    private final String name;
    List<Message> messages; // do these lists need to be concurrent?
    List<TopicSubscriber> subscribers;

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
        messages = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public void sendMessage(Message message) {
        messages.add(message);
    }

    public void addSubscriber(TopicSubscriber subscriber) {
        subscribers.add(subscriber);
    }
}
