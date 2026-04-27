package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class BookstoreSales {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Sale");
                System.out.println("2. Show Sales (quantity > 1)");
                System.out.println("3. Update Quantity");
                System.out.println("4. Delete Sale");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addSale(con, sc);
                        break;
                    case 2:
                        showSales(con);
                        break;
                    case 3:
                        updateQuantity(con, sc);
                        break;
                    case 4:
                        deleteSale(con, sc);
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
    static void addSale(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Sale ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String book = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        String query = "INSERT INTO sales VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, book);
        ps.setInt(3, qty);
        ps.setDouble(4, price);

        ps.executeUpdate();
        System.out.println("Sale Recorded!");
    }

    // 🔹 READ (quantity > 1)
    static void showSales(Connection con) throws SQLException {
        String query = "SELECT * FROM sales WHERE quantity > 1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Sales with Quantity > 1:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("bookName") + " "
                    + rs.getInt("quantity") + " "
                    + rs.getDouble("price"));
        }
    }

    // 🔹 UPDATE
    static void updateQuantity(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Sale ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Quantity: ");
        int qty = sc.nextInt();

        String query = "UPDATE sales SET quantity = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, qty);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Quantity Updated!" : "Sale Not Found!");
    }

    // 🔹 DELETE
    static void deleteSale(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Sale ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM sales WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Sale Deleted!" : "Sale Not Found!");
    }
}

