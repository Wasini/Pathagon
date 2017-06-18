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

    public PathagonSearchProblem(PathagonState initial) {
        this.initial = initial;
    }

    public PathagonSearchProblem() {
        this.initial = new PathagonState();
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
        if (state.playerTokensLeft(state.PLAYER1) == 0 && state.playerTokensLeft(state.PLAYER2) == 0)
            return true;
        if (computeMaxPathExtension(state,state.PLAYER1) == state.BOARDSIZE || computeMaxPathExtension(state,state.PLAYER2) == state.BOARDSIZE)
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

        int p1MaxPath = computeMaxPathExtension(state,state.PLAYER1);
        int p2MaxPath = computeMaxPathExtension(state,state.PLAYER2);

        if (p1MaxPath == state.BOARDSIZE)
            return minValue();
        if (p2MaxPath == state.BOARDSIZE)
            return maxValue();

        return (p2MaxPath * 6 + p1MaxPath * 6 + state.playerTokensLeft(state.PLAYER2) - state.playerTokensLeft(state.PLAYER1));




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
       if (st.playerTokensLeft(playerMoving)<=0)
           return false;
       if (!st.positionIsAvaible(mv.row,mv.col))
           return false;
       return true;
    }


    /**
     * Calcula cuanto se extiende el camino mas largo considerando las filas
     * o columnas de acuerdo al jugador dado
     * Jugador 2 -> columnas
     * Jugador 1 -> filas
     * @param st Estado del juego
     * @param player jugador
     * @return entero que representa la cantidad de casillas ocupadas horizontal o verticalmente por el camino mas largo del jugador dado
     */
    private static int computeMaxPathExtension(PathagonState st,int player) {
        List<PathagonToken> pTokens = new LinkedList<>(st.getPlayerTokens(player));

        PathagonBoard board = st.getBoard();
        int maxExtension = 0;

        while(!pTokens.isEmpty()) {

            PathagonToken curr = pTokens.remove(0);
            PathagonPath currPath = generatePath(board,curr);
            maxExtension = Math.max(maxExtension,currPath.extension());

            if (maxExtension == st.BOARDSIZE)
                return maxExtension;

            pTokens.removeAll(currPath);
        }
        return maxExtension;
    }


    /**
     * Dada una ficha y un tablero se genera el camino que contiene todas las fichas
     * en las que se pueden conectar con @fistToken
     * @param board tablero del juego
     * @param firstToken ficha generadora del camino
     * @return PathagonPath que representa el conjunto de fichas que estan conectadas con firstToken
     */
    private static PathagonPath generatePath(PathagonBoard board,PathagonToken firstToken) {

        PathagonPath pathOfCurrent = new PathagonPath(firstToken.player);
        pathOfCurrent.add(firstToken);

        List<PathagonToken> adjs = board.getAdyacents(firstToken, adj -> firstToken.player == adj.player);
        while (!adjs.isEmpty()) {
            PathagonToken curr2 = adjs.remove(0);
            pathOfCurrent.add(curr2);
            board.getAdyacents(firstToken, adj -> firstToken.player == adj.player).stream()
                    .filter(tk -> !pathOfCurrent.contains(tk) && !adjs.contains(tk))
                    .collect(Collectors.toCollection(() -> adjs));
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
