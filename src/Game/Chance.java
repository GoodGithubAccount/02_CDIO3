package Game;

public class Chance {
    private String name;
    private int id;
    private String text;

    // Navn-tekst-id-value-move-Type    Colors/space id: orange=0, green=1, lightblue=2, pink=3, blue=4, red=5, brown=6, yellow=7, start=8, Pier=9, Skatepark=10

    public Chance(String name, int id, String text) {
        this.name = name;
        this.id = id;
        this.text=text;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chance{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }
}
