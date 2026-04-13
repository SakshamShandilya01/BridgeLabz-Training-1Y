import java.util.*;


abstract class JobRole {
    String name;

    JobRole(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}


class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String name) { super(name); }
}

class DataScientist extends JobRole {
    DataScientist(String name) { super(name); }
}

class ProductManager extends JobRole {
    ProductManager(String name) { super(name); }
}

class Resume<T extends JobRole> {
    T role;

    Resume(T role) {
        this.role = role;
    }

    public void process() {
        System.out.println("Processing resume for: " + role);
    }
}


public class Main {

   
    public static <T extends JobRole> void screenResume(Resume<T> r) {
        r.process();
    }


    public static void pipeline(List<? extends JobRole> roles) {
        for (JobRole r : roles) {
            System.out.println("Screening for: " + r);
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 = new Resume<>(new SoftwareEngineer("Software Engineer"));
        Resume<DataScientist> r2 = new Resume<>(new DataScientist("Data Scientist"));

        screenResume(r1);
        screenResume(r2);

        List<JobRole> roles = Arrays.asList(
            new SoftwareEngineer("SE"),
            new DataScientist("DS"),
            new ProductManager("PM")
        );

        pipeline(roles);
    }
}