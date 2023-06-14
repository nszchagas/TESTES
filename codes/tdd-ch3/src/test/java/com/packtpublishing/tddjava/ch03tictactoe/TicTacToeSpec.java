package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TicTacToeSpec {

 //--8<-- [start:req1]
    
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe board;

    @Before
    public final void before() {
        board = new TicTacToe();
    }

    @Test
    public void whenPiecePlacedOutsideXAxisThrowRuntimeException() {
        exception.expect(RuntimeException.class);
        board.play(4, 2);
    }

    @Test
    public void whenPiecePlacedInNegativeXExpectRuntimeError() {
        exception.expect(RuntimeException.class);
        board.play(-1, 2);
    }

    @Test
    public void whenPiecePlacedInNegativeYExpectRuntimeError() {
        exception.expect(RuntimeException.class);
        board.play(1, -2);
    }

    @Test
    public void whenPiecePlacedOutsideYaxisThrowRuntimeException() {
        exception.expect(RuntimeException.class);
        board.play(2, 5);
    }

    @Test
    public void whenPiecePlacedInOccupiedFieldExpectRuntimeException() {
        board.play(1, 1);
        exception.expect(RuntimeException.class);
        board.play(1, 1);
    }
//--8<-- [end:req1]
//--8<-- [start:req2]


    @Test
    public void getNextPlayerAtStartShouldReturnX() {
        assertEquals(Piece.X, board.getNextPlayer());
    }

    @Test
    public void getNextPlayerAfterXShouldReturnO() {
        board.play(0, 0);
        assertEquals(Piece.O, board.getNextPlayer());
    }

    @Test
    public void getNextPlayerAfterOShouldReturnX() {
        board.play(0, 0);
        board.play(0, 1);
        assertEquals(Piece.X, board.getNextPlayer());
    }

    //--8<-- [end:req2]

    //--8<-- [start:req3]
    
    
    @Test
    public void assertWinnerForHorizontalLine() {
        board.play(0, 0); // X
        board.play(1, 2); // O
        board.play(0, 1); // X
        board.play(1, 1); // O
        board.play(0, 2); // X
        board.play(2, 1); // O
        assertEquals(Result.X_WIN, board.getWinner());
    }

    @Test
    public void assertWinnerForVerticalLine() {
        board.play(1, 0);
        board.play(0, 0);
        board.play(1, 2);
        board.play(0, 1);
        board.play(1, 1);
        board.play(0, 2);
        assertEquals(Result.O_WIN, board.getWinner());
    }

    @Test
    public void assertWinnerForPrincipalDiagonal() {
        board.play(0, 0);
        board.play(0, 1);
        board.play(1, 1);
        board.play(0, 2);
        board.play(2, 2);
        board.play(1, 0);
        assertEquals(Result.X_WIN, board.getWinner());
    }

    @Test
    public void assertWinnerForSecondaryDiagonal() {
        board.play(2, 0); // X
        board.play(0, 0);
        board.play(1, 1); // X
        board.play(0, 1);
        board.play(0, 2); // X
        board.play(1, 0);
        assertEquals(Result.X_WIN, board.getWinner());
    }
//--8<-- [end:req3]

//--8<-- [start:req4]


    @Test
    public void assertDrawBoardFilled() {
        board.play(0, 0);
        board.play(1, 1);
        board.play(2, 2);
        board.play(2, 1);
        board.play(0, 1);
        board.play(0, 2);
        board.play(2, 0);
        board.play(1, 0);
        board.play(1, 2);


        assertEquals(Result.DRAW, board.getWinner());
    }

    @Test
    public void assertWithoutResultBeforeFillingBoard() {
        board.play(0, 0);
        assertNull(board.getWinner());
    }
    //--8<-- [end:req4]

}
