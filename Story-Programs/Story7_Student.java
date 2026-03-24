class Student {
    int roll;
    String name;
    int marks;

    Student(int r, String n, int m) {
        roll = r;
        name = n;
        marks = m;
    }

    String calculateGrade() {
        if (marks > 80) return "A";
        else return "B";
    }
}

class EngineeringStudent extends Student {
    String branch;

    EngineeringStudent(int r, String n, int m, String b) {
        super(r, n, m);
        branch = b;
    }

    String calculateGrade() {
        return super.calculateGrade() + " - " + branch;
    }
}

public class Story7_Student {
    public static void main(String[] args) {
        EngineeringStudent s = new EngineeringStudent(1, "Saksham", 85, "CSE");
        System.out.println(s.calculateGrade());
    }
}