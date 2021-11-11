package GUI;

import javax.swing.*;
import java.awt.*;

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



    public GUIMain(int width, int height, int gridCount){
        // Width of the panel in pixels
        this.width = width;
        this.height = height;

        if(width > height) limitingFactor = height;
        else limitingFactor = width;

        // Sets the grid size according to the amount of grids and the screen size. Uses the limiting factor i.e the smallest of the two dimensions.
        this.gridCount = gridCount;
        gridSize = limitingFactor / (gridCount / 2) + 10;
        gridCountLine = (gridCount / 4) + 1;

        // Gets the starting points according to the width of the screen, the amount of grids, and the amount of grids per line.
        // Done to center the board. Not perfect, but good enough.
        startingPointX = (int)Math.round((width / 2) - (gridSize * (gridCountLine / 2)));
        startingPointY = (int)Math.round((height / 2) - (gridSize * (gridCountLine / 2)));

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(Board);
    }

    private JPanel Board = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int currentPointX = startingPointX;
            int currentPointY = startingPointY;

            String test = "GRAY";
            Color myColor = Color.GRAY;

            for(int i = 0; i < gridCount; i++){
                g.setColor(myColor);
                if(myColor == Color.GRAY) myColor = Color.LIGHT_GRAY;
                else myColor = Color.GRAY;

                if(i == 0){
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else if(i >= gridCountLine * 3 - 3) {
                    currentPointY -= gridSize;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else if(i >= gridCountLine * 2 - 2){
                    currentPointX -= gridSize;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else if(i >= gridCountLine - 1){
                    currentPointY += gridSize;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else{
                    currentPointX += gridSize;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
            }
        }
    };
}
