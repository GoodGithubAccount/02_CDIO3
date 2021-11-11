package Game;

public class Field {

    public enum fieldType{
        PROPERTY, GOJAIL, JAIL, CHANCE, FREEPARKING, START
    }

    fieldType fType;
    String color;
    int price;
    Player owner;
    String name;

    public Field(fieldType fType, String color, int price, String name){
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