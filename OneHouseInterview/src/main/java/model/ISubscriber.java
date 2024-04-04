package model;

public interface ISubscriber {
    String getId();
    public void consume(String msd) throws InterruptedException;
}
