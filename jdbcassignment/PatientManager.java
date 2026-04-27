package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class PatientManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Patient");
                System.out.println("2. Show Patients by Disease");
                System.out.println("3. Update Disease");
                System.out.println("4. Delete Patient");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addPatient(con, sc);
                        break;
                    case 2:
                        showByDisease(con, sc);
                        break;
                    case 3:
                        updateDisease(con, sc);
                        break;
                    case 4:
                        deletePatient(con, sc);
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
    static void addPatient(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        String query = "INSERT INTO patients VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, disease);

        ps.executeUpdate();
        System.out.println("Patient Added!");
    }

    // 🔹 READ (Filter by disease)
    static void showByDisease(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Disease: ");
        sc.nextLine();
        String disease = sc.nextLine();

        String query = "SELECT * FROM patients WHERE disease = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, disease);

        ResultSet rs = ps.executeQuery();

        System.out.println("Patients with " + disease + ":");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("name") + " "
                    + rs.getString("disease"));
        }
    }

    // 🔹 UPDATE
    static void updateDisease(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Disease: ");
        String disease = sc.nextLine();

        String query = "UPDATE patients SET disease = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, disease);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Disease Updated!" : "Patient Not Found!");
    }

    // 🔹 DELETE
    static void deletePatient(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM patients WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Patient Discharged & Removed!" : "Patient Not Found!");
    }
}

