package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class VehicleServiceCenter {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Vehicle");
                System.out.println("2. Show Pending Vehicles");
                System.out.println("3. Mark Service Completed");
                System.out.println("4. Delete Vehicle (Delivery Done)");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addVehicle(con, sc);
                        break;
                    case 2:
                        showPending(con);
                        break;
                    case 3:
                        completeService(con, sc);
                        break;
                    case 4:
                        deleteVehicle(con, sc);
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
    static void addVehicle(Connection con, Scanner sc) throws SQLException {
        sc.nextLine();

        System.out.print("Enter Registration No: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        String query = "INSERT INTO vehicles VALUES (?, ?, 'Pending')";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, regNo);
        ps.setString(2, owner);

        ps.executeUpdate();
        System.out.println("Vehicle Added for Service!");
    }

    // 🔹 READ (Pending vehicles)
    static void showPending(Connection con) throws SQLException {
        String query = "SELECT * FROM vehicles WHERE status = 'Pending'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Pending Vehicles:");
        while (rs.next()) {
            System.out.println(rs.getString("regNo") + " "
                    + rs.getString("owner") + " "
                    + rs.getString("status"));
        }
    }

    // 🔹 UPDATE (Mark Completed)
    static void completeService(Connection con, Scanner sc) throws SQLException {
        sc.nextLine();

        System.out.print("Enter Registration No: ");
        String regNo = sc.nextLine();

        String query = "UPDATE vehicles SET status = 'Completed' WHERE regNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, regNo);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Service Completed!" : "Vehicle Not Found!");
    }

    // 🔹 DELETE
    static void deleteVehicle(Connection con, Scanner sc) throws SQLException {
        sc.nextLine();

        System.out.print("Enter Registration No to delete: ");
        String regNo = sc.nextLine();

        String query = "DELETE FROM vehicles WHERE regNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, regNo);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Vehicle Removed (Delivered)!" : "Vehicle Not Found!");
    }
}

