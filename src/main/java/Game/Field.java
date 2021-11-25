package Game;

public class Field {

    public enum fieldType {
        PROPERTY, GOJAIL, JAIL, CHANCE, FREEPARKING, START
    }

    private fieldType fType;
    private String color;
    private int price;
    private Player owner;
    private String name;
    private int pairProperty;

    private int[] fieldPosition;

    public Field(fieldType fType, String color, int price, String name, int pairProperty) {
        this.fType = fType;
        this.color = color;
        this.price = price;
        this.name = name;
        this.owner = null;
        this.pairProperty = pairProperty;
    }

    public int getPairProperty() {
        return pairProperty;
    }

    public void setFieldPosition(int x, int y) {
        fieldPosition = new int[]{x, y};
    }

    public int[] getFieldPosition() {
        return fieldPosition;
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

    public fieldType getfType() {
        return fType;
    }

    public String toString() {
        return this.name + " " + this.price;

    }
}