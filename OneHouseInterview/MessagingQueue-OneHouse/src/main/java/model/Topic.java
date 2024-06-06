package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    String topicName;
    String topicId;
    List<TopicSubscriber> topicSibscriberList;
    List<String> messages;

    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId =topicId;
        topicSibscriberList = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addSubscriber(TopicSubscriber subscriber) {
        topicSibscriberList.add(subscriber);
    }
}
