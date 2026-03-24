class Course {
    static String platformName = "LearnX";
    int id;
    String name;
    double price;

    Course(int i, String n, double p) {
        id = i;
        name = n;
        price = p;
    }

    double getFinalPrice() {
        return price;
    }
}

class RecordedCourse extends Course {
    RecordedCourse(int i, String n, double p) {
        super(i, n, p);
    }

    double getFinalPrice() {
        return price * 0.9;
    }
}

class LiveCourse extends Course {
    LiveCourse(int i, String n, double p) {
        super(i, n, p);
    }

    double getFinalPrice() {
        return price * 0.95;
    }
}

public class Story9_Course {
    public static void main(String[] args) {
        Course c1 = new RecordedCourse(1, "Java", 1000);
        Course c2 = new LiveCourse(2, "DSA", 1000);

        System.out.println(c1.getFinalPrice());
        System.out.println(c2.getFinalPrice());
    }
}