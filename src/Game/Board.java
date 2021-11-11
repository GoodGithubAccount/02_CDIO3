package Game;

public class Board {

    int boardSize;

    String fieldDatabase;
    Field[] myFields;

    Board(String fieldDatabase, int boardSize){
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

class Field {

    public enum fieldType{
        PROPERTY, GOJAIL, JAIL, CHANCE, FREEPARKING, START
    }

    fieldType fType;
    String color;
    int price;
    Player owner;
    String name;

    Field(fieldType fType, String color, int price, String name){
        this.fType = fType;
        this.color = color;
        this.price = price;
        this.name = name;
        this.owner = null;
    }

    // Sets the owner, e.g when someone buys the field/property
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    // Getters for the variables and owner object reference
    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public fieldType getfType() { return fType; }
}