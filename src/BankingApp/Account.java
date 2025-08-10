package BankingApp;

public class Account {
    private int accNo;
    private int pin;
    private float balance;

    public void accno(int accNo) {
        this.accNo = accNo;
    }

    public int gaccno() {
        return accNo;
    }

    public void pin(int pin) {
        this.pin = pin;
    }

    public int gpin() {
        return pin;
    }

    public void balance(float balance) {
        this.balance = balance;
    }

    public float gbalance() {
        return balance;
    }

    public boolean vacc(int acc, int pn) {
        return accNo == acc && pin == pn;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposit successful! New balance: " + balance);
    }
}
