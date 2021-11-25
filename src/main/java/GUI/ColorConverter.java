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
            case "ORANGE":
                myColor = Color.ORANGE;
                break;
            case "MAGENTA":
                myColor = Color.MAGENTA;
                break;
            case "PINK":
                myColor = Color.PINK;
                break;
            default:
                myColor = Color.WHITE;
                break;
        };
        
        return myColor;
    }
}
