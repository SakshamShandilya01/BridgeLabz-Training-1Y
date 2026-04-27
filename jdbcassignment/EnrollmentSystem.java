package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class EnrollmentSystem {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Enrollment");
                System.out.println("2. Show Enrollments by Course");
                System.out.println("3. Change Student Course");
                System.out.println("4. Cancel Enrollment");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addEnrollment(con, sc);
                        break;
                    case 2:
                        showByCourse(con, sc);
                        break;
                    case 3:
                        updateCourse(con, sc);
                        break;
                    case 4:
                        deleteEnrollment(con, sc);
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
    static void addEnrollment(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String student = sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        String query = "INSERT INTO enrollments VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, student);
        ps.setString(3, course);

        ps.executeUpdate();
        System.out.println("Enrollment Added!");
    }

    // 🔹 READ (by course)
    static void showByCourse(Connection con, Scanner sc) throws SQLException {
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        String query = "SELECT * FROM enrollments WHERE course = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, course);

        ResultSet rs = ps.executeQuery();

        System.out.println("Enrollments for " + course + ":");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("student") + " "
                    + rs.getString("course"));
        }
    }

    // 🔹 UPDATE (change course)
    static void updateCourse(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Enrollment ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        String query = "UPDATE enrollments SET course = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, course);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Course Updated!" : "Enrollment Not Found!");
    }

    // 🔹 DELETE
    static void deleteEnrollment(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Enrollment ID to cancel: ");
        int id = sc.nextInt();

        String query = "DELETE FROM enrollments WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Enrollment Cancelled!" : "Not Found!");
    }
}

