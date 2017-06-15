package model.PathagonSearchProblem;

import framework.AdversarySearchProblem;
import model.InvalidMoveException;
import model.PathagonBoard;
import model.PathagonToken;

import java.util.LinkedList;
import java.util.List;

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

    //Retorna una lista con todos los posibles movimientos para el jugador del turno
    public List<PathagonToken> getAvaibleMoves(PathagonState st){
        List<PathagonToken> moves = new LinkedList<>();
        PathagonBoard board = st.getBoard();
        for (int i = 0; i < board.ROWS; i++) {
            for (int j = 0; j < board.COLS; j++) {
                if(st.getBlockedMove().col != j || st.getBlockedMove().row!=i) {
                    moves.add(new PathagonToken(st.getTurn(),i,j));
                }
            }
        }
        return moves;
    }

    /**
     * Pre: El movimiento es valido
     * @param st
     * @param mv
     * @return
     */
    public static void applyMove(PathagonState st, PathagonToken mv){


    }

    public boolean validMove(PathagonState st,PathagonToken mv)  {
       int playerMoving = mv.player;
       if (st.getTurn() != playerMoving)
           return false;
       if (st.playerTokensLeft(playerMoving)<=0)
           return false;
       if (!st.getBoard().freePosition(mv.row,mv.col))
           return false;
       if (mv.overlaps(st.getBlockedMove()))
           return false;
       return true;
    }



}
