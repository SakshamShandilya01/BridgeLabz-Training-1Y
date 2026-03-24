import college.student.Student;
import college.faculty.Faculty;

public class MainApp {
    public static void main(String[] args) {

        Student s = new Student();
        s.showStudent();

        Faculty f = new Faculty();
        f.showFaculty();
    }
}
