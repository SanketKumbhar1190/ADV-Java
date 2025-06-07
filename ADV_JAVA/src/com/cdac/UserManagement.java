package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserManagement {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/advjavab2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "cdac";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while (running) {
            System.out.println("\nUser Management System");
            System.out.println("1. Register a User");
            System.out.println("2. List All Users by City");
            System.out.println("3. Update Password of a User");
            System.out.println("4. Display User Information by Username");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    listUsersByCity(scanner);
                    break;
                case 3:
                    updateUserPassword(scanner);
                    break;
                case 4:
                    displayUserByUsername(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.println("\n--- Register a New User ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        String sql = "INSERT INTO assign1 (username, password, name, email, city) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, city);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to register user.");
            }
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    private static void listUsersByCity(Scanner scanner) {
        System.out.println("\n--- List Users by City ---");
        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        String sql = "SELECT * FROM assign1 WHERE city = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, city);
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("Username: " + rs.getString("username") +
                            ", Password: " + rs.getString("password") +
                            ", Name: " + rs.getString("name") +
                            ", Email: " + rs.getString("email") +
                            ", City: " + rs.getString("city"));
                }
                if (!found) {
                    System.out.println("No users found in city: " + city);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error listing users: " + e.getMessage());
        }
    }

    private static void updateUserPassword(Scanner scanner) {
        System.out.println("\n--- Update User Password ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        String sql = "UPDATE assign1 SET password = ? WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully for user: " + username);
            } else {
                System.out.println("User not found: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
    }

    private static void displayUserByUsername(Scanner scanner) {
        System.out.println("\n--- Display User Information ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        String sql = "SELECT * FROM assign1 WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Username: " + rs.getString("username") +
                            ", Password: " + rs.getString("password") +
                            ", Name: " + rs.getString("name") +
                            ", Email: " + rs.getString("email") +
                            ", City: " + rs.getString("city"));
                } else {
                    System.out.println("User not found: " + username);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user information: " + e.getMessage());
        }
    }
}