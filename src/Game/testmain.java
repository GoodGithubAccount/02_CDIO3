package Game;

import GUI.GUIMain;
import Game.Rafflecup;

import java.io.IOException;
import java.util.Arrays;

public class testmain {

    public static void main(String[] args) {
        //Rafflecup r1=new Rafflecup(2,6);
        //r1.rollar();
        //System.out.println(Arrays.toString(r1.getCup()));

        TXTReader myReader = new TXTReader("fieldDatabase.txt");
        String test = myReader.readTXTFile();
        System.out.println(test);

        GUIMain myGui = new GUIMain(1600, 900, 24);


    }
}
