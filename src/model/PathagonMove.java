package model;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonMove {
    private int row;
    private int col;
    private int player;

    public PathagonMove(int player,int row, int col) {
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }


    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "row=" + row +
                ", col=" + col +
                ", player=" + player +
                '}';
    }


    //Aplicar el movimiento en el estado st
    //TODO
    public void apply(PathagonState st) {

    }
}
