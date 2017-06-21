package model;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


/*Clase PathagonBoard
Representa un tablero de 7 filas por 7 columnas con un arreglo bidimensional de tokens.
 */


public class PathagonBoard {

    public final int ROWS = 7;
    public final int COLS = 7;
    public final PathagonToken EMPTY_CELL = null;

    private int totalPieces;

    private PathagonToken[][] board;

    //Crea un tablero de 7 filas por 7 columnas
    public PathagonBoard() {
        this.board = new PathagonToken[ROWS][COLS];
        totalPieces= 0;
    }

    //Copy constructor
    public PathagonBoard(PathagonBoard another) {
        this.board = new PathagonToken[ROWS][];
        for (int i = 0; i< ROWS;i++) {
            PathagonToken[] aRow = another.getBoard()[i].clone();
            this.board[i] = new PathagonToken[COLS];
            System.arraycopy(aRow, 0, this.board[i], 0, COLS);
        }
        this.totalPieces = another.getTotalTokens();
    }

    //
    public PathagonToken[][] getBoard() {return this.board;}

    public void addToken(int p, int row, int col){
        this.board[row][col] = new PathagonToken(p,row,col);
        this.totalPieces++;
    }
    public void addToken(PathagonToken mv){
        this.board[mv.row][mv.col] = mv;
        this.totalPieces++;
    }

    public PathagonToken getToken(int row, int col){
        if (row < ROWS && row >= 0 && col < COLS && col >=0)
            return this.board[row][col];
        return null;
    }

    public int getTotalTokens() {
        return totalPieces;
    }


    public PathagonToken removeToken(int row, int col){
        if (row < ROWS && row >= 0 && col < COLS && col >=0){
            PathagonToken p = this.board[row][col];
            if (p != EMPTY_CELL) {
                this.board[row][col] = EMPTY_CELL;
                this.totalPieces--;
                return p;
            }
        }
        return null;
    }

    /**
     *
     * @param mv
     * @return
     */
    public PathagonToken removeToken(PathagonToken mv){
        PathagonToken tk = this.board[mv.row][mv.col];
        if (tk != EMPTY_CELL) {
            this.board[mv.row][mv.col] = EMPTY_CELL;
            this.totalPieces--;
            return tk;
        }
        return null;
    }

    public List<PathagonToken> getAdyacents (PathagonToken mv) {

        return this.getAdyacents(mv,1,(tk -> true));

    }

    public List<PathagonToken> getAdyacents(PathagonToken mv,Predicate<PathagonToken> p) {
        return this.getAdyacents(mv,1,p);

    };

    public List<PathagonToken> getAdyacents (PathagonToken mv,int offset,Predicate<PathagonToken> p) {


        List<PathagonToken> neighbours = new LinkedList<>();

        neighbours.add(this.getToken(mv.row+offset,mv.col));
        neighbours.add(this.getToken(mv.row-offset,mv.col));
        neighbours.add(this.getToken(mv.row,mv.col+offset));
        neighbours.add(this.getToken(mv.row,mv.col-offset));

        neighbours.removeIf(tk -> !(tk != null && p.test(tk)));

        return neighbours;

    }

    @Override
    public String toString() {
        return "PathagonBoard{" +
                "board=" + Arrays.toString(board) +
                '}';
    }

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


}
