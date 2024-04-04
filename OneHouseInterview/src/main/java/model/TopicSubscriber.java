package model;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
    ISubscriber subscriber;
    AtomicInteger offset;
    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        offset = new AtomicInteger(0);
    }

//    public void setOffset(int offset) {
//        this.offset = offset;
//    }
}
