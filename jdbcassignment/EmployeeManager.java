package com.gla.jdbcassignment;
import java.sql.*;
import java.util.Scanner;
public class EmployeeManager {
        static final String URL = "jdbc:mysql://localhost:3306/your_db";
        static final String USER = "root";
        static final String PASS = "password";

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            try {
                Connection con = DriverManager.getConnection(URL, USER, PASS);

                while (true) {
                    System.out.println("\n1. Add Employee");
                    System.out.println("2. Display Salary > 30000");
                    System.out.println("3. Increase Salary by 10%");
                    System.out.println("4. Delete Salary < 15000");
                    System.out.println("5. Exit");

                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            addEmployee(con, sc);
                            break;
                        case 2:
                            displayEmployees(con);
                            break;
                        case 3:
                            updateSalary(con, sc);
                            break;
                        case 4:
                            deleteEmployees(con);
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
        static void addEmployee(Connection con, Scanner sc) throws SQLException {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            String query = "INSERT INTO employee VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);

            ps.executeUpdate();
            System.out.println("Employee Added!");
        }

        // 🔹 READ
        static void displayEmployees(Connection con) throws SQLException {
            String query = "SELECT * FROM employee WHERE salary > 30000";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getDouble("salary"));
            }
        }

        // 🔹 UPDATE
        static void updateSalary(Connection con, Scanner sc) throws SQLException {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            String query = "UPDATE employee SET salary = salary * 1.10 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Salary Updated!" : "Employee Not Found!");
        }

        // 🔹 DELETE
        static void deleteEmployees(Connection con) throws SQLException {
            String query = "DELETE FROM employee WHERE salary < 15000";
            Statement st = con.createStatement();

            int rows = st.executeUpdate(query);
            System.out.println(rows + " Employees Deleted!");
        }
    }

