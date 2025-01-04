package com.financeapp;

import java.util.Map;

public class FinanceTracker {
    private TransactionManager transactionManager;
    private ExpenseTracker expenseTracker;

    public FinanceTracker(TransactionManager transactionManager, ExpenseTracker expenseTracker) {
        this.transactionManager = transactionManager;
        this.expenseTracker = expenseTracker;
    }

    public void viewFinancialSummary() {
        double totalExpenses = 0.0;
        System.out.println("\n--- Financial Summary ---");
        System.out.println("Balance: $" + transactionManager.getBalance());
        
        // Calculate total expenses
        for (Map.Entry<String, Double> entry : expenseTracker.getExpenses().entrySet()) {
            totalExpenses += entry.getValue();
        }

        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Remaining Balance after Expenses: $" + (transactionManager.getBalance() - totalExpenses));
    }
}
