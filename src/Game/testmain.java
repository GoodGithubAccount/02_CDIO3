package Game;

import GUI.GUIMain;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class testmain {

    public static void main(String[] args) {
        Rafflecup r1 = new Rafflecup(1, 6);
        r1.rollar();
        Scanner playeramount = new Scanner(System.in);
        Player[] players = new Player[0];
        while (true) {
            System.out.println("Hvor mange spillere er i man kan spille mellem 2 og 4 spillere");
            int amountplaYER = playeramount.nextInt();

            if (amountplaYER >= 2 && amountplaYER <= 4)
                players = generateplayers(amountplaYER);
            break;
        }


        TXTReader myReader = new TXTReader(Settings.FIELD_DATABASE);
        String test = myReader.readTXTFile();
        System.out.println(test);

        Board myBoard = new Board(Settings.FIELD_DATABASE, Settings.CHANCE_DATABASE, Settings.BOARD_SIZE);
        myBoard.generateBoard();

        Field[] myFields = myBoard.getMyFields();

        for (int i = 0; i < Settings.BOARD_SIZE; i++) {
            System.out.println("NUMBER " + i + ": " + myFields[i].getfType() + myFields[i].getColor() + myFields[i].getPrice() + myFields[i].getName());
        }


        GUIMain myGui = new GUIMain(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, 24, myFields);
    }

    public static Player[] generateplayers(int amount) {
        Scanner playername = new Scanner(System.in);

        Player[] players = new Player[amount];
        for (int i = 0; i < amount; i++) {
            System.out.println("Indtast navn på spiller: " + i);
            players[i] = new Player(playername.nextLine());

        }
        return players;

    }

    public static void turn(Player player, Rafflecup r1, Board myboard) {
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

        //Tjek om spiller går over start
        if (player.getPosition() > 23)
            player.getAc().newBalance(Settings.GO_SPOT_MONEY);

        //Standard miste penge på felts værdi
        player.setPosition(player.getPosition() + sum);
        player.getAc().newBalance(myboard.getMyFields()[player.getPosition()].price);

        //Tjekker om de specialle cases Jail free parking go jail property ogg chance.
        Field f1 = myboard.getMyFields()[player.getPosition()];
        switch (f1.fType) {
            case PROPERTY:
                if (f1.owner == null) {
                    f1.owner = player;
                } else {
                    f1.owner.getAc().newBalance(f1.price);
                }
                break;
            case FREEPARKING:
            case JAIL:
            case START:
                break;
            case GOJAIL:
                player.setPosition(6);
                player.setIsjailed(true);
            case CHANCE:
                //Når chance metoden kommer vil der skrives noget i denne branch af switchen
                break;
        }


    }
}
