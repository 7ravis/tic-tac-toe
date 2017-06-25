package twrog.tictactoe;

/**
 *
 * @author Travis Rogers
 */

public class App {
    public static void main(String[] args) {
        Controller game = new Controller(new View(), new GameEngine());
        game.execute();
    }
}
