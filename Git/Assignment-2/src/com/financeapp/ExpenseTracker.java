package com.financeapp;

import java.util.HashMap;
import java.util.Map;

public class ExpenseTracker {
    private Map<String, Double> expenses;

    public ExpenseTracker() {
        this.expenses = new HashMap<>();
    }

    // Method to add an expense
    public void addExpense(String category, double amount) {
        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
        System.out.println("Added " + amount + " to " + category + " expense.");
    }

    // Method to view all expenses
    public void viewExpenses() {
        System.out.println("\n--- Expenses ---");
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to get the expenses map
    public Map<String, Double> getExpenses() {
        return expenses;
    }
}
