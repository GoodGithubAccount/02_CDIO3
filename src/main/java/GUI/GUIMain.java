package GUI;

import javax.swing.*;
import java.awt.*;

import Game.Field;
import Game.Player;

public class GUIMain extends JPanel {

    // window size
    private int width;
    private int height;
    private int limitingFactor;

    // Gridsize and count
    private int gridSize;
    private int gridCount;
    private int gridCountLine;

    // GUI Starting point
    private int startingPointX;
    private int startingPointY;

    // Field data
    private Field[] myFields;
    private JLabel[] fieldText;
    private JLabel[] fieldOwnerText;

    // Player data
    private int playerCount;
    private Player[] myPlayers;
    private JLabel[] playerText;
    private Color[] playerColors;

    // Player representations offsets
    private int[] playerOffsetX;
    private int[] playerOffsetY;

    // Game text
    private JLabel gameText;
    private String gameTextData;

    public GUIMain(int width, int height, int gridCount, Field[] myFields, Player[] myPlayers, int playerCount) {
        // Field data
        this.myFields = myFields;
        this.fieldText = new JLabel[gridCount];
        this.fieldOwnerText = new JLabel[gridCount];

        // Temporary game text
        this.gameTextData = "New Game";

        // Player data
        this.myPlayers = myPlayers;
        this.playerText = new JLabel[playerCount];
        this.playerCount = playerCount;

        // Width of the panel in pixels
        this.width = width;
        this.height = height;

        // Calculating GUI limiting factor
        if (width > height) limitingFactor = height;
        else limitingFactor = width;

        // Sets the grid size according to the amount of grids and the screen size. Uses the limiting factor i.e the smallest of the two dimensions.
        this.gridCount = gridCount;
        gridCountLine = (gridCount / 4) + 1;
        gridSize = limitingFactor / (gridCountLine + 1);

        playerOffsetX = new int[]{(gridSize / 4), (gridSize / 4 * 2), (gridSize / 4), (gridSize / 4 * 2)};
        playerOffsetY = new int[]{(gridSize / 4), (gridSize / 4), (gridSize / 4 * 2), (gridSize / 4 * 2)};
        playerColors = new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};

        // Gets the starting points according to the width of the screen, the amount of grids, and the amount of grids per line.
        // Done to center the board. Not perfect, but good enough.
        startingPointX = (int) Math.round((width / 2) - (gridSize * (gridCountLine / 2)));
        startingPointY = (int) Math.round((height / 2) - (gridSize * (gridCountLine / 2))) - 50;

        JFrame frame = new JFrame("Good Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(Board);
        frame.setVisible(true);
    }

    // Function to make gui redraw the whole board
    public void updateGUI() throws InterruptedException {
        Thread.sleep(10);
        Board.removeAll();
        Board.updateUI();
    }

    public void setGameTextData(String text) {
        gameTextData = text;
    }

    private JPanel Board = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int currentPointX = startingPointX;
            int currentPointY = startingPointY;

            String test = "GRAY";
            Color fieldColor = Color.GRAY;

            for (int i = 0; i < gridCount; i++) {
                g.setColor(fieldColor);
                if (fieldColor == Color.GRAY) fieldColor = Color.LIGHT_GRAY;
                else fieldColor = Color.GRAY;

                Color propertyColor = ColorConverter.ConvertColor(myFields[i].getColor());

                if (i == 0) {
                    // Do nothing
                } else if (i >= gridCountLine * 3 - 3) {
                    currentPointY -= gridSize;
                } else if (i >= gridCountLine * 2 - 2) {
                    currentPointX -= gridSize;
                } else if (i >= gridCountLine - 1) {
                    currentPointY += gridSize;
                } else {
                    currentPointX += gridSize;
                }

                g.fillRect(currentPointX, currentPointY, gridSize, gridSize);
                myFields[i].setFieldPosition(currentPointX, currentPointY);

                if (propertyColor != Color.WHITE) {
                    g.setColor(propertyColor);
                    g.fillRect(currentPointX, currentPointY + gridSize - gridSize / 5, gridSize, gridSize / 5);

                    if (myFields[i].getOwner() == null) {
                        fieldOwnerText[i] = new JLabel(myFields[i].getPrice() + " | " + "Unowned");
                    } else {
                        fieldOwnerText[i] = new JLabel(myFields[i].getPrice() + " | " + myFields[i].getOwner().getName());
                    }

                    fieldOwnerText[i].setBounds(currentPointX, currentPointY, gridSize, gridSize / 20 * 19);
                    fieldOwnerText[i].setVerticalAlignment(SwingConstants.BOTTOM);
                    fieldOwnerText[i].setHorizontalAlignment(SwingConstants.RIGHT);
                    Board.add(fieldOwnerText[i]);
                }

                fieldText[i] = new JLabel(i + " | " + myFields[i].getName());
                fieldText[i].setHorizontalAlignment(SwingConstants.CENTER);
                fieldText[i].setBounds(currentPointX, currentPointY, gridSize, gridSize / 5);

                Board.add(fieldText[i]);
            }

            // Game text, that needs to be sent text by some sorta function from main.
            gameText = new JLabel(gameTextData);
            gameText.setBounds(startingPointX, startingPointY + gridSize * 4, gridSize * 5, gridSize);
            Board.add(gameText);

            for (int c = 0; c < playerCount; c++) {
                // Player representations
                g.setColor(playerColors[c]);
                int playerPosition = myPlayers[c].getPosition();
                int[] playerPositionCoord = myFields[playerPosition].getFieldPosition();
                g.fillOval(playerPositionCoord[0] + playerOffsetX[c], playerPositionCoord[1] + playerOffsetY[c], gridSize / 5, gridSize / 5);

                // Player text, JLabel uses html for formatting.
                playerText[c] = new JLabel("<html>" + myPlayers[c].getName() +
                        "<br/>Money: " + myPlayers[c].getAc().getBalance() + "</html>");
                playerText[c].setBounds(startingPointX + gridSize * (c + 1), startingPointY + gridSize, gridSize, gridSize);
                Board.add(playerText[c]);
            }
        }

    };
}
