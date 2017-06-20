package model;

/**
 * Created by grazi on 13/06/17.
 */

import java.util.Comparator;

/**
 * Clase que representa una ficha negra o blanca de pathagon en una posicion del tablero
 */
public class PathagonToken {
    public int row;
    public int col;
    public int player;
    public boolean isNull;

    public PathagonToken(int player, int row, int col) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.isNull = false;
    }

    //NullMove contructor usado para representar un movimiento que no hace nada
    public PathagonToken(int player) {
        this.player = player;
        this.isNull = true;
    }


    /**
     * Compara esta ficha con otra y evalua si esta en una casilla adyacente sin considerar las diagonales
     * calculando la distancia entre sus posiciones
     * @param other la otra ficha de pathagon a comparar
     * @return true si se encuentra en una posicion adyacente horizontal o vertical respecto a esta ficha
     */
    public boolean isAdyacent(PathagonToken other) {
        if(this.isNull() || other.isNull())
            return false;
        return (Math.sqrt(Math.pow((this.col-other.col), 2) + Math.pow((this.row-other.row), 2)) == 1);
    }


    private boolean colAdyacent(PathagonToken other) {
        if (this.col != other.col){
            return false;
        }
        return (Math.abs(this.row-other.row) == 1);
    }

    private boolean rowAdyacent(PathagonToken other) {
        if (this.row != other.row){
            return false;
        }
        return (Math.abs(this.col-other.col) == 1);
    }


    @Override
    public String toString() {
        return "Movimiento{" +
                "row=" + row +
                ", col=" + col +
                ", player=" + player +
                '}';
    }


    public boolean isNull() {
        return this.isNull;
    }

    //
    public boolean overlaps(PathagonToken other) {
        if (other == null || this.isNull()) {
            return false;
        } else {
            return (this.row == other.row && this.col == other.col);
        }
    }

    public boolean belongsTo(int player) {
        return (this.player > 0 == player > 0);
    }

    public boolean isTrapedBy(PathagonToken fst, PathagonToken snd) {
        if (this.player == fst.player || this.player == snd.player)
            return false;
        return ((this.rowAdyacent(fst)&&this.rowAdyacent(snd)) || (this.colAdyacent(fst)&&this.colAdyacent(snd)));
    }



    
}
