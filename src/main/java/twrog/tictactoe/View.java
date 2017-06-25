package twrog.tictactoe;

import java.util.Scanner;

/**
 *
 * @author Travis Rogers
 */

public class View {
    public void displayBoard(String[][] board) {
        displayHeader("Board");
        for (int i = 0; i < board.length; i++) {
            System.out.print("  ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public int getPlayerChoice(int boardSize) {
        return readInt("Enter a number to pick your space (cells are numbered from left to right, top to bottom, starting at number 1).", 1, boardSize * boardSize);
    }
    public int chooseBoardSize() {
        return readInt("What size board would you like to play on? Please enter a whole number between 3 and 100.", 3, 100);
    }
    
    public void displayHeader(String message) {
        System.out.println("\n===" + message.toUpperCase() + "===");
    }
    public void displayMessage(String message) {
        System.out.println("\n" + message);
    }
    private int readInt(String message, int min, int max) {
        Scanner in = new Scanner(System.in);
        boolean isValid;
        int num = 0;
        do {
            isValid = true;
            displayMessage(message);
            String str = in.nextLine();
            try {
                num = Integer.parseInt(str.trim());
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: input not a valid integer.");
                isValid = false;
            }
            if (isValid == true && (num < min || num > max)) {
                System.out.println("\nERROR: input is less than " + min + " or greater than " + max + ".");
                isValid = false;
            }
        } while (isValid == false);
        return num;
    }
}
