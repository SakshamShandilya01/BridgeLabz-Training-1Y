class Employee {
    int empId;
    String name;

    Employee(int id, String n) {
        empId = id;
        name = n;
    }

    String generateEmail() {
        return name.toLowerCase() + "@company.com";
    }
}

class Manager extends Employee {
    String dept;

    Manager(int id, String n, String d) {
        super(id, n);
        dept = d;
    }

    String generateEmail() {
        return name.toLowerCase() + "." + dept.toLowerCase() + "@company.com";
    }
}

public class Story4_Employee {
    public static void main(String[] args) {
        Manager m = new Manager(1, "Saksham", "IT");
        System.out.println(m.generateEmail());
    }
}