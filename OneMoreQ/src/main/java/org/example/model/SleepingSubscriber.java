package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SleepingSubscriber implements Subscriber {
    String id;

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subcriber " + id + " started consuming message: " + message.getMessage());
        Thread.sleep(1000);
        System.out.println("Subscriber " + id + " is done cosuming message: " + message.getMessage());
    }
}
