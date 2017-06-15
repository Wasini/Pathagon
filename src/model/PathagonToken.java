package model;

/**
 * Created by grazi on 13/06/17.
 */

/**
 * Clase que representa una ficha negra o blanca de pathagon en una posicion del tablero
 */
public class PathagonToken {
    public int row;
    public int col;
    public int player;

    public PathagonToken(int player, int row, int col) {
        this.row = row;
        this.col = col;
        this.player = player;
    }


    /**
     * Compara esta ficha con otra y evalua si esta en una casilla adyacente sin considerar las diagonales
     * @param other la otra ficha de pathagon a comparar
     * @return true si se encuentra en una posicion adyacente horizontal o vertical respecto a esta ficha
     */
    public boolean isAdyacent(PathagonToken other) {
        boolean sameRowOrColumn = this.row == other.row || this.col == other.col;
        if (sameRowOrColumn) {
            return (Math.abs(this.row - other.row) == 1 || Math.abs(this.col - other.col) == 1);

        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "row=" + row +
                ", col=" + col +
                ", player=" + player +
                '}';
    }
    
}
