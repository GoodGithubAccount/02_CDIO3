package Game;

public class Player {
    private String name;
    private Account playerAccount;

    private static int counter = 1;
    private int playerNumber;

    private int position = 0;

    public Player(String name) {
        this.name = name;
        this.playerNumber = counter;
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

    public void setPlayernumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Account getAc() {
        return playerAccount;
    }

    public void setAc(Account ac) {
        this.playerAccount = playerAccount;
    }

    @Override
    public String toString() {
        return this.name + " Playernumber: " + playernumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (this.position + position > Settings.BOARD_SIZE) {
            this.position += position - Settings.BOARD_SIZE;
        } else this.position += position;
    }
}


