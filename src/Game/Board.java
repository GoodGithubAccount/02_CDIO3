package Game;

public class Board {

    int boardSize;

    String fieldDatabase;
    String chanceDatabase;
    Field[] myFields;
    Chance[] myChance;

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

            myFields[i] = new Field(Field.fieldType.valueOf(fieldProperties[0]), fieldProperties[1], Integer.parseInt(fieldProperties[2]), fieldProperties[3]);
        }
    }

    public void generateChance() {
        String Temp = loadFromTXT(chanceDatabase);

        String[] chance = Temp.split("\n");
myChance = new Chance[chance.length];
        for (int i = 0; i <chance.length; i++) {
            String[] chanceProperties = chance[i].split("-");

        }
    }
}