package com.financeapp;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String, String> users;

    public Authentication() {
        // Simple in-memory user data (in a real app, this would be replaced by a database)
        users = new HashMap<>();
        users.put("pratik", "password123"); // Example user (username: pratik, password: password123)
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public void register(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            System.out.println("Registration successful for " + username);
        } else {
            System.out.println("User already exists.");
        }
    }
}
