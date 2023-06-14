package mongo;

import main.Piece;
import org.jongo.marshall.jackson.oid.Id;

import java.util.Objects;


public class TicTacToeBean {
    @Id
    private int turn;

    private int x;

    private int y;

    private Piece piece;


    public int getTurn() {
        return turn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
        return "TicTacToeBean{" +
                "turn=" + turn +
                ", x=" + x +
                ", y=" + y +
                ", piece=" + piece +
                '}';
    }
}

