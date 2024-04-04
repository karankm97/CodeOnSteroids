package org.example.strategies;

import org.example.model.EqualSplit;
import org.example.model.Expense;
import org.example.model.Split;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitStrategy implements ISplitStrategy {

    public List<Split> assignSplits(User paidBy, Double amount, List<User> usersInvolved, List<Double> params) {
        List<Split> splits = new ArrayList<>();

        for(int i=0; i<usersInvolved.size(); i++) {
            splits.add(new EqualSplit(usersInvolved.get(i), params.get(i)));
        }
        return splits;
    }
}
