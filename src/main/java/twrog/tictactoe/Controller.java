package twrog.tictactoe;

/**
 *
 * @author Travis Rogers
 */

public class Controller {
    private View view;
    private GameEngine engine;
    public Controller(View view, GameEngine engine) {
        this.view = view;
        this.engine = engine;
    }
    
    public void execute() {
        view.displayHeader("Tic Tac Toe");
        engine.setBoardSize(view.chooseBoardSize());
        view.displayBoard(engine.createGameBoard());
        int turnRotator = 0;
        boolean keepPlaying = true;
        String XorO;
        while (keepPlaying) {
            if (turnRotator % 2 == 0) {
                view.displayHeader("Player 1");
                XorO = "X";
            } else {
                view.displayHeader("Player 2");
                XorO = "O";
            }
            boolean isValid;
            do {
                isValid = true;
                try {
                    view.displayBoard(engine.updateBoard(view.getPlayerChoice(engine.boardSize), XorO));
                } catch (Exception e) {
                    view.displayMessage(e.getMessage());
                    isValid = false;
                }
            } while (isValid == false);
            if (turnRotator % 2 == 0 && engine.gameIsWon(engine.getGameBoard())) {
                view.displayMessage("PLAYER 1 WINS!");
                keepPlaying = false;
            } else if (engine.gameIsWon(engine.getGameBoard())) {
                view.displayMessage("PLAYER 2 WINS!");
                keepPlaying = false;
            } else if (turnRotator == Math.pow(engine.boardSize, 2) - 1) {
                view.displayMessage("IT'S A TIE!");
                keepPlaying = false;
            }
            turnRotator++;
        }
    }
}
