package test;

import Game.Die;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


class DieTest {
    Die myTestDie= new Die(6);

    @Test
    void roll() {
        int faceAmount=6;
        myTestDie.setFaceAmount(faceAmount);
        int[] countar= new int[faceAmount];
        int rolls=100000000;
        for (int i = 0; i < rolls; i++) {
            myTestDie.roll();
            countar[myTestDie.getValue()-1]++;


        }
        int maxDeviation=0;
        for (int j : countar) {
            if (Math.abs(j) > maxDeviation)
                maxDeviation = Math.abs(j);

        }
        maxDeviation=maxDeviation-rolls/6;
        System.out.println(maxDeviation);
        System.out.println(Arrays.toString(countar));
        assertTrue(maxDeviation<rolls/10000);








    }
}