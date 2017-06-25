package twrog.tictactoe;

/**
 *
 * @author Travis Rogers
 */

public class GameEngine {
    public int boardSize = 3;
    private String[][] gameBoard;
    
    public String[][] updateBoard(int playerChoice, String XorO) throws Exception {
        int row = (playerChoice - 1) / gameBoard.length;
        int column = playerChoice - (gameBoard.length * row + 1);
        if (!gameBoard[row][column].equals("-")) {
            throw new Exception("ERROR: space is already occupied.");
        } else {
            gameBoard[row][column] = XorO;
        }
        return gameBoard;
    }
    public boolean gameIsWon(String[][] board) {
        int dimension = board.length;
        boolean rowWin;
        boolean colWin;
        boolean diagWin1;
        boolean diagWin2;
        for (int i = 0; i < dimension; i++) {
            rowWin = true;
            colWin = true;
            for (int j = 0; j < dimension - 1 && (rowWin == true ||  colWin == true); j++) {
                if (board[i][j].equals("-")) {
                    rowWin = false;
                } else if (!board[i][j].equalsIgnoreCase(board[i][j + 1])) {
                    rowWin = false;
                }
                if (board[j][i].equals("-")) {
                    colWin = false;
                } else if (!board[j][i].equalsIgnoreCase(board[j + 1][i])) {
                    colWin = false;
                }
            }
            if (rowWin == true || colWin == true) {
                return true;
            }
        }
        diagWin1 = true;
        diagWin2 = true;
        for (int i = 0; i < dimension - 1 && (diagWin1 == true || diagWin2 == true); i++) {
            if (board[i][i].equals("-")) {
                diagWin1 = false;
            } else if (!board[i][i].equalsIgnoreCase(board[i+1][i+1])) {
                diagWin1 = false;
            }
            if (board[i][dimension - (i + 1)].equals("-")) {
                diagWin2 = false;
            } else if (!board[i][dimension - (i + 1)].equalsIgnoreCase(board[i+1][dimension - (i + 2)])) {
                diagWin2 = false;
            }
        }
        if (diagWin1 == true || diagWin2 == true) {
            return true;
        }
        return false;
    }
    public String[][] createGameBoard() {
        gameBoard = new String[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                gameBoard[i][j] = "-";
            }
        }
        return gameBoard;
    }
    public void setBoardSize(int size) {
        boardSize = size;
    }
    public String[][] getGameBoard() {
        return gameBoard;
    }
}
