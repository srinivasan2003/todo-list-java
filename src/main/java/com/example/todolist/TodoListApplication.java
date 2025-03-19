package com.example.todolist;

import java.sql.*;
import java.util.Scanner;

public class TodoListApplication {
    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Connect to H2 Database
            connection = DriverManager.getConnection("jdbc:h2:./todolist", "sa", "");

            // Create tasks table if not exists
            createTable();

            // Start user interaction
            runMenu();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabase();  // Ensure database closes on exit
        }
    }

    private static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (id INT AUTO_INCREMENT PRIMARY KEY, task VARCHAR(255))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> viewTasks();
                case 3 -> removeTask(scanner);
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();

        String sql = "INSERT INTO tasks (task) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
            System.out.println("✅ Task added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewTasks() {
        String sql = "SELECT * FROM tasks";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Task List ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("task"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Enter task ID to remove: ");
        int taskId = scanner.nextInt();

        String sql = "DELETE FROM tasks WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, taskId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Task removed.");
            } else {
                System.out.println("⚠ Task ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeDatabase() {
        if (connection != null) {
            try {
                connection.createStatement().execute("SHUTDOWN"); // Shutdown H2 properly
                connection.close();
                System.out.println("✅ Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
