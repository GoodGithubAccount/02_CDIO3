package Game;

public class Board {

    int boardSize;

    String fieldDatabase;
    Field[] myFields;

    public Board(String fieldDatabase, int boardSize){
        this.fieldDatabase = fieldDatabase;
        this.boardSize = boardSize;
        this.myFields = new Field[boardSize];
    }

    private String loadFromTXT(){
        TXTReader myReader = new TXTReader(fieldDatabase);
        return myReader.readTXTFile();
    }

    public void generateBoard(){
        String Temp = loadFromTXT();

        String[] fields = Temp.split("\n");

        for(int i = 0; i < boardSize; i++){
            String[] fieldProperties = fields[i].split("-");

            myFields[i] = new Field(Field.fieldType.valueOf(fieldProperties[0]), fieldProperties[1], Integer.parseInt(fieldProperties[2]), fieldProperties[3]);
        }
    }

    public Field[] getMyFields() { return myFields; }
}