package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class LibraryManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Book");
                System.out.println("2. Show Available Books");
                System.out.println("3. Issue Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addBook(con, sc);
                        break;
                    case 2:
                        showAvailable(con);
                        break;
                    case 3:
                        issueBook(con, sc);
                        break;
                    case 4:
                        deleteBook(con, sc);
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
    static void addBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        String query = "INSERT INTO books VALUES (?, ?, ?, 'Available')";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, author);

        ps.executeUpdate();
        System.out.println("Book Added!");
    }

    // 🔹 READ (Available Books)
    static void showAvailable(Connection con) throws SQLException {
        String query = "SELECT * FROM books WHERE status = 'Available'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Available Books:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("title") + " "
                    + rs.getString("author"));
        }
    }

    // 🔹 UPDATE (Issue Book)
    static void issueBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        String query = "UPDATE books SET status = 'Issued' WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Book Issued!" : "Book Not Found!");
    }

    // 🔹 DELETE
    static void deleteBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM books WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Book Deleted!" : "Book Not Found!");
    }
}

