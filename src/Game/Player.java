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

        playerAccount = new Account();
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

    @Override
    public String toString() {
        return this.name + " Playernumber: " + playerNumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (this.position + position > Settings.BOARD_SIZE-1) {
            this.position += position - Settings.BOARD_SIZE-1;
        } else this.position += position;
    }
}


