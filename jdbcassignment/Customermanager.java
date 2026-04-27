package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class Customermanager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Customer");
                System.out.println("2. Search Customer by Name");
                System.out.println("3. Update Phone Number");
                System.out.println("4. Delete Customer");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addCustomer(con, sc);
                        break;
                    case 2:
                        searchCustomer(con, sc);
                        break;
                    case 3:
                        updatePhone(con, sc);
                        break;
                    case 4:
                        deleteCustomer(con, sc);
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
    static void addCustomer(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        String query = "INSERT INTO customers VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, phone);

        ps.executeUpdate();
        System.out.println("Customer Added!");
    }

    // 🔹 READ (Search using LIKE)
    static void searchCustomer(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Name to Search: ");
        sc.nextLine();
        String name = sc.nextLine();

        String query = "SELECT * FROM customers WHERE name LIKE ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "%" + name + "%");

        ResultSet rs = ps.executeQuery();

        System.out.println("Search Results:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("name") + " "
                    + rs.getString("phone"));
        }
    }

    // 🔹 UPDATE
    static void updatePhone(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Phone: ");
        String phone = sc.nextLine();

        String query = "UPDATE customers SET phone = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, phone);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Phone Updated!" : "Customer Not Found!");
    }

    // 🔹 DELETE
    static void deleteCustomer(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Customer ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM customers WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Customer Deleted!" : "Customer Not Found!");
    }
}

