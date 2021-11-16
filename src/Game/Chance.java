package Game;

public class Chance {
    private String name;
    private int id;
    private String text;

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
