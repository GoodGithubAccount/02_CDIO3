package GUI;

import javax.swing.*;
import java.awt.*;

import Game.Field;

public class GUIMain extends JPanel {

    // window size
    private int width;
    private int height;
    private int limitingFactor;

    private int gridSize;
    private int gridCount;
    int gridCountLine;

    private int startingPointX;
    private int startingPointY;

    private Field[] myFields;
    private JLabel[] fieldText;
    private JLabel[] fieldOwnerText;

    public GUIMain(int width, int height, int gridCount, Field[] myFields){
        this.myFields = myFields;
        this.fieldText = new JLabel[gridCount];
        this.fieldOwnerText = new JLabel[gridCount];

        // Width of the panel in pixels
        this.width = width;
        this.height = height;

        if(width > height) limitingFactor = height;
        else limitingFactor = width;

        // Sets the grid size according to the amount of grids and the screen size. Uses the limiting factor i.e the smallest of the two dimensions.
        this.gridCount = gridCount;
        gridCountLine = (gridCount / 4) + 1;
        gridSize = limitingFactor / (gridCountLine + 1);

        // Gets the starting points according to the width of the screen, the amount of grids, and the amount of grids per line.
        // Done to center the board. Not perfect, but good enough.
        startingPointX = (int)Math.round((width / 2) - (gridSize * (gridCountLine / 2)));
        startingPointY = (int)Math.round((height / 2) - (gridSize * (gridCountLine / 2))) - 50;

        JFrame frame = new JFrame("Good Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(Board);
        frame.setVisible(true);
    }

    private JPanel Board = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int currentPointX = startingPointX;
            int currentPointY = startingPointY;

            String test = "GRAY";
            Color fieldColor = Color.GRAY;

            for(int c = 0; c < playerCount)

            for(int i = 0; i < gridCount; i++){
                g.setColor(fieldColor);
                if(fieldColor == Color.GRAY) fieldColor = Color.LIGHT_GRAY;
                else fieldColor = Color.GRAY;

                Color propertyColor = ColorConverter.ConvertColor(myFields[i].getColor());

                if(i == 0){
                    // Do nothing
                }
                else if(i >= gridCountLine * 3 - 3) {
                    currentPointY -= gridSize;
                }
                else if(i >= gridCountLine * 2 - 2){
                    currentPointX -= gridSize;
                }
                else if(i >= gridCountLine - 1){
                    currentPointY += gridSize;
                }
                else{
                    currentPointX += gridSize;
                }

                g.fillRect(currentPointX, currentPointY, gridSize, gridSize);

                if(propertyColor != Color.WHITE){
                    g.setColor(propertyColor);
                    g.fillRect(currentPointX, currentPointY + gridSize - gridSize/5, gridSize, gridSize / 5);

                    if(myFields[i].getOwner() == null){
                        fieldOwnerText[i] = new JLabel("Test");
                                //new JLabel(myFields[i].getOwner().getName());
                        fieldOwnerText[i].setBounds(currentPointX, currentPointY, gridSize, gridSize);
                        fieldOwnerText[i].setVerticalAlignment(SwingConstants.BOTTOM);
                        fieldOwnerText[i].setHorizontalAlignment(SwingConstants.RIGHT);
                        Board.add(fieldOwnerText[i]);
                    }
                }

                fieldText[i] = new JLabel(myFields[i].getName());
                fieldText[i].setHorizontalAlignment(SwingConstants.CENTER);
                fieldText[i].setBounds(currentPointX, currentPointY, gridSize, gridSize / 5);



                Board.add(fieldText[i]);
            }
        }

    };
}
