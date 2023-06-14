package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by vfarcic on 19/03/15.
 */

enum Piece {
    X, Y
}

public class TicTacToe {

    private final int SIZE = 3;
    private Piece[][] board;

    private Piece lastPlayed;

    public TicTacToe() {
        this.lastPlayed = null;
        this.board = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                this.board[i][j] = null;

    }

    public void play(int x, int y, Piece piece) {
        if (x >= SIZE || x < 0 || y >= SIZE || y < 0)
            throw new RuntimeException("Piece placed outside board.");

        if (this.board[x][y] != null)
            throw new RuntimeException("Piece placed in occupied field.");

        if (lastPlayed == null && piece == Piece.Y)
            throw new RuntimeException("X must start");

        if (lastPlayed == piece)
            throw new RuntimeException("It's not your turn.");

        this.board[x][y] = piece;
        this.lastPlayed = piece;
    }


}
