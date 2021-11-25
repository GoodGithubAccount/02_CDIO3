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

        Scanner myScanner = new Scanner(System.in);

        int playerAmount = 100;
        while (playerAmount < Settings.MIN_PLAYERS || Settings.MAX_PLAYERS < playerAmount) {
            PopupBox myPop = new PopupBox(this.printLinesInProgram[0], this.printLinesInProgram[1]);
            playerAmount = myPop.popup().charAt(0) - 48;
        }
        Player[] players = generateplayers(playerAmount);

        // Generates the play board.
        Board myBoard = new Board(Settings.FIELD_DATABASE, Settings.CHANCE_DATABASE, Settings.BOARD_SIZE);
        myBoard.generateBoard();

        GUIMain myGui = new GUIMain(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, Settings.BOARD_SIZE, myBoard.getMyFields(), players, playerAmount);
        myGui.updateGUI();
        myGui.updateGUI();
        myGui.updateGUI();
        Scanner goon = new Scanner(System.in);
        while (true) {
            for (int i = 0, playersLength = players.length; i < playersLength; i++) {
                System.out.println(this.printLinesInProgram[2] + i);
                turn(players[i], r1, myBoard);
                myGui.updateGUI();
                goon.nextLine();
                if (!playermoney.playerloser(players))
                    break;
            }
            if (!playermoney.playerloser(players))
                break;
        }
    }

    public Player[] generateplayers(int amount) {


        Player[] players = new Player[amount];
        for (int i = 0; i < amount; i++) {
            PopupBox myPop = new PopupBox(this.printLinesInProgram[3] + (i + 1), this.printLinesInProgram[4]);
            players[i] = new Player(myPop.popup());


        }
        return players;
    }


    public void turn(Player player, Rafflecup r1, Board myboard) {
        System.out.println(this.printLinesInProgram[5] + player.getName());

        //Tjekker om spilleren skal være i fængsel og frikender spilleren.
        if (player.isIsjailed()) {
            System.out.println(this.printLinesInProgram[6]);
            player.setIsjailed(false);
            return;
        }
        //Slag
        System.out.println(this.printLinesInProgram[7]);
        int sum = r1.sum();
        System.out.println(this.printLinesInProgram[8] + sum);

        player.setPosition((player.getPosition() + sum) % 23);
        //Tjek om spiller går over start
        if (player.getPosition() > Settings.BOARD_SIZE - 1)
            player.getAc().newBalance(Settings.GO_SPOT_MONEY);

        Field field = myboard.getMyFields()[player.getPosition()];
        System.out.println(this.printLinesInProgram[9] + field.getName() + this.printLinesInProgram[10] + field.getfType());
        System.out.println(this.printLinesInProgram[11] + player.getPosition());

        //Standard miste penge på felts værdi

        //Tjekker om de specialle cases Jail free parking go jail property ogg chance.
        switch (field.getfType()) {
            case PROPERTY:
                if (field.getOwner() == null) {
                    player.getAc().newBalance(-field.getPrice());
                    if (player.getSoldSigns() > 0) {
                        field.setOwner(player);
                        System.out.println(this.printLinesInProgram[12]);
                    } else
                        System.out.println(this.printLinesInProgram[13]);
                } else {
                    if (field.getOwner().equals(player)) {
                        System.out.println(this.printLinesInProgram[14]);
                    } else
                        System.out.println(this.printLinesInProgram[15] + field.getOwner().getName() + this.printLinesInProgram[16] + field.getPrice());
                    player.getAc().newBalance(-field.getPrice());
                    field.getOwner().getAc().newBalance(field.getPrice());
                }
                break;
            case FREEPARKING:
            case JAIL:
            case START:
                break;
            case GOJAIL:
                System.out.println(this.printLinesInProgram[17]);
                player.setPosition(6);
                player.setIsjailed(true);
            case CHANCE:
                //Når chance metoden kommer vil der skrives noget i denne branch af switchen
                break;
        }
    }
}
