package com.financeapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize components
        TransactionManager transactionManager = new TransactionManager();
        ExpenseTracker expenseTracker = new ExpenseTracker();
        FinanceTracker financeTracker = new FinanceTracker(transactionManager, expenseTracker); // Integrated FinanceTracker
        User user = new User("Pratik Patil", "pratik.patil@example.com");

        System.out.println("Welcome to the Finance Application, " + user.getName() + "!");
        
        while (true) {
            System.out.println("\n--- Finance Application ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. View Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. View Financial Summary");  // Option to view financial summary
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    transactionManager.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    transactionManager.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter expense category: ");
                    scanner.nextLine(); // Consume newline
                    String category = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    expenseTracker.addExpense(category, expenseAmount);
                    break;
                case 4:
                    expenseTracker.viewExpenses();
                    break;
                case 5:
                    System.out.println("Current Balance: $" + transactionManager.getBalance());
                    break;
                case 6:
                    transactionManager.printTransactionHistory();
                    break;
                case 7:
                    financeTracker.viewFinancialSummary(); // View complete financial summary
                    break;
                case 8:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
