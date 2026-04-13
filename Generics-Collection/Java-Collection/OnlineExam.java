import java.util.*;

class OnlineExam {
    int id;
    String text;

    Question(int id, String text) {
        this.id = id;
        this.text = text;
    }
}

class Student {
    String id;

    Student(String id) {
        this.id = id;
    }
}

public class ExamSystem {
    public static void main(String[] args) {

   
        Set<String> studentIDs = new HashSet<>();
        studentIDs.add("S1");
        studentIDs.add("S2");
        studentIDs.add("S1"); // duplicate ignored


        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "Q1"));
        questions.add(new Question(2, "Q2"));
        questions.add(new Question(3, "Q3"));
        Collections.shuffle(questions);
        Queue<Student> queue = new LinkedList<>();
        queue.add(new Student("S1"));
        queue.add(new Student("S2"));

       
        Stack<Question> stack = new Stack<>();


        while (!queue.isEmpty()) {
            Student s = queue.poll();
            System.out.println("Serving: " + s.id);

            for (Question q : questions) {
                System.out.println("Question: " + q.text);
                stack.push(q); // move forward
            }


            while (!stack.isEmpty()) {
                System.out.println("Back: " + stack.pop().text);
            }
        }
    }
}