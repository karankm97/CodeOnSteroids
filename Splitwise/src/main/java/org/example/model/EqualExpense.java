package org.example.model;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(String id, Double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(id, amount, paidBy, splits, expenseMetadata);
    }

    public boolean validate() {
        for(Split split : getSplits()) {
            if(!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
