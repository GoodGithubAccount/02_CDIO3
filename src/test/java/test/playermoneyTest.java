package test;

import Game.Player;
import Game.playermoney;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class playermoneyTest {
    Player ptest = new Player("test");
    Player ptest2 = new Player("test2");
    Player ptest3 = new Player("test3");
    Player ptest4 = new Player("test4");

    Player[] artest = new Player[4];


    @Test
    void playerwin() {
        artest[0] = ptest;
        artest[1] = ptest2;
        artest[2] = ptest3;
        artest[3] = ptest4;
        ptest.getAc().setBalance(0);
        ptest2.getAc().setBalance(120);
        ptest3.getAc().setBalance(50);
        ptest4.getAc().setBalance(65);

        Player winner=playermoney.playerwin(artest);
        assertTrue(ptest2.equals(winner));




    }

    @Test
    void playerloser() {
        artest[0] = ptest;
        artest[1] = ptest2;
        ptest.getAc().setBalance(0);

        boolean testbool = playermoney.playerloser(artest);
        assertTrue(testbool);

    }
}