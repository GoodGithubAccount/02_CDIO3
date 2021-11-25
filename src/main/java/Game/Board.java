package Game;

import java.util.*;

public class Board {

    private int boardSize;

    private String fieldDatabase;
    private String chanceDatabase;
    private Field[] myFields;
    private Chance[] myChance;

    public Board(String fieldDatabase, String chanceDatabase, int boardSize) {
        this.fieldDatabase = fieldDatabase;
        this.chanceDatabase = chanceDatabase;
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

    public void generateChance() {
        String Temp = loadFromTXT(chanceDatabase);

        String[] chance = Temp.split("\n");
        myChance = new Chance[chance.length];
        for (int i = 0; i < chance.length; i++) {
            String[] chanceProperties = chance[i].split("-");
            myChance[i] = new Chance(chanceProperties[0], chanceProperties[1], Integer.parseInt(chanceProperties[3]), chanceProperties[4], Integer.parseInt(chanceProperties[5]), Chance.cardType.valueOf(chanceProperties[6]));
        }
    }

    public void shuffleChance() {
        List<Chance> chanceList = Arrays.asList(myChance);
        Collections.shuffle(chanceList);
        chanceList.toArray(myChance);
    }

    public Field[] getMyFields() {
        return myFields;
    }

}