package Game;

public class Player {
    String name;
    int playernumber;
    Account ac;
    private static int counter=1;

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
}


