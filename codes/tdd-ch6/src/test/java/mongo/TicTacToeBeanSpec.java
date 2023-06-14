package mongo;


import main.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeBeanSpec {
    private TicTacToeBean bean;
    private final int turn = 50;
    private final int x = 2;
    private final int y = 1;
    private final Piece piece = Piece.X;

    @Before
    public void before() {
        bean = new TicTacToeBean(turn, x, y, piece);
    }

    @Test
    public void testGetTurn() {
        assertEquals(turn, bean.getTurn());
    }

    @Test
    public void testGetX() {
        assertEquals(x, bean.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(y, bean.getY());
    }

    @Test
    public void testGetPiece() {
        assertEquals(piece, bean.getPiece());
    }

}
