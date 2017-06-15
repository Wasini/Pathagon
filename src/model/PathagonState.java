package model;
import framework.AdversarySearchState;

import java.util.List;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonState implements AdversarySearchState {

    public int turn;   //Turno del juego: turn>0 => player1
    public PathagonBoard board;
    public List<PathagonToken> player1Pieces;
    public List<PathagonToken> player2Pieces;
    public int[] avaibleTokens; //Fichas disponibles para jugador 1(avaibleTokens[0]

    public PathagonState() {
        this.board = new PathagonBoard();
        this.avaibleTokens = new int[]{14,14};
        this.turn = 1;
    }

    public PathagonState(int turn, PathagonBoard board, int[] avaibleTokens) {
        this.turn = turn;
        this.board = board;
        this.avaibleTokens = avaibleTokens;
    }

    @Override
    public boolean isMax() {
        return false;
    }

    @Override
    public boolean equals(AdversarySearchState other) {
        return false;
    }

    @Override
    public PathagonToken ruleApplied() {
        return null;
    }
}
