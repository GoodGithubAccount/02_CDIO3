package Game;

public class Player {
    String name;
    Account playerAccount;

    int playerNumber;
    private static int counter=1;

    public Player(String name) {
        this.name = name;
        this.playerNumber = counter;

        playerAccount = new Account();
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayernumber() {
        return playerNumber;
    }

    public void setPlayernumber(int playernumber) {
        this.playerNumber = playerNumber;
    }

    public Account getAccount() {
        return playerAccount;
    }
}


