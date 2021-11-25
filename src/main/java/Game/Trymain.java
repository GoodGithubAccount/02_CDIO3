package Game;

public class Trymain {
    public static void main(String[]args){
        /*
        Board board=new Board(Settings.FIELD_DATABASE, Settings.BOARD_SIZE);
        board.generateBoard();
        System.out.println();
         */

        Chancekort chancekort = new Chancekort();
        for (int i = 0; i < 100; i++) {
            System.out.println(chancekort.DrawRandomChanceCard());
        }

    }
}


