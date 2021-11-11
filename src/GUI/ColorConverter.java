package GUI;

import java.awt.*;

public class ColorConverter {

    private static Color myColor = Color.WHITE;

    public static Color ConvertColor(String sColor){

        switch(sColor.toUpperCase()) {
            case "YELLOW":
                myColor = Color.YELLOW;
                break;
            case "BLUE":
                myColor = Color.BLUE;
                break;
            case "RED":
                myColor = Color.RED;
                break;
            case "CYAN":
                myColor = Color.CYAN;
                break;
            case "GREEN":
                myColor = Color.GREEN;
                break;
            case "BROWN":
                //myColor = Color.B;
                break;
            default:
                myColor = Color.WHITE;
                break;
        };
        
        return myColor;
    }
}
