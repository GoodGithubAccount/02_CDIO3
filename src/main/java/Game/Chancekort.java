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
                player.setPosition(0);
                break;

            case Move5Forward:
                if (player.getPosition() + 5 > Settings.BOARD_SIZE - 1) {
                    player.setPosition(player.getPosition() + 5 - Settings.BOARD_SIZE);
                } else {
                    player.setPosition(player.getPosition() + 5);
                }
                break;

            case Give2ToBank:
                int x = player.getAc().getBalance();
                player.getAc().setBalance(x - 2);

                break;

            case DoneAlleHomework:
                int y = player.getAc().getBalance();
                player.getAc().setBalance(y + 2);

                break;
// Burde få skatepark gratis, men er ikke implementeret.
            case MoveToSkatepark:
                player.setPosition(10);

                break;

            case MoveToPear:
                player.setPosition(23);

                break;
        }
    }
}
