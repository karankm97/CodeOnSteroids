package org.example.model;

public class Dice {
    private Integer diceCount;

    public Dice(Integer diceCount) {
        this.diceCount = diceCount;
    }

    public Integer rollDice() {
        Integer sum = 0;
        for(int i=0; i<diceCount; i++) {
            sum += (int)(Math.random()*6) + 1;
        }
        return sum;
    }
}
