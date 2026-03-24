package com.company.main;

import com.company.hr.*;        // on-demand import
import com.company.payroll.Payroll;

public class MainApp {

    public static void main(String[] args) {

        Employee emp = new Employee(101, "Uttkarsh", "IT", 50000);

        Payroll p = new Payroll();
        p.calculateBonus(emp);

        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("Salary After Bonus: " + emp.getSalary());
    }
}
