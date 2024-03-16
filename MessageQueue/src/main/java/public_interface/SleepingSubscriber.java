package public_interface;

import model.ISubscriber;
import model.Message;

public class SleepingSubscriber implements ISubscriber {
    private final String id;
    private final int sleepTime;

    public SleepingSubscriber(String id, int sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getMsg());
        Thread.sleep(sleepTime);
        System.out.println("Subscriber: " + id + " done consuming: " + message.getMsg());
    }
}
