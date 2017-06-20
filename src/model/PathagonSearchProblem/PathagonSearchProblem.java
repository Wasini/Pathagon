package model.PathagonSearchProblem;

import framework.AdversarySearchProblem;
import model.PathagonBoard;
import model.PathagonPath;
import model.PathagonToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonSearchProblem<P> implements AdversarySearchProblem<PathagonState> {

    protected PathagonState initial;
    private TreeSet<PathagonPath> p1Paths; //Caminos del jugador 1 ordenados por extension en forma decreciente
    private TreeSet<PathagonPath> p2Paths; //Caminos del jugador 2 ordenados por extension en forma decreciente

    public PathagonSearchProblem(PathagonState initial) {
        this.p1Paths = new TreeSet<PathagonPath>((p1,p2) -> p2.extension() - p1.extension());
        this.p2Paths = new TreeSet<PathagonPath>((p1,p2) -> p2.extension() - p1.extension());
        this.initial = initial;
    }

    public PathagonSearchProblem() {
        this.initial = new PathagonState();
        this.p1Paths = new TreeSet<PathagonPath>((p1,p2) -> p2.extension() - p1.extension());
        this.p2Paths = new TreeSet<PathagonPath>((p1,p2) -> p2.extension() - p1.extension());
    }

    @Override
    public PathagonState initialState() {
        return initial;
    }

    @Override
    public List<PathagonState> getSuccessors(PathagonState state) {
        List<PathagonToken> moves = getAvaibleMoves(state);
        List<PathagonState> childs = new LinkedList<>();
        for (PathagonToken mv : moves) {
            PathagonState child = new PathagonState(state);
            applyMove(child,mv);
            childs.add(child);
        }
        return childs;
    }

    /**
     *
     * @param state is the state being checked to be an end state.
     * @return
     */
    @Override
    public boolean end(PathagonState state) {
        if (state.getBoard().getTotalTokens() == 14)
            return true;
        this.computePaths(state);
        if (this.p1Paths.isEmpty() || this.p2Paths.isEmpty() )
            return false;
        if (this.p1Paths.first().extension() == state.BOARDSIZE || this.p2Paths.first().extension() == state.BOARDSIZE)
            return true;
        return false;
    }


    /**
     * Return an integer value for the current state, higher values
     * are better for Player2 (ia)
     * @param state is the state for which its value is being computed.
     * @return an integer representing the value of the state
     */
    @Override
    public int value(PathagonState state) {

        this.computePaths(state);
        int p1Extension = p1Paths.isEmpty() ? 0 : p1Paths.first().extension();
        int p2Extension = p2Paths.isEmpty() ? 0 : p2Paths.first().extension();

        int blockedPositionsValue = 0;
        if (state.hasBlockedMoves()) {
            blockedPositionsValue = state.getBlockedMoves().stream().mapToInt(tk -> tk.player).sum() * -1;
        }

        if (p1Extension == state.BOARDSIZE)
            return minValue();
        if (p2Extension == state.BOARDSIZE)
            return maxValue();

        return (p1Extension * 6 - p2Extension * 6 + blockedPositionsValue*2);




    }

    @Override
    public int minValue() {
        return Integer.MIN_VALUE;
    }

    @Override
    public int maxValue() {
        return Integer.MAX_VALUE;
    }

    /**Arma la lista de todos los posibles movimientos para el jugador actual
     *Si el jugador no puede colocar mas fichas retorna la lista con el movimiento nulo
     * @param st estado a observar los movimientos
     * @return Lista de PathagonToken que representa movimientos
     */
    public List<PathagonToken> getAvaibleMoves(PathagonState st){
        List<PathagonToken> moves = new LinkedList<>();
        PathagonBoard board = st.getBoard();
        int currentPlayer = st.getTurn();
        if (st.playerTokensLeft(currentPlayer) <= 0) {
            moves.add(new PathagonToken(currentPlayer));
            return moves;
        }

        for (int i = 0; i < board.ROWS; i++) {
            for (int j = 0; j < board.COLS; j++) {
                if(st.positionIsAvaible(i,j)){
                    PathagonToken newMove = new PathagonToken(currentPlayer,i,j);
                    moves.add(newMove);
                }
            }
        }
        return moves;
    }

    /**
     * Modifica el estado con el movimiento dado, si este es nulo solo cambia el turno
     * si el movimiento atrapa fichas del jugador contrario son quitadas del tablero
     * y se bloquea las posiciones correspondientes
     * En el estado se registra el movimiento realizado
     * Pre: El movimiento es valido y @st no es un estado final
     * Post: Estado resultado de haber aplicado el movimiento
     * @param st
     * @param mv
     * @return
     */
    public static boolean applyMove(PathagonState st, PathagonToken mv){

        if (mv.isNull()) {
            st.removeBlockedMoves();
            st.setLastMove(mv);
            st.changeTurn();
            return true;
        }

        List<PathagonToken> posibleEated = tokensEatedBy(st,mv);
        if(!posibleEated.isEmpty()) {
            for (PathagonToken eated: posibleEated
                 ) {
                st.eatToken(eated);
            }
        } else {
            st.removeBlockedMoves();
        }

        st.addMove(mv);
        st.changeTurn();

        return true;
    }


    /**
     * Retorna true si se puede realizar el movimiento en el estado
     * @param st Estado a verificar el movimiento
     * @param mv movimiento a realizar
     * @return booleano que dice si el movimiento es aplicable en el estado
     */

    public static boolean validMove(PathagonState st,PathagonToken mv)  {
       int playerMoving = mv.player;
       if (st.getTurn() != playerMoving)
           return false;
       if (mv.col >= st.BOARDSIZE || mv.col < 0 || mv.row < 0 || mv.row >= st.BOARDSIZE)
           return false;
       if (st.playerTokensLeft(playerMoving)<=0)
           return false;
       if (!st.positionIsAvaible(mv.row,mv.col))
           return false;
       return true;
    }



    /**
     * Agrera los caminos armados por las fichas del player1 en p1Paths y las del jugador 2 en p2Paths
     * @param st Estado del juego
     */
    private void computePaths(PathagonState st) {
        List<PathagonToken> tokens = new LinkedList<>(st.getPlayerTokens(st.PLAYER1));
        tokens.addAll(st.getPlayerTokens(st.PLAYER2));

        PathagonBoard board = st.getBoard();

        while(!tokens.isEmpty()) {

            PathagonToken curr = tokens.remove(0);
            PathagonPath currPath = generatePath(board,curr);
            if (curr.player == st.PLAYER1)
                this.p1Paths.add(currPath);
            else
                this.p2Paths.add(currPath);

            tokens.removeAll(currPath);
        }
    }


    /**
     * Dada una ficha y un tablero se genera el camino que contiene todas las fichas
     * en las que se pueden conectar con @fistToken
     * @param board tablero del juego
     * @param firstToken ficha generadora del camino
     * @return PathagonPath que representa el conjunto de fichas que estan conectadas con firstToken
     */
    public static PathagonPath generatePath(PathagonBoard board, PathagonToken firstToken) {

        PathagonPath pathOfCurrent = new PathagonPath(firstToken.player);
        pathOfCurrent.add(firstToken);

        List<PathagonToken> adjs = board.getAdyacents(firstToken, adj -> firstToken.player == adj.player);
        while (!adjs.isEmpty()) {
            PathagonToken curr2 = adjs.remove(0);
            if (!pathOfCurrent.contains(curr2))
                pathOfCurrent.add(curr2);

            List<PathagonToken> nuevos = new LinkedList<>(board.getAdyacents(curr2, adj -> firstToken.player == adj.player));
            for (PathagonToken n : nuevos) {
                if (!pathOfCurrent.contains(n)) {
                    adjs.add(n);
                }
            }
            //board.getAdyacents(firstToken, adj -> firstToken.player == adj.player).stream()
            //        .filter(tk -> !pathOfCurrent.contains(tk) && !adjs.contains(tk))
            //        .collect(Collectors.toCollection(() -> adjs));
        }

        return pathOfCurrent;
    }


    /**
     * Obtiene la lista de fichas comidas por el movimiento dado en el estado @st
     * Retorna la lista vacia si el movimiento no atrapa ninguna ficha
     * @param st estado del juego
     * @param trapMove movimiento
     * @return Lista de tokens comidos por el movimiento
     */
    public static List<PathagonToken> tokensEatedBy(PathagonState st,PathagonToken trapMove) {
        List<PathagonToken> eatables = new LinkedList<>();
        List<PathagonToken> playerAdyacentTokens = st.getBoard().getAdyacents(trapMove,2,(tk -> tk.player == trapMove.player));
        if (playerAdyacentTokens.isEmpty())
            return eatables;

        List<PathagonToken> posibleEatable = st.getBoard().getAdyacents(trapMove,(tk -> tk.player != trapMove.player));
        eatables = posibleEatable.stream()
                .filter(eatable -> playerAdyacentTokens.stream().
                        anyMatch(myOtherTk -> eatable.isTrapedBy(trapMove,myOtherTk))).collect(Collectors.toList());

        return eatables;
    }



}
