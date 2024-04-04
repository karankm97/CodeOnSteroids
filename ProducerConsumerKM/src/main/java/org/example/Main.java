package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShareBuffer shareBuffer = new ShareBuffer(3);

        Thread producer = new Thread(() -> {
           for(int i=0; i<6; i++) {
               try {
                   shareBuffer.produce(i);
               } catch (InterruptedException e) {
               }
           }
        });

        Thread consumer = new Thread(() -> {
            for(int i=0; i<6; i++) {
                try {
                    shareBuffer.consume();
                } catch (InterruptedException e) {
                }
            }
        });



        consumer.start();
        producer.start();

    }
}