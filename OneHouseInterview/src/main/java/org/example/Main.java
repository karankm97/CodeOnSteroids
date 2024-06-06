package org.example;

import model.ISubscriber;
import model.SleepingSubscriber;
import model.Topic;
import service.QueueService;

import java.util.ArrayDeque;
import java.util.Deque;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Deque<Integer> dq = new ArrayDeque<>();
//        dq.add(1);
//        dq.add(2);
//        dq.add(3);
//        dq.add(4);
//        System.out.println(dq.peek()) ;
        QueueService queueService = new QueueService();;

        Topic topic1 = queueService.createTopic("topic1");
        Topic topic2 = queueService.createTopic("topic2");
        Topic topic3 = queueService.createTopic("topic3");

        ISubscriber sub1 = new SleepingSubscriber("subscriber1");
        queueService.addSubscriber(sub1, topic1);
        queueService.addSubscriber(sub1, topic2);
        queueService.addSubscriber(sub1, topic3);
        queueService.publishMessage(topic1, "message1");
        queueService.publishMessage(topic1, "message4");
        queueService.publishMessage(topic2, "message2");
        queueService.publishMessage(topic2, "message5");
        queueService.publishMessage(topic3, "message3");


//        ISubscriber sub2 = new SleepingSubscriber("subscriber2");
//        ISubscriber sub3 = new SleepingSubscriber("subscriber3");
//
//        queueService.addSubscriber(sub1, topic1);
//        queueService.addSubscriber(sub2, topic1);
//        queueService.addSubscriber(sub3, topic3);
//        queueService.addSubscriber(sub3, topic2);
//
//        queueService.publishMessage(topic1, "message1");
//        queueService.publishMessage(topic1, "message2");
//
//        queueService.publishMessage(topic2, "message3");
//
//        queueService.publishMessage(topic3, "message4");
//
//        Thread.sleep(10000);
//        queueService.publishMessage(topic1, "message5");
//        queueService.publishMessage(topic2, "message6");
    }
}