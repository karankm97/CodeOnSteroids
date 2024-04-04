package org.example.model;

import lombok.Getter;
import lombok.Setter;

public class Player {
    @Setter
    @Getter
    private Integer id;
    private Integer currentPosition;

    public Player(Integer id, Integer initialPosition) {
        currentPosition = initialPosition;
        this.id = id;
    }

    public Integer getCurrentPosition() {
        return  currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }
}
