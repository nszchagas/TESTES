package com.packtpublishing.tddjava.ch03tictactoe;

//--8<-- [start:setup]

enum Piece {
    X, O
}

enum Result {
    DRAW, X_WIN, O_WIN
}

public class TicTacToe {

    private final int SIZE = 3;
    private final Piece[][] board;
    private int filledSpaces = 0;

    private Piece lastPlayed;


    public TicTacToe() {
        this.lastPlayed = null;
        this.board = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                this.board[i][j] = null;

    }

    //--8<-- [end:setup]
//--8<-- [start:req1]
    public void play(int x, int y) {
        checkCoordinate(x);
        checkCoordinate(y);

        checkField(x, y);

        Piece piece = getNextPlayer();
        this.board[x][y] = piece;
        this.lastPlayed = piece;
        this.filledSpaces++;
    }


    private void checkCoordinate(int value) {
        if (value < 0 || value >= SIZE) throw new RuntimeException("Value out of boundaries.");
    }

    private void checkField(int x, int y) {
        if (this.board[x][y] != null)
            throw new RuntimeException(String.format("Piece placed in occupied field (%d, %d).", x, y));
    }

    //--8<-- [end:req1]
    //--8<-- [start:req3]
    public Result getWinner() {

        Piece winner;

        for (int row = 0; row < SIZE; row++)
            if (this.board[row][0] == this.board[row][1] && this.board[row][1] == this.board[row][2]) {
                winner = this.board[row][0];
                if (winner != null) {
                    return mapPieceToResult(winner);
                }
            }

        for (int col = 0; col < SIZE; col++)
            if (this.board[0][col] == this.board[1][col] && this.board[1][col] == this.board[2][col]) {
                winner = this.board[0][col];
                if (winner != null) {
                    return mapPieceToResult(winner);
                }
            }

        if (this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) {
            winner = this.board[0][0];
            if (winner != null) {
                return mapPieceToResult(winner);
            }
        }

        if (this.board[2][0] == this.board[1][1] && this.board[1][1] == this.board[0][2]) {
            winner = this.board[2][0];
            if (winner != null) {
                return mapPieceToResult(winner);
            }
        }

        if (this.filledSpaces != SIZE * SIZE)
            return null;

        return Result.DRAW;
    }

    private Result mapPieceToResult(Piece p) {
        if (p == null) return Result.DRAW;
        return p == Piece.X ? Result.X_WIN : Result.O_WIN;
    }
//--8<-- [end:req3]
//--8<-- [start:req2]

    public Piece getNextPlayer() {
        if (this.lastPlayed == null) return Piece.X;
        switch (this.lastPlayed) {
            case X:
                return Piece.O;
            case O:
                return Piece.X;
            default:
                return null;
        }
    }
//--8<-- [end:req2]


}
