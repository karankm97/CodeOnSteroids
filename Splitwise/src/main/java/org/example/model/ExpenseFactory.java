package org.example.model;

import java.util.List;

import static org.example.model.ExpenseType.EQUAL;
import static org.example.model.ExpenseType.PERCENT;

public class ExpenseFactory {
    public static Expense createExpense(ExpenseType expenseType, String id, Double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        switch (expenseType) {
            case EQUAL:
                return new EqualExpense(id, amount, paidBy, splits, expenseMetadata);
            case PERCENT:
                return new PercentExpense(id, amount, paidBy, splits, expenseMetadata);
            case EXACT:
                return  new ExactExpense(id, amount, paidBy, splits, expenseMetadata);

        }
        return  null;
    }
}
