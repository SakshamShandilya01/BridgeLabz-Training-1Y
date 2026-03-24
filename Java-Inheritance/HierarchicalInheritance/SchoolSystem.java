package com.gla.inheritancepolymorphism.HierarchicalInheritance;

class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Teacher extends Person {

    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {

    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {

    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolSystem {

    public static void main(String[] args) {

        Teacher t = new Teacher("Rahul", 35, "Math");
        Student s = new Student("Aman", 16, "10th");
        Staff st = new Staff("Ravi", 40, "Administration");

        t.displayPerson();
        t.displayRole();
        System.out.println();

        s.displayPerson();
        s.displayRole();
        System.out.println();

        st.displayPerson();
        st.displayRole();
    }
}
