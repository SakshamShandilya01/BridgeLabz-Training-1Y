class Account {
    static String bankName = "ABC Bank";
    int accNo;
    double balance;

    Account(int a, double b) {
        accNo = a;
        balance = b;
    }

    double calculateInterest() {
        return 0;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(int a, double b) {
        super(a, b);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(int a, double b) {
        super(a, b);
    }

    double calculateInterest() {
        return balance * 0.02;
    }
}

public class Story3_Bank {
    public static void main(String[] args) {
        Account a1 = new SavingsAccount(1, 10000);
        Account a2 = new CurrentAccount(2, 10000);

        System.out.println(a1.calculateInterest());
        System.out.println(a2.calculateInterest());
    }
}