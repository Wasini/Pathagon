package model;

/**
 * Created by grazi on 13/06/17.
 */

/*Clase PathagonBoard
Representa un tablero de 7 filas por 7 columnas con un arreglo bidimensional de enteros.
Inicializado con 0's
 */


public class PathagonBoard {

    private final int ROWS = 7;
    private final int COLS = 7;

    private int totalPieces;

    private int[][] board;

    //Crea un tablero de 7 filas por 7 columnas
    public PathagonBoard() {
        this.board = new int[ROWS][COLS];
        totalPieces= 0;
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

    public int removePiece(int row,int col){
        int p = this.board[row][col];
        this.board[row][col] = 0;
        this.totalPieces--;
        return p;
    }

}
