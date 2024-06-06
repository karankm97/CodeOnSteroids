package handlers;


import model.Topic;
import model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

/*
every topic will have its own handler
 */
public class TopicHandler {
    Topic topic;

    Map<String, SubscriberWorker> subscriberWorkerMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkerMap  = new HashMap<>();
    }

    public void publish() {
        for(TopicSubscriber topicSubscriber : topic.getTopicSibscriberList()) {
            //start out subscriber worker
            startWorker(topicSubscriber);
        }
    }

    private void startWorker(TopicSubscriber topicSubscriber) {
        String id = topicSubscriber.getSubscriber().getId();
        if(!subscriberWorkerMap.containsKey(id)) {
            //create new worker and assign to thread
            SubscriberWorker worker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkerMap.put(id, worker);
            new Thread(worker).start();
        }

        SubscriberWorker worker = subscriberWorkerMap.get(id);
        //wake up the thread if waitig
        worker.wakeUp();
    }
}
