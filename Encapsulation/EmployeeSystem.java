// Abstract class
abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
    }
}

// Full Time Employee
class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateSalary() {
        return baseSalary;
    }
}

// Part Time Employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double rate, int hours) {
        super(id, name, 0);
        this.hourlyRate = rate;
        this.hoursWorked = hours;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main Class (File name same as this)
public class EmployeeSystem {

    public static void main(String[] args) {
Employee e1 = new FullTimeEmployee(101, "Employee1", 50000);
Employee e2 = new PartTimeEmployee(102, "Employee2", 500, 20);

        e1.displayDetails();
        System.out.println("Salary: " + e1.calculateSalary());

        System.out.println();

        e2.displayDetails();
        System.out.println("Salary: " + e2.calculateSalary());
    }
}