package Game;

public class Player {
    private String name;
    private Account playerAccount;

    private static int counter = 1;
    private int playerNumber;

    private int position = 0;
    private boolean isjailed = false;
    private int soldSigns = Settings.SOLD_SIGNS;

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

    public void move(int position) {
        if (this.position + position >= Settings.BOARD_SIZE - 1) {
            this.position += position - Settings.BOARD_SIZE;
        } else this.position += position;
    }


    public boolean isIsjailed() {
        return isjailed;
    }

    public void setIsjailed(boolean isjailed) {
        this.isjailed = isjailed;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getSoldSigns() {
        return soldSigns;
    }

    public void setSoldSigns(int soldSigns) {
        this.soldSigns = soldSigns;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


