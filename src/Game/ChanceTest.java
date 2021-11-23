package Game;

public class ChanceTest {

    public static enum cardType{
        GIVEPLAYERCARD,MOVETOSPACE,MOVECERTAINDISTANCE,CHOISE,CHANGEBALANCE,GETOUTOFJAIL,RECEIVEMONEYFROMPLAYERS
    }

    public static void main(String[] args) {
        cardType cType=cardType.GIVEPLAYERCARD;

        switch (cType){
                //The player who draws this car has to give the card to a specified player and then draw another card.
            case GIVEPLAYERCARD:
                //Mangler at kunne give kort til anden spiller


                //Lets the player move to a specified field
            case MOVETOSPACE:


                //Lets the player move a specified distance
            case MOVECERTAINDISTANCE:


                //The player can either move 1 forward or take another card
            case CHOISE:


                //The player either loses or gains some money
            case CHANGEBALANCE:


                //Lets the player keep the card and lets him/her to get out of jail
            case GETOUTOFJAIL:

                //The player receives money from all the other players
            case RECEIVEMONEYFROMPLAYERS:

    }




    }





}
