package public_interface;

import handler.TopicHandler;
import lombok.NonNull;
import model.ISubscriber;
import model.Message;
import model.Topic;
import model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    private final Map<String, TopicHandler> topicProcessors;

    public Queue() {
        this.topicProcessors = new HashMap<>();
    }

    public Topic createTopic(@NonNull final String topicName) {
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(), topicHandler);
        System.out.println("Created topic: " + topic.getTopicName());
        return topic;
    }

    public void subscribe(@NonNull final ISubscriber subscriber, @NonNull final Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    public void publish(@NonNull final Topic topic, @NonNull final Message message) {
        topic.addMessage(message);
        System.out.println(message.getMsg() + " published to topic: " + topic.getTopicName());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffSet(@NonNull final Topic topic, @NonNull final ISubscriber subscriber, @NonNull final Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicProcessors.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}

/*
Node: 2 x: -1 y: 1 pos: 1
Node: 3 x: 1 y: 1 pos: 2
Node: 4 x: -2 y: 0 pos: 3
Node: 6 x: 0 y: 0 pos: 4
Node: 5 x: 0 y: 2 pos: 5
Node: 7 x: 2 y: 2 pos: 6
*/

/*
Node: 2 x: -1 y: 1 pos: 1
Node: 3 x: 1 y: 1 pos: 2
Node: 4 x: -2 y: 2 pos: 3
Node: 6 x: 0 y: 2 pos: 4
Node: 5 x: 0 y: 2 pos: 5
Node: 7 x: 2 y: 2 pos: 6
 */