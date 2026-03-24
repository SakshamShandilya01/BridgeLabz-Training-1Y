package com.gla.inheritancepolymorphism.AssistedProblems;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {

    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {

    int duration;

    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + duration + " months");
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Employee e1 = new Manager("Rahul", 101, 80000, 5);
        Employee e2 = new Developer("Aman", 102, 60000, "Java");
        Employee e3 = new Intern("Riya", 103, 20000, 6);

        e1.displayDetails();
        System.out.println();

        e2.displayDetails();
        System.out.println();

        e3.displayDetails();
    }
}
