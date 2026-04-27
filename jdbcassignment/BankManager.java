package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class BankManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Add Account");
                System.out.println("2. Show Balance > 10000");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Delete Account");
                System.out.println("6. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addAccount(con, sc);
                        break;
                    case 2:
                        showRichAccounts(con);
                        break;
                    case 3:
                        deposit(con, sc);
                        break;
                    case 4:
                        withdraw(con, sc);
                        break;
                    case 5:
                        deleteAccount(con, sc);
                        break;
                    case 6:
                        con.close();
                        System.exit(0);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 CREATE
    static void addAccount(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        String query = "INSERT INTO accounts VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, accNo);
        ps.setString(2, name);
        ps.setDouble(3, balance);

        ps.executeUpdate();
        System.out.println("Account Created!");
    }

    // 🔹 READ
    static void showRichAccounts(Connection con) throws SQLException {
        String query = "SELECT * FROM accounts WHERE balance > 10000";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("Accounts with Balance > 10000:");
        while (rs.next()) {
            System.out.println(rs.getInt("accNo") + " "
                    + rs.getString("name") + " "
                    + rs.getDouble("balance"));
        }
    }

    // 🔹 UPDATE (Deposit)
    static void deposit(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Amount to Deposit: ");
        double amt = sc.nextDouble();

        String query = "UPDATE accounts SET balance = balance + ? WHERE accNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, amt);
        ps.setInt(2, accNo);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Amount Deposited!" : "Account Not Found!");
    }

    // 🔹 UPDATE (Withdraw)
    static void withdraw(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Amount to Withdraw: ");
        double amt = sc.nextDouble();

        // check balance first
        String checkQuery = "SELECT balance FROM accounts WHERE accNo = ?";
        PreparedStatement checkPs = con.prepareStatement(checkQuery);
        checkPs.setInt(1, accNo);
        ResultSet rs = checkPs.executeQuery();

        if (rs.next()) {
            double currentBalance = rs.getDouble("balance");

            if (currentBalance >= amt) {
                String query = "UPDATE accounts SET balance = balance - ? WHERE accNo = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setDouble(1, amt);
                ps.setInt(2, accNo);

                ps.executeUpdate();
                System.out.println("Withdrawal Successful!");
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Account Not Found!");
        }
    }

    // 🔹 DELETE
    static void deleteAccount(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Account No to delete: ");
        int accNo = sc.nextInt();

        String query = "DELETE FROM accounts WHERE accNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, accNo);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Account Deleted!" : "Account Not Found!");
    }
}

