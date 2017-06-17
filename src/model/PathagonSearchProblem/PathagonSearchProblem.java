package model.PathagonSearchProblem;

import framework.AdversarySearchProblem;
import model.PathagonBoard;
import model.PathagonToken;

import java.util.LinkedList;
import java.util.List;
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

    @Override
    public boolean end(PathagonState state) {
        return false;
    }

    @Override
    public int value(PathagonState state) {
        return 0;
    }

    @Override
    public int minValue() {
        return 0;
    }

    @Override
    public int maxValue() {
        return 0;
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
     * Pre: El movimiento es valido y @st no es un estado final
     * Post: El estado
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
