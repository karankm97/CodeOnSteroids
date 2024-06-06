package model;

import lombok.AllArgsConstructor;
import lombok.Getter;


 public class SleepingSubscriber implements  ISubscriber {
     String id;

     public SleepingSubscriber(String id) {
         this.id= id;
     }

     public  String getId() {
         return id;
     }
    public void consume(String msg) throws InterruptedException {
        System.out.println("Started consuming message: " + msg + " by " + id);
        Thread.sleep(5000);
        System.out.println("Done consuming message: " + msg + " by " + id);
    }
}
