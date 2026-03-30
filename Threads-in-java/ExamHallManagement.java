package com.gla.MultiThreading;
class EntryMonitor implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +
                        " | Monitoring student entry...");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class QuestionPaperDistribution implements Runnable {
    public void run() {
        try {
            Thread.sleep(5000); // start after 5 seconds
            System.out.println(Thread.currentThread().getName() +
                    " | Distributing Question Papers...");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class AttendanceMarking implements Runnable {
    public void run() {
        try {
            Thread.sleep(10000); // start after 10 seconds
            System.out.println(Thread.currentThread().getName() +
                    " | Marking Attendance...");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class AnswerSheetCollection implements Runnable {
    public void run() {
        try {
            Thread.sleep(15000); // exam duration
            System.out.println(Thread.currentThread().getName() +
                    " | Collecting Answer Sheets...");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ExamHallManagement {
    public static void main(String[] args) {

        Thread entry = new Thread(new EntryMonitor(), "Entry Monitor");
        Thread question = new Thread(new QuestionPaperDistribution(), "Question Paper Distribution");
        Thread attendance = new Thread(new AttendanceMarking(), "Attendance Marking");
        Thread collection = new Thread(new AnswerSheetCollection(), "Answer Sheet Collection");


        question.setPriority(10);   // highest
        attendance.setPriority(8);
        collection.setPriority(7);
        entry.setPriority(5);


        System.out.println("Initial Thread States:");
        System.out.println(entry.getName() + " : " + entry.getState());
        System.out.println(question.getName() + " : " + question.getState());
        System.out.println(attendance.getName() + " : " + attendance.getState());
        System.out.println(collection.getName() + " : " + collection.getState());


        entry.start();
        question.start();
        attendance.start();
        collection.start();

        try {
            Thread.sleep(1000);
            System.out.println("\nThread States After Starting:");

            System.out.println(entry.getName() + " : " + entry.getState());
            System.out.println(question.getName() + " : " + question.getState());
            System.out.println(attendance.getName() + " : " + attendance.getState());
            System.out.println(collection.getName() + " : " + collection.getState());


            entry.join();
            question.join();
            attendance.join();
            collection.join();

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\nAll Exam Hall Activities Completed.");
    }
}

