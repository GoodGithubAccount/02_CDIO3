package Game;

public class Player {
    private String name;
    private int playernumber;
    private Account ac;
    private int position = 0;
    private static int counter = 1;

    public Player(String name) {
        this.name = name;
        this.playernumber = counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public void setPlayernumber(int playernumber) {
        this.playernumber = playernumber;
    }

    public Account getAc() {
        return ac;
    }

    public void setAc(Account ac) {
        this.ac = ac;
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
            this.position += position - 24;
        }
        else this.position+=position;
    }
}


