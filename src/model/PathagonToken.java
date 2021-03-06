package model;

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

    public PathagonToken(PathagonToken tk1) {
        if (!tk1.isNull()){
            this.row = tk1.row;
            this.col = tk1.col;
            this.isNull = false;
        } else
            this.isNull = true;
        this.player = tk1.player;
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


    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof PathagonToken)) {
            return false;
        }

        PathagonToken c = (PathagonToken) o;

        if (this.isNull()) {
            return c.isNull() && this.player == c.player;
        } else {
            return (this.col == c.col && this.row == c.row && this.player == c.player);
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
