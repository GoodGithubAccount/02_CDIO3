package Game;

import java.util.*;

public class Board {

    private int boardSize;

    private String fieldDatabase;
    private Field[] myFields;

    public Board(String fieldDatabase, int boardSize) {
        this.fieldDatabase = fieldDatabase;
        this.boardSize = boardSize;
        this.myFields = new Field[boardSize];
    }

    private String loadFromTXT(String txtDatabase) {
        TXTReader myReader = new TXTReader(txtDatabase);
        return myReader.readTXTFile();
    }

    public void generateBoard() {
        String Temp = loadFromTXT(fieldDatabase);

        String[] fields = Temp.split("\n");

        for (int i = 0; i < boardSize; i++) {
            String[] fieldProperties = fields[i].split("-");

            myFields[i] = new Field(Field.fieldType.valueOf(fieldProperties[0]), fieldProperties[1],
                    Integer.parseInt(fieldProperties[2]), fieldProperties[3], Integer.parseInt(fieldProperties[4]));
        }
    }




    public Field[] getMyFields() {
        return myFields;
    }

}