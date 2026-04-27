package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class MovieManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Movie");
                System.out.println("2. Show Available Movies");
                System.out.println("3. Book Ticket");
                System.out.println("4. Delete Movie");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addMovie(con, sc);
                        break;
                    case 2:
                        showAvailable(con);
                        break;
                    case 3:
                        bookTicket(con, sc);
                        break;
                    case 4:
                        deleteMovie(con, sc);
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
    static void addMovie(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Movie Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Total Seats: ");
        int seats = sc.nextInt();

        String query = "INSERT INTO movies VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, seats);

        ps.executeUpdate();
        System.out.println("Movie Added!");
    }

    // 🔹 READ (Available Movies)
    static void showAvailable(Connection con) throws SQLException {
        String query = "SELECT * FROM movies WHERE seats > 0";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Available Movies:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("name") + " "
                    + rs.getInt("seats"));
        }
    }

    // 🔹 UPDATE (Book Ticket)
    static void bookTicket(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();

        // check seats
        String checkQuery = "SELECT seats FROM movies WHERE id = ?";
        PreparedStatement checkPs = con.prepareStatement(checkQuery);
        checkPs.setInt(1, id);
        ResultSet rs = checkPs.executeQuery();

        if (rs.next()) {
            int seats = rs.getInt("seats");

            if (seats > 0) {
                String query = "UPDATE movies SET seats = seats - 1 WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);

                ps.executeUpdate();
                System.out.println("Ticket Booked!");
            } else {
                System.out.println("No Seats Available!");
            }
        } else {
            System.out.println("Movie Not Found!");
        }
    }

    // 🔹 DELETE
    static void deleteMovie(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Movie ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM movies WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Movie Deleted!" : "Movie Not Found!");
    }
}

