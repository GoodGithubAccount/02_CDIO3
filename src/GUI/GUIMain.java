package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIMain extends JPanel {

    // window size
    private int width;
    private int height;

    private int gridSize;
    private int gridCount;

    private int startingPointX;
    private int startingPointY;

    public GUIMain(int width, int height, int gridCount){
        this.width = width;
        this.height = height;

        this.gridCount = gridCount;
        gridSize = height / 10;

        startingPointX = (int)Math.round((width / 2) - (gridSize * 3.5));
        startingPointY = (int)Math.round((height / 2) - (gridSize * 3.5));

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

            int gridCountLine = (gridCount / 4) + 1;

            Color myColor = Color.GRAY;
            g.setColor(myColor);

            int currentPointX = startingPointX;
            int currentPointY = startingPointY;

            for(int i = 0; i < gridCount; i++){
                g.setColor(myColor);
                if(myColor == Color.GRAY) myColor = Color.LIGHT_GRAY;
                else myColor = Color.GRAY;

                if(i == 0){
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else if(i >= gridCountLine * 3 - 3) {
                    currentPointY -= gridSize + 1;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else if(i >= gridCountLine * 2 - 2){
                    currentPointX -= gridSize + 1;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else if(i >= gridCountLine - 1){
                    currentPointY += gridSize + 1;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
                else{
                    currentPointX += gridSize + 1;
                    g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                }
            }
        }
    };
}
