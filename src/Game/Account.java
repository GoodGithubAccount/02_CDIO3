package Game;

public class Account {
    // Our start balance and balance.
    private final int startbal = Settings.STARTING_MONEY;
    private int balance;

    // Sets balance to our startbalance
    public Account() {
        this.balance = startbal;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Updates the balance and also makes sure it doesn't go below 0
    public void newBalance (int ubalance){
        this.balance += ubalance;

        if(this.balance < 0){
            this.balance = 0;
        }
    }
}
