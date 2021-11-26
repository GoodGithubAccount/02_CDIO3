package Game;

import java.util.Random;

public class Chancekort {

    public enum ChancekortTypes {
        MoveToStart,
        Move5Forward,
        Give2ToBank,
        DoneAlleHomework,
        MoveToSkatepark,
        MoveToPear,

    }

    public ChancekortTypes DrawRandomChanceCard() {
        int x = new Random().nextInt(ChancekortTypes.values().length);
        return ChancekortTypes.values()[x];
    }

    public void chancekorthandling(ChancekortTypes chancekort, Board board, Player player) {
        switch (chancekort) {

            case MoveToStart:
                player.setPosition(Settings.BOARD_SIZE-Settings.BOARD_SIZE);
                System.out.println("Du rykker direkte til Start." );
                break;

            case Move5Forward:
                if (player.getPosition() + 5 > Settings.BOARD_SIZE - 1) {
                    player.setPosition(player.getPosition() + 5 - Settings.BOARD_SIZE);
                } else {
                    player.setPosition(player.getPosition() + 5);
                }
                System.out.println("Du rykker 5 felter frem. ");
                break;

            case Give2ToBank:
                int x = player.getAc().getBalance();
                player.getAc().setBalance(x - 2);
                System.out.println("Du har spist for meget slik. Giv 2kr til banken. ");
                break;

            case DoneAlleHomework:
                int y = player.getAc().getBalance();
                player.getAc().setBalance(y + 2);
                System.out.println("Du har lavet dine lektier og får 2kr.");

                break;
            // Skatepark field should originally be free, however it is not implemented.
            case MoveToSkatepark:
                player.setPosition(Settings.BOARD_SIZE-14);
                System.out.println("Du har ramt chancen og skal flytte til Skatepark. ");

                break;

            case MoveToPear:
                player.setPosition(Settings.BOARD_SIZE-1);
                System.out.println("Du har ramt chancen og skal flytte til Pear. ");
                break;
        }
    }
}
