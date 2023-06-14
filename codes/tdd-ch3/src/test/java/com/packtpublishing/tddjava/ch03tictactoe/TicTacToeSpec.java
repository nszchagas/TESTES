package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe board;
    private Piece x = Piece.X;
    private Piece o = Piece.Y;

    @Before
    public final void before() {
        board = new TicTacToe();
    }

    @Test
    public void whenPiecePlacedOutsideXAxisThrowRuntimeException() {
        exception.expect(RuntimeException.class);
        board.play(4, 2, x);
    }

    @Test
    public void whenPiecePlacedInNegativeXExpectRuntimeError() {
        exception.expect(RuntimeException.class);
        board.play(-1, 2, x);
    }

    @Test
    public void whenPiecePlacedInNegativeYExpectRuntimeError() {
        exception.expect(RuntimeException.class);
        board.play(1, -2, x);
    }

    @Test
    public void whenPiecePlacedOutsideYaxisThrowRuntimeException() {
        exception.expect(RuntimeException.class);
        board.play(2, 5, o);
    }

    @Test
    public void whenPiecePlacedInOccupiedFieldExpectRuntimeException() {
        board.play(1, 1, x);
        exception.expect(RuntimeException.class);
        board.play(1, 1, o);
    }


    @Test
    public void whenXTriesToPlayTwiceExpectRuntimeException() {
        board.play(1, 1, x);
        exception.expect(RuntimeException.class);
        board.play(0, 0, x);
    }

    @Test
    public void whenOTriesToPlayTwiceExpectRuntimeException() {
        board.play(1, 2, x);
        board.play(0, 2, o);
        exception.expect(RuntimeException.class);
        board.play(2, 0, o);
    }

    @Test
    public void whenOTriesToStartExpectRuntimeException() {
        exception.expect(RuntimeException.class);
        board.play(0, 0, o);
    }
}
