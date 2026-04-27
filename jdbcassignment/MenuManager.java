package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class MenuManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Menu Item");
                System.out.println("2. Show Items Below ₹200");
                System.out.println("3. Update Price");
                System.out.println("4. Delete Item");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addItem(con, sc);
                        break;
                    case 2:
                        showCheapItems(con);
                        break;
                    case 3:
                        updatePrice(con, sc);
                        break;
                    case 4:
                        deleteItem(con, sc);
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
    static void addItem(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        String query = "INSERT INTO menu VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, price);

        ps.executeUpdate();
        System.out.println("Item Added!");
    }

    // 🔹 READ (price < 200)
    static void showCheapItems(Connection con) throws SQLException {
        String query = "SELECT * FROM menu WHERE price < 200";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Items Below ₹200:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("itemName") + " "
                    + rs.getDouble("price"));
        }
    }

    // 🔹 UPDATE
    static void updatePrice(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Price: ");
        double price = sc.nextDouble();

        String query = "UPDATE menu SET price = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, price);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Price Updated!" : "Item Not Found!");
    }

    // 🔹 DELETE
    static void deleteItem(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Item ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM menu WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Item Deleted!" : "Item Not Found!");
    }
}

