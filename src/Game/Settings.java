package Game;

public final class Settings {

    // Makes instantiating a class of this impossible
    private Settings() {
    }

    // Game.Settings file that contains all settings for the game, making changing things easy and simple

    // Text Database(s)
    public static final String FIELD_DATABASE = "fieldDatabase.txt";

    // Game.Board
    public static final int BOARD_SIZE = 24;

    // Game GUI window size in pixels
    public static final int WINDOW_HEIGHT = 900;
    public static final int WINDOW_WIDTH = 1600;

    // Players
    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 2;

    // Game Rules
    public static final int STARTING_MONEY = 35;
    public static final int GO_SPOT_MONEY = 2;
    public static final int PAY_SPOT_MONEY = -2;
    public static final int GO_RESTROOM_MONEY = -3;

    // Game.Die
    public static final int DIE_NUMBER = 2;
    public static final int DIE_FACES = 6;

}
