package Game;

import GUI.GUIMain;
import GUI.PopupBox;

import java.util.Scanner;

public class GameHandler {

    public GameHandler() {

    }

    public void startGame() throws InterruptedException {
        Rafflecup r1 = new Rafflecup(1, 6);
        r1.rollar();

        Scanner myScanner = new Scanner(System.in);

        int playerAmount = 100;
        while (playerAmount < Settings.MIN_PLAYERS || Settings.MAX_PLAYERS < playerAmount) {
            PopupBox myPop = new PopupBox("Indtast antal spillere", "Min 2 max 4");
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
            for (Player player : players) {
                turn(player, r1, myBoard);
                goon.nextLine();
                myGui.updateGUI();
                if (playermoney.playerloser(players))
                    break;
            }
        }
    }

    public static Player[] generateplayers(int amount) {


        Player[] players = new Player[amount];
        for (int i = 0; i < amount; i++) {
            PopupBox myPop = new PopupBox("Indtast navn på spiller: " + (i + 1), "Popup");
            players[i] = new Player(myPop.popup());


        }
        return players;
    }


    public void turn(Player player, Rafflecup r1, Board myboard) {
        System.out.println("Det er din tur: "+player.getName());

        //Tjekker om spilleren skal være i fængsel og frikender spilleren.
        if (player.isIsjailed()) {
            System.out.println("Du er i fængsel og er blevet sprunget over, du er fri i næste tur");
            player.setIsjailed(false);
            return;
        }
        //Slag
        System.out.println("Roll the die ");
        int sum = r1.sum();
        System.out.println("du slog" + sum);

        player.move(player.getPosition() + sum);
        //Tjek om spiller går over start
        if (player.getPosition() > Settings.BOARD_SIZE - 1)
            player.getAc().newBalance(Settings.GO_SPOT_MONEY);

        Field field = myboard.getMyFields()[player.getPosition()];
        System.out.println("Du landende på: " + field.getName() + " Med felttypen" + field.getfType());
        System.out.println("Du har positionen: "+player.getPosition());

        //Standard miste penge på felts værdi

        //Tjekker om de specialle cases Jail free parking go jail property ogg chance.
        switch (field.getfType()) {
            case PROPERTY:
                if (field.getOwner() == null) {
                    player.getAc().newBalance(-field.getPrice());
                    if (player.getSoldSigns() > 0) {
                        field.setOwner(player);
                        System.out.println("Du er nu den stolte ejer af dette felt");
                    } else
                        System.out.println("Du har ikke flere billeter du kan derfor ikke købe denne grund");
                } else {
                    if (field.getOwner().equals(player)) {
                        System.out.println("Du ejer denne grund og der sker derfor ingentin");
                    } else
                        System.out.println("Spiller: " + field.getOwner().getName() + " ejer denne grund du skylder derfor harm: " + field.getPrice());
                    player.getAc().newBalance(-field.getPrice());
                    field.getOwner().getAc().newBalance(field.getPrice());
                }
                break;
            case FREEPARKING:
            case JAIL:
            case START:
                break;
            case GOJAIL:
                System.out.println("Du er røget i fængsel");
                player.move(6);
                player.setIsjailed(true);
            case CHANCE:
                //Når chance metoden kommer vil der skrives noget i denne branch af switchen
                break;
        }
    }
}
