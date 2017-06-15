package model.PathagonSearchProblem;
import framework.AdversarySearchState;
import model.PathagonBoard;
import model.PathagonToken;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonState implements AdversarySearchState {

    private int turn;   //Turno del juego: turn>0 => IA
    private PathagonBoard board;
    private List<PathagonToken> player1Tokens;
    private List<PathagonToken> player2Tokens;
    private PathagonToken blockedMove;
    private PathagonToken lastMove;


    public PathagonState() {
        this.board = new PathagonBoard();
        this.player1Tokens = new LinkedList<>();
        this.player2Tokens = new LinkedList<>();
        this.turn = -1;
    }

    //Copy constructor
    //CUIDADO: Los tokens son copiados por referencia!
    public PathagonState(PathagonState another) {
        this.turn = another.getTurn();
        this.board = new PathagonBoard(another.board);
        this.player1Tokens = new LinkedList<>(another.getPlayer1Tokens());
        this.player2Tokens = new LinkedList<>(another.getPlayer2Tokens());
        this.blockedMove = another.getBlockedMove();
        this.lastMove = another.getLastMove();
    }

    /*GETTERS & SETTERS*/

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public PathagonToken getBlockedMove() {
        return blockedMove;
    }

    public void setBlockedMove(PathagonToken blockedMove) {
        this.blockedMove = blockedMove;
    }

    public PathagonToken getLastMove() {
        return lastMove;
    }

    public void setLastMove(PathagonToken lastMove) {
        this.lastMove = lastMove;
    }

    public PathagonBoard getBoard() {
        return board;
    }

    public List<PathagonToken> getPlayer1Tokens() {
        return player1Tokens;
    }

    public List<PathagonToken> getPlayer2Tokens() {
        return player2Tokens;
    }

    ////////////////////

    @Override
    public boolean isMax() {
        return (this.turn>0);
    }


    @Override
    public boolean equals(AdversarySearchState state) {
        PathagonState otherState = (PathagonState) state;
        if (!this.player1Tokens.equals(otherState.getPlayer1Tokens()))
            return false;
        if (!this.player2Tokens.equals(otherState.getPlayer2Tokens()))
            return false;
        if (!this.board.equals(otherState.getBoard()))
            return false;
        if (this.turn != otherState.getTurn())
            return false;
        if(this.hasBlockedMove() && otherState.hasBlockedMove()){
            if (!this.blockedMove.equals(otherState.getBlockedMove()))
                return false;
        }
        if(!this.isInitial() && !otherState.isInitial()) {
            if (!this.lastMove.equals(otherState.getLastMove()))
                return false;
        }
        return true;
    }

    @Override
    public PathagonToken ruleApplied() {
        return lastMove;
    }

    public boolean hasBlockedMove() {
        return this.blockedMove != null;
    }

    public boolean isInitial() {
        return this.lastMove == null;
    }



}
