package model;


import java.util.*;

/**
 * Representa un conjunto de fichas ordenadas por fila/columna de acuerdo al jugador
 * dado que cumple que para cada par de fichas del conjunto existe un subconjunto de ellas que las conecta
 *
 * El atributo extension devuelve el largo del camino considerando fila o columna segun le interese al jugador
 */
public class PathagonPath extends TreeSet<PathagonToken> {


    private int PLAYER; //Jugador dueño del camino
    private Comparator<PathagonToken> extensionComparator; //Compara por fila o por columna de acuerdo al jugador

    public PathagonPath(int player) {
        super(buildComparator(player));
        this.extensionComparator = player > 0 ? (o1, o2) -> o1.col - o2.col : (o1, o2) -> o1.row - o2.row;
        this.PLAYER = player;
    }



    public PathagonPath(PathagonPath p) {
        super(p.comparator());
        this.PLAYER = p.PLAYER();
        this.extensionComparator = p.extensionComparator();
        for (PathagonToken tk: p
             ) {
            this.add(tk);
        }
    }

    public PathagonPath(SortedSet<PathagonToken> s, int player) {
        super(s);
        this.extensionComparator = player > 0 ? (o1, o2) -> o1.col - o2.col : (o1, o2) -> o1.row - o2.row;
        this.PLAYER = player;
    }


    public int PLAYER() {
        return PLAYER;
    }

    /**
     * Calcula cuanto se extiende el camino en el tablero en filas o columnas de acuerdo a lo que le interese
     * al jugador
     * @return Entero que representa cantidad de casilleros que ocupa el camino en filas o columnas respectivamente
     */
    public int extension() {
        return (this.PLAYER > 0 ? this.last().col - this.first().col : this.last().row - this.first().row) + 1;
    }



    public Comparator<PathagonToken> extensionComparator(){
        return this.extensionComparator;
    }



    /**
     * Retorna el elemento del conjunto que por lo menos es mas grande o igual al elemento dado, o null si no existe el elemento;
     * La ficha es comparada por columna o fila de acuerdo al jugador correspondiente
     */
    @Override
    public PathagonToken ceiling(PathagonToken e){

        return this.stream()
                .filter(tk -> this.extensionComparator.compare(tk,e)>= 0)
                .findFirst()
                .orElse(null);
    }

    /**
     * Construye el comparador de fichas para ordenar el conjunto, de acuerdo
     * al jugador dado las fichas se ordenan por fila->columna o columna->fila
     *
     * @param player jugador al que le pertenecen las fichas del camino
     * @return comparador de PathagonToken comparando las fila y columnas de la ficha
     */
    private static Comparator<PathagonToken> buildComparator(int player) {

        if (player > 0){
            return (o1, o2) -> {
                int cmp = o1.col - o2.col;
                if (cmp == 0)
                    cmp = o1.row - o2.row;
                return cmp;
            };
        } else {
            return (o1, o2) -> {
                int cmp = o1.row - o2.row;
                if (cmp == 0)
                    cmp = o1.col - o2.col;
                return cmp;
            };

        }
    }

    @Override
    public boolean add(PathagonToken tk){
        validateVertex(tk);
        return super.add(tk);
    }


    /**
     * Valida que la nueva ficha a agregar sea adyacente a alguna de las que ya estan en el camino
     * y verifica que la ficha sea del mismo color
     * @param v ficha a agregar al camino
     */
    private void validateVertex(PathagonToken v){
        if (this.first().player != v.player) {
            throw new IllegalArgumentException("La ficha no es del mismo color "+v.toString());
        }
        if (!this.stream().anyMatch(tk -> v.isAdyacent(tk)))
            throw new IllegalArgumentException("La ficha no pertence al camino "+v.toString());
    }




    public List<PathagonToken> pathHead(){
        return new LinkedList<>(this.headSet(this.first(),true));
    }

    public List<PathagonToken> pathEnd(){
        return new LinkedList<>(this.tailSet(this.last(),true));
    }
}
