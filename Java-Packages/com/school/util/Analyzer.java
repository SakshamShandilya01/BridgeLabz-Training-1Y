package com.school.util;

import com.school.data.Student;

public class Analyzer {

    public double calculateAverage(Student s) {
        return (s.getM1() + s.getM2() + s.getM3()) / 3.0;
    }

    public String findGrade(double avg) {

        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "Fail";
    }
}
