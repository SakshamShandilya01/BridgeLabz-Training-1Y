import java.util.*;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class BankAccount {
    double bal = 1000;

    void withdraw(double amt) throws Exception {
        if (amt < 0) throw new IllegalArgumentException("Invalid amount!");
        if (amt > bal) throw new InsufficientBalanceException("Insufficient balance!");
        System.out.println("Withdrawal successful, new balance: " + (bal - amt));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount b = new BankAccount();

        try {
            double amt = sc.nextDouble();
            b.withdraw(amt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}