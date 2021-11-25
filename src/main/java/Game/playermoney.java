package Game;

public class playermoney {

    public playermoney() {
        Player[] players = new Player[4];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("players" + i);
        }

    }

    public static Player playerwin(Player[] winner) {
        Player largest = new Player("tt");

        for (int i = 0; i < winner.length; i++) {
            if (winner[i].getAc().getBalance() > largest.getAc().getBalance()) {
                largest = winner[i];
            }


        }
        return largest;
    }

    public static boolean playerloser(Player[] loser) {

        for (int i = 0; i < loser.length; i++) {
            if (loser[i].getAc().getBalance() <= 0) {
                return true;
            }
        }
        return false;

    }

}
