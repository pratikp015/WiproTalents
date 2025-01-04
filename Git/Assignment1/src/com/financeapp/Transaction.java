package com.financeapp;

import java.util.Date;

public class Transaction {
    private String type;  // Deposit or Withdrawal
    private double amount;
    private Date date;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: $" + amount + ", Date: " + date + ", Description: " + description;
    }
}
