package Game;

public class Chance {

    public enum cardType{
        GIVEPLAYERCARD,MOVETOSPACE,MOVECERTAINDISTANCE,CHOISE,CHANGEBALANCE,GETOUTOFJAIL,RECEIVEMONEYFROMPLAYERS
    }

    cardType cType;
    String name;
    String text;
    int id;
    String value;
    int move;

    // Navn-tekst-id-value-move-Type    Colors/space id: orange=0, green=1, lightblue=2, pink=3, blue=4, red=5, brown=6, yellow=7, start=8, Pier=9, Skatepark=10

    public Chance(String name, String text, int id, String value, int move, cardType cType) {
        this.name = name;
        this.id = id;
        this.text=text;
        this.cType=cType;
        this.move=move;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getText() {return text;}

    public cardType getCType(){return cType;}

    public String getValue(){return value;}

    public int getMove(){return move;}


    public String toString(){
        return this.name+" "+this.text;

    }
}
