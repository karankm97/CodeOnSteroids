package model;

import lombok.Getter;

@Getter
public class ReadResponse<V> {
    V value;
    Integer readTime;

    public ReadResponse(V value, Integer readTime) {
        this.value = value;
        this.readTime = readTime;
    }
}
