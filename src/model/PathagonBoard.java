package model;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Arrays;

/**
 * Created by grazi on 13/06/17.
 */

/*Clase PathagonBoard
Representa un tablero de 7 filas por 7 columnas con un arreglo bidimensional de enteros.
Inicializado con 0's
 */


public class PathagonBoard {

    public final int ROWS = 7;
    public final int COLS = 7;
    public final int emptyCell = 0;

    private int totalPieces;

    private int[][] board;

    //Crea un tablero de 7 filas por 7 columnas
    public PathagonBoard() {
        this.board = new int[ROWS][COLS];
        totalPieces= 0;
    }

    //Copy constructor
    public PathagonBoard(PathagonBoard another) {
        this.board = new int[ROWS][];
        for (int i = 0; i< ROWS;i++) {
            int[] aRow = another.getBoard()[i];
            this.board[i] = new int[COLS];
            System.arraycopy(aRow, 0, this.board[i], 0, COLS);
        }
        this.totalPieces = another.getTotalPieces();
    }

    //Get PathagonBoard como arreglo bidimensional de enteros
    public int[][] getBoard() {return this.board;}

    public void putPiece(int p,int row, int col){
        this.board[row][col] = p;
        this.totalPieces++;
    }

    public int getPiece(int row, int col){
        return this.board[row][col];
    }

    public int getTotalPieces() {
        return totalPieces;
    }

    public int removePiece(int row, int col){
        int p = this.board[row][col];
        this.board[row][col] = 0;
        this.totalPieces--;
        return p;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!PathagonBoard.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final PathagonBoard other = (PathagonBoard) obj;
        return Arrays.deepEquals(this.board,other.getBoard());
    }

    public boolean freePosition(int row,int col) {
        return this.board[row][col] == emptyCell;
    }

}
