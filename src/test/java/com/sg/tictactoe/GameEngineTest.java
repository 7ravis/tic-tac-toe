/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.sg.tictactoe;

import twrog.tictactoe.GameEngine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Inspiron15-7000
 */
public class GameEngineTest {
    private GameEngine engine = new GameEngine();
    String[][] board;
    
    public GameEngineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "-";
            }
        }
    }
    
    @After
    public void tearDown() {
        board = null;
    }
    
    /**
     * Test of gameIsWon method, of class GameEngine.
     */
    @Test
    public void testCheckForWinnerColumnTrue() {
        board[0][2] = "X";
        board[1][2] = "X";
        board[2][2] = "X";
        assertTrue(engine.gameIsWon(board));
    }
    @Test
    public void testCheckForWinnerColumnFalse() {
        board[0][2] = "X";
        board[2][2] = "X";
        assertFalse(engine.gameIsWon(board));
    }
    @Test
    public void testCheckForWinnerRowTrue() {
        board[1][0] = "X";
        board[1][1] = "X";
        board[1][2] = "X";
        assertTrue(engine.gameIsWon(board));
    }
    @Test
    public void testCheckForWinnerRowFalse() {
        board[1][0] = "X";
        board[1][2] = "X";
        assertFalse(engine.gameIsWon(board));
    }
    @Test
    public void testCheckForWinnerDiagonalTrue() {
        board[0][2] = "X";
        board[1][1] = "X";
        board[2][0] = "X";
        assertTrue(engine.gameIsWon(board));
    }
    @Test
    public void testCheckForWinnerDiagonalFalse() {
        board[1][1] = "X";
        board[2][0] = "X";
        assertFalse(engine.gameIsWon(board));
    }
}
