class Contact {
    String name, phone;

    Contact(String n, String p) {
        name = n;
        phone = p;
    }

    void display() {
        System.out.println(name + " " + phone);
    }
}

class BusinessContact extends Contact {
    String company;

    BusinessContact(String n, String p, String c) {
        super(n, p);
        company = c;
    }

    void display() {
        System.out.println(name.toUpperCase() + " " + phone + " " + company);
    }
}

public class Story6_Contact {
    public static void main(String[] args) {
        BusinessContact c = new BusinessContact("saksham", "999", "Google");
        c.display();
    }
}