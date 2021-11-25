package Game;

import java.util.Random;

public class Chancekort {
    public enum ChancekortTypes {
        MoveToStart,
        Move5Forward,
        Give2ToBank
    }

    public ChancekortTypes DrawRandomChanceCard() {
        int x = new Random().nextInt(ChancekortTypes.values().length);
        return ChancekortTypes.values()[x];
    }

    public void chancekorthandling(ChancekortTypes chancekort, Board board, Player player) {
        switch (chancekort) {
            // Test at MoveToStart sætter til start.
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
        }
    }
}
