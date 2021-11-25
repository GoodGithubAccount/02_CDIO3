package Game;

public class ChanceTest {

    public static enum cardType{
        GIVEPLAYERCARD,MOVETOSPACE,MOVECERTAINDISTANCE,CHOISE,CHANGEBALANCE,GETOUTOFJAIL,RECEIVEMONEYFROMPLAYERS
    }

    //Method to GIVEPLAYERCARD
    private int playerNumber;
    public int playerNumber(){
        this.playerNumber=playerNumber;
        this.newCard=newCard;
        return playerNumber;
    }

    //Method to MOVETOSPACE
    private int moveProperty;
    public int moveProperty(){
        this.moveProperty=moveProperty;
        return moveProperty;
    }

    //Method to MOVECERTAINDISTANCE
    private int distance;
    public int distance(){
        this.distance = distance;
        return distance;
    }

    //Method to CHOISE
    private boolean newCard;
    public boolean choise(){
        this.newCard=newCard;
        return newCard;
    }

    //method to CHANGEBALANCE
    private int changeBal;
    public int changeBal(){
        this.changeBal=changeBal;
        return changeBal;
    }

    //Method for GETOUTOFJAIL
    private boolean getOutOfJail;
    public boolean getOutOfJail(){
        this.getOutOfJail=getOutOfJail;
        return getOutOfJail;
    }

    //Method to RECEIVEMONEYFROMPLAYERS
    private int present;
    public int present(){
        this.present=present;
        return present;
    }


    public void main(String[] args) {
        cardType cType=cardType.GIVEPLAYERCARD;

        switch (cType){
                //The player who draws this car has to give the card to a specified player and then draw another card.
            case GIVEPLAYERCARD:
                playerNumber();

                //Lets the player move to a specified field
            case MOVETOSPACE:
                moveProperty();

                //Lets the player move a specified distance
            case MOVECERTAINDISTANCE:
                distance();

                //The player can either move 1 forward or take another card
            case CHOISE:
                choise();

                //The player either loses or gains some money
            case CHANGEBALANCE:
                changeBal();

                //Lets the player keep the card and lets him/her to get out of jail
            case GETOUTOFJAIL:
                getOutOfJail();

                //The player receives money from all the other players
            case RECEIVEMONEYFROMPLAYERS:
                present();
    }




    }





}
