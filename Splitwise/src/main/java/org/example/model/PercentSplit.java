package org.example.model;

import lombok.Getter;

@Getter
public class PercentSplit extends  Split {

    private final Double percent;
    public PercentSplit(User user, Double amount, Double percent) {
        super(user, amount);
        this.percent = percent;
    }
}
