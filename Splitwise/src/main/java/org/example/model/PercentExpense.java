package org.example.model;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(String id, Double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(id, amount, paidBy, splits, expenseMetadata);
    }

    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentSplit exactSplit = (PercentSplit) split;
            sumSplitPercent += exactSplit.getPercent();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}
