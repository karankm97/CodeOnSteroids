package org.example.model;

public class Element<K, V> {
    K key;
    V value;
    Long timeStamp; //check how to store time;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
        this.timeStamp = System.currentTimeMillis();
    }
}
