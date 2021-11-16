package Game;

public class ChanceMoneyOrMove extends Chance {
    int val;
    int move;
    int getval;

    public ChanceMoneyOrMove(String name, String text, int id, int val, int move, int getval) {
        super(name, id, text);
        this.val = val;
        this.move = move;
        this.getval = getval;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getGetval() {
        return getval;
    }

    public void setGetval(int getval) {
        this.getval = getval;
    }

    @Override
    public String toString() {
        return "ChanceMoneyOrMove{" +
                "val=" + val +
                ", move=" + move +
                ", getval=" + getval +
                '}';
    }
}
