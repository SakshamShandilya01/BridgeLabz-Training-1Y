package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class GymManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Member");
                System.out.println("2. Show Premium Members");
                System.out.println("3. Extend Membership");
                System.out.println("4. Delete Member");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addMember(con, sc);
                        break;
                    case 2:
                        showPremium(con);
                        break;
                    case 3:
                        extendMembership(con, sc);
                        break;
                    case 4:
                        deleteMember(con, sc);
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
    static void addMember(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Membership Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Months: ");
        int months = sc.nextInt();

        String query = "INSERT INTO members VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, type);
        ps.setInt(4, months);

        ps.executeUpdate();
        System.out.println("Member Added!");
    }

    // 🔹 READ (Premium members)
    static void showPremium(Connection con) throws SQLException {
        String query = "SELECT * FROM members WHERE type = 'Premium'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Premium Members:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("name") + " "
                    + rs.getString("type") + " "
                    + rs.getInt("months"));
        }
    }

    // 🔹 UPDATE (Extend membership)
    static void extendMembership(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Months to Add: ");
        int extra = sc.nextInt();

        String query = "UPDATE members SET months = months + ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, extra);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Membership Extended!" : "Member Not Found!");
    }

    // 🔹 DELETE (expired/cancelled)
    static void deleteMember(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Member ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM members WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Member Removed!" : "Member Not Found!");
    }
}

