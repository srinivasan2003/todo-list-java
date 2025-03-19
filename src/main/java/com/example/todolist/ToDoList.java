package com.example.todolist;

import java.sql.*;

public class ToDoList {
    private Connection connection;

    public ToDoList() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/todolist", "sa", "");
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS tasks (id INT AUTO_INCREMENT PRIMARY KEY, task VARCHAR(255))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTask(String task) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO tasks (task) VALUES (?)");
            stmt.setString(1, task);
            stmt.executeUpdate();
            System.out.println("Task added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewTasks() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("task"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeTask(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tasks WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Task removed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
