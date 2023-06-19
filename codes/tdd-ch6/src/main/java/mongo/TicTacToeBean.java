package mongo;

import main.Piece;
import org.jongo.marshall.jackson.oid.Id;

import java.util.Objects;

//--8<-- [start:setup]
public class TicTacToeBean {
    @Id
    private final int turn;

    public int getTurn() {
        return turn;
    }

    private final int x;

    public int getX() {
        return x;
    }

    private final int y;

    public int getY() {
        return y;
    }

    private final Piece piece;

    public Piece getPiece() {
        return piece;
    }

    public TicTacToeBean(int turn, int x, int y, Piece piece) {
        this.turn = turn;
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToeBean that = (TicTacToeBean) o;
        return turn == that.turn && x == that.x && y == that.y && piece == that.piece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(turn, x, y, piece);
    }

    @Override
    public String toString() {
        return "TicTacToeBean{" + "turn=" + turn + ", x=" + x + ", y=" + y + ", piece=" + piece + '}';
    }
}
//--8<-- [end:setup]

