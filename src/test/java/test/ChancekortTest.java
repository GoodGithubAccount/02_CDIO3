package test;

import Game.Chancekort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChancekortTest {
    Chancekort mytestcard= new Chancekort();

    @Test
    void drawRandomChanceCard() {
        System.out.println(mytestcard.DrawRandomChanceCard().toString());
    }
}