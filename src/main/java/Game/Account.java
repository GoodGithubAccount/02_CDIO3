package Game;

public class Account {
    // Our start balance and balance.
    private final int startBalance = Settings.STARTING_MONEY;
    private int balance;

    // Sets balance to our startbalance
    public Account() {
        this.balance = startBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Updates the balance
    public void newBalance(int newBalance) {
        this.balance += newBalance;
    }
}
