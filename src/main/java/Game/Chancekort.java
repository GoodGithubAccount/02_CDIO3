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

    public void chancekorthandling(ChancekortTypes chancekort, Board board, Player player,String[] printLinesInProgram) {
        switch (chancekort) {

            case MoveToStart:
                player.setPosition(Settings.BOARD_SIZE-Settings.BOARD_SIZE);
                System.out.println(printLinesInProgram[20]);
                break;

            case Move5Forward:
                if (player.getPosition() + 5 > Settings.BOARD_SIZE - 1) {
                    player.setPosition(player.getPosition() + 5 - Settings.BOARD_SIZE);
                } else {
                    player.setPosition(player.getPosition() + 5);
                }
                System.out.println(printLinesInProgram[21]);
                break;

            case Give2ToBank:
                int x = player.getAc().getBalance();
                player.getAc().setBalance(x - 2);
                System.out.println(printLinesInProgram[22]);
                break;

            case DoneAlleHomework:
                int y = player.getAc().getBalance();
                player.getAc().setBalance(y + 2);
                System.out.println(printLinesInProgram[23]);

                break;
            // Skatepark field should originally be free, however it is not implemented.
            case MoveToSkatepark:
                player.setPosition(Settings.BOARD_SIZE-14);
                System.out.println(printLinesInProgram[24]);

                break;

            case MoveToPear:
                player.setPosition(Settings.BOARD_SIZE-1);
                System.out.println(printLinesInProgram[25]);
                break;
        }
    }
}
