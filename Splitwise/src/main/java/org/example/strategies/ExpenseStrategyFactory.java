package org.example.strategies;

import org.example.model.ExpenseType;

public class ExpenseStrategyFactory {
    public static  ISplitStrategy createExpenseStrategy(ExpenseType expenseType) {
        switch(expenseType) {
            case EXACT:
                return new ExactSplitStrategy();

            case EQUAL:
                return new EqualSplitStrategy();

            case PERCENT:
                return  new PercentSplitStrategy();
        }
        return null;
    }
}
