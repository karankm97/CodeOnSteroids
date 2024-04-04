package org.example.strategies;

import org.example.model.EqualSplit;
import org.example.model.Expense;
import org.example.model.Split;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements ISplitStrategy {
    public List<Split> assignSplits(User paidBy, Double amount, List<User> usersInvolved, List<Double> params) {
        Double splitValue = amount/usersInvolved.size();
        List<Split> splits = new ArrayList<>();
        for(int i=0; i<usersInvolved.size(); i++) {
            Split split = new EqualSplit(usersInvolved.get(i), splitValue);
            splits.add(split);
        }

        return splits;
    }
}
