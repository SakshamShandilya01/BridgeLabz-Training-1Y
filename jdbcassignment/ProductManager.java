package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class ProductManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Insert Product");
                System.out.println("2. Show Low Stock (qty < 10)");
                System.out.println("3. Update Quantity");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertProduct(con, sc);
                        break;
                    case 2:
                        showLowStock(con);
                        break;
                    case 3:
                        updateQty(con, sc);
                        break;
                    case 4:
                        deleteProduct(con, sc);
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
    static void insertProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        String query = "INSERT INTO product VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, qty);

        ps.executeUpdate();
        System.out.println("Product Inserted!");
    }

    // 🔹 READ (Low Stock)
    static void showLowStock(Connection con) throws SQLException {
        String query = "SELECT * FROM product WHERE qty < 10";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Low Stock Products:");
        while (rs.next()) {
            System.out.println(rs.getInt("pid") + " "
                    + rs.getString("pname") + " "
                    + rs.getInt("qty"));
        }
    }

    // 🔹 UPDATE
    static void updateQty(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Quantity to Add: ");
        int addQty = sc.nextInt();

        String query = "UPDATE product SET qty = qty + ? WHERE pid = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, addQty);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Quantity Updated!" : "Product Not Found!");
    }

    // 🔹 DELETE
    static void deleteProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM product WHERE pid = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Product Deleted!" : "Product Not Found!");
    }
}

