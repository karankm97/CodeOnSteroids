package org.example.strategies;

import org.example.model.Expense;
import org.example.model.Split;
import org.example.model.User;

import java.util.List;

public interface ISplitStrategy {
    public List<Split>  assignSplits(User paidBy, Double amount, List<User> usersInvolved, List<Double> params);
}
