package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class TodoManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Task");
                System.out.println("2. Show Pending Tasks");
                System.out.println("3. Mark Task Completed");
                System.out.println("4. Delete Completed Tasks");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addTask(con, sc);
                        break;
                    case 2:
                        showPending(con);
                        break;
                    case 3:
                        completeTask(con, sc);
                        break;
                    case 4:
                        deleteCompleted(con);
                        break;
                    case 5:
                        con.close();
                        System.exit(0);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 CREATE
    static void addTask(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();

        String query = "INSERT INTO tasks VALUES (?, ?, 'Pending')";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, title);

        ps.executeUpdate();
        System.out.println("Task Added!");
    }

    // 🔹 READ (Pending tasks)
    static void showPending(Connection con) throws SQLException {
        String query = "SELECT * FROM tasks WHERE status = 'Pending'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Pending Tasks:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("title") + " "
                    + rs.getString("status"));
        }
    }

    // 🔹 UPDATE (Mark Completed)
    static void completeTask(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        String query = "UPDATE tasks SET status = 'Completed' WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Task Completed!" : "Task Not Found!");
    }

    // 🔹 DELETE (Completed tasks)
    static void deleteCompleted(Connection con) throws SQLException {
        String query = "DELETE FROM tasks WHERE status = 'Completed'";
        Statement st = con.createStatement();

        int rows = st.executeUpdate(query);
        System.out.println(rows + " Completed Tasks Deleted!");
    }
}

