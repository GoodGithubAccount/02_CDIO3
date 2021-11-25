package Game;

import GUI.GUIMain;
import GUI.PopupBox;

import java.util.Scanner;

public class GameHandler {

    String[] printLinesInProgram;



    public GameHandler() {
        TXTReader myTXTReader = new TXTReader("Udskrift.txt");
        String temp = myTXTReader.readTXTFile();
        printLinesInProgram = temp.split("\n");
    }

    public void startGame() throws InterruptedException {



        Rafflecup r1 = new Rafflecup(1, 6);
        r1.rollar();

        System.out.println("Linje 8");
        System.out.println(printLinesInProgram[9]);
        System.out.println("Linje 9");
        System.out.print(printLinesInProgram[10]);


        int playerAmount = 100;
        while (playerAmount < Settings.MIN_PLAYERS || Settings.MAX_PLAYERS < playerAmount) {
            PopupBox myPop = new PopupBox(printLinesInProgram[0], printLinesInProgram[1]);
            playerAmount = myPop.popup().charAt(0) - 48;
        }
        Player[] players = generateplayers(playerAmount);
        System.out.println("før gui");
        // Generates the play board.
        Board myBoard = new Board(Settings.FIELD_DATABASE, Settings.CHANCE_DATABASE, Settings.BOARD_SIZE);
        myBoard.generateBoard();
        GUIMain myGui = new GUIMain(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, Settings.BOARD_SIZE, myBoard.getMyFields(), players, playerAmount);
        System.out.println("Efter gui");
        myGui.updateGUI();
        myGui.updateGUI();
        myGui.updateGUI();
        Scanner myScanner2 = new Scanner(System.in);


        do {
            for (int i = 0, playersLength = players.length; i < playersLength; i++) {
                Player player = players[i];
                turn(player, r1, myBoard);
                myGui.updateGUI();
                myScanner2.nextLine();
                if (!playermoney.playerloser(players))
                    break;
            }
            if (!playermoney.playerloser(players))
                break;
        } while (playermoney.playerloser(players));

        Player win = playermoney.playerwin(players);
        System.out.println(win.getName());
        System.out.println(printLinesInProgram[18]);


    }

    public Player[] generateplayers(int amount) {


        Player[] players = new Player[amount];
        for (int i = 0; i < amount; i++) {
            PopupBox myPop = new PopupBox(printLinesInProgram[3] + (i + 1), printLinesInProgram[4]);
            players[i] = new Player(myPop.popup());


        }
        return players;
    }


    public void turn(Player player, Rafflecup r1, Board myboard) {
        System.out.println(printLinesInProgram[5]);
        System.out.println(player.getName());

        //Tjekker om spilleren skal være i fængsel og frikender spilleren.
        if (player.isIsjailed()) {
            System.out.println(printLinesInProgram[6]);
            player.setIsjailed(false);
            return;
        }
        //Slag
        System.out.println(printLinesInProgram[7]);
        int sum = r1.sum();
        System.out.println(printLinesInProgram[8]);
        System.out.println(sum);

        player.setPosition((player.getPosition() + sum) % 23);
        //Tjek om spiller går over start
        if (player.getPosition() > Settings.BOARD_SIZE - 1)
            player.getAc().newBalance(Settings.GO_SPOT_MONEY);

        Field field = myboard.getMyFields()[player.getPosition()];


        System.out.println(printLinesInProgram[9]);
        System.out.println(field.getName());
        System.out.println(printLinesInProgram[10]);
        System.out.println(field.getfType());
        System.out.println(printLinesInProgram[11]);
        System.out.println(player.getPosition());
        //Standard miste penge på felts værdi

        //Tjekker om de specialle cases Jail free parking go jail property ogg chance.
        switch (field.getfType()) {
            case PROPERTY:
                if (field.getOwner() == null) {
                    player.getAc().newBalance(-field.getPrice());
                    if (player.getSoldSigns() > 0) {
                        field.setOwner(player);
                        System.out.println(printLinesInProgram[12]);
                    } else
                        System.out.println(printLinesInProgram[13]);
                } else {
                    if (field.getOwner().equals(player)) {
                        System.out.println(printLinesInProgram[14]);
                    } else {
                        System.out.println(printLinesInProgram[15]);
                        System.out.println(field.getOwner().getName());
                        System.out.println(printLinesInProgram[16]);
                        System.out.println(field.getPrice());
                        player.getAc().newBalance(-field.getPrice());
                        field.getOwner().getAc().newBalance(field.getPrice());

                    }

                }
                break;
            case FREEPARKING:
            case JAIL:
            case START:
                break;
            case GOJAIL:
                System.out.println(printLinesInProgram[17]);
                player.setPosition(6);
                player.setIsjailed(true);
            case CHANCE:
                //Når chance metoden kommer vil der skrives noget i denne branch af switchen
                break;
        }
    }
}
