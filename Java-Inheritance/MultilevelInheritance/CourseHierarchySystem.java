package com.gla.inheritancepolymorphism.MultilevelInheritance;

class Course {

    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {

    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayCourse() {
        super.displayCourse();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {

    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded,
                     double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayCourse() {
        super.displayCourse();
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: " + (fee - fee * discount / 100));
    }
}

public class CourseHierarchySystem {

    public static void main(String[] args) {

        PaidOnlineCourse c1 = new PaidOnlineCourse(
                "Java OOP",
                40,
                "Udemy",
                true,
                5000,
                20
        );

        c1.displayCourse();
    }
}