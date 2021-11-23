package Game;

import Game.Board;
import Game.Settings;

public class Trymain {
    public static void main(String[]args){
        Board board=new Board(Settings.FIELD_DATABASE, Settings.BOARD_SIZE);
        board.generateBoard();
        System.out.println();


    }
}


