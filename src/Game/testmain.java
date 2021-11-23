package Game;

import GUI.GUIMain;
import Game.Rafflecup;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class testmain {

    public static void main(String[] args) {
        Rafflecup r1=new Rafflecup(1,6);
        r1.rollar();
        Scanner playeramount = new Scanner(System.in);
        Player[] players=new Player[0];
        while (true) {
            System.out.println("Hvor mange spillere er i man kan spille mellem 2 og 4 spillere");
            int amountplaYER = playeramount.nextInt();

            if (amountplaYER >= 2 || amountplaYER >= 4)
                players = generateplayers(amountplaYER);
            break;
        }


        TXTReader myReader = new TXTReader(Settings.FIELD_DATABASE);
        String test = myReader.readTXTFile();
        System.out.println(test);

        Board myBoard = new Board(Settings.FIELD_DATABASE, Settings.BOARD_SIZE);
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
    public static void turn(Player player, Rafflecup r1, Board myboard){
        System.out.println("Roll the die ");
        int sum=r1.sum();
        System.out.println("du slog"+sum);
        player.setPosition(player.getPosition()+ sum);
        player.getAc().setBalance(myboard.getMyFields()[player.getPosition()].price);





    }
}
