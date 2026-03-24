
// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient Balance");
    }

    // Abstract method
    abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan Applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance > 5000;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan Applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance > 10000;
    }
}

// Main class
public class BankingSystem {

    public static void main(String[] args) {

        BankAccount[] accounts = {
                new SavingsAccount("A101", "User1", 8000),
                new CurrentAccount("A102", "User2", 15000)
        };

        for (BankAccount acc : accounts) {

            acc.displayDetails();

            double interest = acc.calculateInterest();
            System.out.println("Interest: " + interest);

            Loanable loan = (Loanable) acc;
            System.out.println("Loan Eligible: " + loan.calculateLoanEligibility());

            System.out.println("----------------------");
        }
    }
}