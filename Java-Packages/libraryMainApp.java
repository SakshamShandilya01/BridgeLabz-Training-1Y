import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class libraryMainApp {

    public static void main(String[] args) {

        Book b = new Book();
        Member m = new Member();
        Transaction t = new Transaction();

        b.addBook();          // Adding new book
        m.registerMember();   // Registering member
        t.issueBook();        // Issuing book

    }
}
