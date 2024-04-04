package org.example.strategies;

import org.example.model.Expense;
import org.example.model.PercentSplit;
import org.example.model.Split;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class PercentSplitStrategy implements ISplitStrategy {
    public List<Split>  assignSplits(User paidBy, Double amount, List<User> usersInvolved, List<Double> params) {
        List<Split> splits = new ArrayList<>();
        for(int i = 0; i<usersInvolved.size(); i++) {
            Double percent = params.get(i);
            Double splitAmount = percent*amount/100.0;
            Split psplit = new PercentSplit(usersInvolved.get(i), splitAmount, percent);
            splits.add(psplit);
        }
        return splits;
    }
}
