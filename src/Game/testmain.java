package Game;

import Game.Rafflecup;

import java.util.Arrays;

public class testmain {

    public static void main(String[] args) {
        Rafflecup r1=new Rafflecup(2,6);
        r1.rollar();
        System.out.println(Arrays.toString(r1.getCup()));


    }
}
