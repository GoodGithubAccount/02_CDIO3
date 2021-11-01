public class Board {

    String fieldDatabase;
    int boardSize;

    Board(String fieldDatabase, int boardSize){
        this.fieldDatabase = fieldDatabase;
        this.boardSize = boardSize;
    }

    private void loadFromTXT(){

    }

    private void generateBoard(){

    }
}

class Field {

    public enum fieldType{
        PROPERTY, GOJAIL, JAIL, CHANCE, FREEPARKING, START
    }

    fieldType fType;
    int[] colorRGB = new int[3];
    int price;
    Player owner;
    String name;

    Field(fieldType fType, int[] colorRGB, int price, String name){
        this.fType = fType;
        this.colorRGB = colorRGB;
        this.price = price;
        this.name = name;
        this.owner = null;
    }

    // Sets the owner, e.g when someone buys the field/property
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    // Getters for the variables and owner object reference
    public int[] getColorRGB() {
        return colorRGB;
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
}