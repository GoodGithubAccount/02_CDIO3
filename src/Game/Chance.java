package Game;

public class Chance {

    public enum cardType{
        GIVEPLAYERCARD,MOVETOSPACE,MOVECERTAINDISTANCE,CHOISE,CHANCEBALANCE,GETOUTOFJAIL,RECEIVEMONEYFROMPLAYERS
    }

    cardType cType;
    String name;
    String text;
    int id;
    int money;
    int move;


    public Chance(String name, int id, String text,cardType cType,int move, int money) {
        this.name = name;
        this.id = id;
        this.text=text;
        this.cType=cType;
        this.move=move;
        this.money=money;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getText() {return text;}

    public cardType getCType(){return cType;}

    public int getMoney(){return money;}

    public int getMove(){return move;}


    public String toString(){
        return this.name+" "+this.text;

    }
}
