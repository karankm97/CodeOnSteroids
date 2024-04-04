package org.example.service;

import org.example.model.*;
import org.example.strategies.ExactSplitStrategy;
import org.example.strategies.ExpenseStrategyFactory;
import org.example.strategies.ISplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SplitService {
    public Expense createExpense(ExpenseType expenseType, String id, Double amount, User paidBy, List<User> usersInvolved, ExpenseMetadata expenseMetadata, List<Double> params) {
        ISplitStrategy strategy = ExpenseStrategyFactory.createExpenseStrategy(expenseType);
        List<Split> splits = strategy.assignSplits(paidBy, amount, usersInvolved, params);
        Expense expense = ExpenseFactory.createExpense(expenseType, id, amount, paidBy, splits, expenseMetadata);
        return  expense;
    }
}
