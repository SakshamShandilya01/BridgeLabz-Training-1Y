class Book {
    static String libraryName = "CityLibrary";
    int bookId;
    String title;
    double price;

    Book(int bookId, String title, double price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }

    double calculateFine(int daysLate) {
        return 0;
    }
}

class TextBook extends Book {
    TextBook(int id, String t, double p) {
        super(id, t, p);
    }

    double calculateFine(int daysLate) {
        return daysLate * 2;
    }
}

class Magazine extends Book {
    Magazine(int id, String t, double p) {
        super(id, t, p);
    }

    double calculateFine(int daysLate) {
        return daysLate * 5;
    }
}

public class Story1_Library {
    public static void main(String[] args) {
        Book b1 = new TextBook(1, "Math", 200);
        Book b2 = new Magazine(2, "Tech", 100);

        System.out.println(b1.calculateFine(3));
        System.out.println(b2.calculateFine(3));
    }
}