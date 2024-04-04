package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public abstract class Expense {
    private final String id;
    private final Double amount;
    private final User paidBy;
    //private final Integer totalUsers;
    private List<Split> splits;
    private final ExpenseMetadata expenseMetadata;

    public abstract boolean validate();
}
