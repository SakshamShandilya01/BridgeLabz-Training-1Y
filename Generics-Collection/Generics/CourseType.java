import java.util.*;


abstract class CourseType {
    String name;

    CourseType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}


class ExamCourse extends CourseType {
    ExamCourse(String name) { super(name); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) { super(name); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) { super(name); }
}


class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T c) {
        courses.add(c);
    }

    public List<T> getCourses() {
        return courses;
    }
}


public class Main {

  
    public static void displayCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> exam = new Course<>();
        exam.addCourse(new ExamCourse("Math"));

        Course<AssignmentCourse> assign = new Course<>();
        assign.addCourse(new AssignmentCourse("Java"));

        Course<ResearchCourse> research = new Course<>();
        research.addCourse(new ResearchCourse("AI"));

        displayCourses(exam.getCourses());
        displayCourses(assign.getCourses());
        displayCourses(research.getCourses());
    }
}