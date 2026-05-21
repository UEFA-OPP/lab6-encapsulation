public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Orlogo buruu");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Dansnii uldegdel hurehgui");
        }
    }

    public double getBalance() {
        return balance;
    }
}