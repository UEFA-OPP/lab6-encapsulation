public class ATMAccount {
    private String owner;
    private double balance;
    private double dailyWithdrawLimit;
    private double withdrawnToday;

    public ATMAccount(String owner, double balance, double dailyWithdrawLimit) {
        this.owner = owner == null ? "Todorhoigui" : owner;
        this.balance = Math.max(0, balance);
        this.dailyWithdrawLimit = Math.max(0, dailyWithdrawLimit);
        this.withdrawnToday = 0;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    public double getWithdrawnToday() {
        return withdrawnToday;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Avlaga buruu");
            return;
        }
        if (amount > getBalance()) {
            System.out.println("Dansnii uldegdel hurehgui");
            return;
        }
        if (getWithdrawnToday() + amount > getDailyWithdrawLimit()) {
            System.out.println("Udrin avlagiin hemjeees iluu");
            return;
        }
        balance -= amount;
        withdrawnToday += amount;
    }
}