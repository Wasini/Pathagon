package model.PathagonSearchProblem;
import framework.AdversarySearchState;
import model.PathagonBoard;
import model.PathagonToken;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonState implements AdversarySearchState {

    public final int PLAYER_MAX_TOKENS = 14;
    public final int PLAYER1 = -1;
    public final int PLAYER2 = 1;
    public final int BOARDSIZE = 7;
    private int turn;   //Turno del juego: turn>0 => IA (player2)
    private PathagonBoard board;
    private List<PathagonToken> p1Tokens;
    private List<PathagonToken> p2Tokens;
    private List<PathagonToken> blockedMoves;
    private PathagonToken lastMove;


    public PathagonState() {
        this.board = new PathagonBoard();
        this.blockedMoves = new LinkedList<>();
        this.p1Tokens = new LinkedList<>();
        this.p2Tokens = new LinkedList<>();

        this.turn = -1;
    }

    //Copy constructor
    //Tokens copiados por referncia
    public PathagonState(PathagonState another) {
        this.turn = another.getTurn();
        this.board = new PathagonBoard(another.board);
        this.p1Tokens = new LinkedList<>();
        this.p2Tokens = new LinkedList<>();
        this.blockedMoves = new LinkedList<>();
        for ( PathagonToken tk1 : another.getPlayerTokens(PLAYER1)) p1Tokens.add(tk1);
        for ( PathagonToken tk2 : another.getPlayerTokens(PLAYER2)) p2Tokens.add(tk2);
        if (another.hasBlockedMoves())
            for ( PathagonToken blocked : another.getBlockedMoves()) this.blockedMoves.add(blocked);
        this.lastMove = another.getLastMove();
    }

    /*GETTERS & SETTERS*/

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getCurrentPlayer() {
        return this.turn > 0? PLAYER2 : PLAYER1;
    }

    public List<PathagonToken> getBlockedMoves() {
        return blockedMoves;
    }

    public void addBlockedMove(PathagonToken blockedMove) {
        this.blockedMoves.add(blockedMove);
    }

    public void removeBlockedMoves() {
        this.blockedMoves.clear();
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

    public int getPlayerTokenAmount(int player) {
        return player == PLAYER1 ? this.p1Tokens.size() : this.p1Tokens.size();
    }

    public List<PathagonToken> getPlayerTokens(int player) {
        return player == PLAYER1 ? this.p1Tokens : this.p2Tokens;
    }



    ////////////////////

    @Override
    public boolean isMax() {
        return (this.turn>0);
    }


    @Override
    public boolean equals(AdversarySearchState state) {
        PathagonState otherState = (PathagonState) state;
        if (!this.board.equals(otherState.getBoard()))
            return false;
        if (this.turn != otherState.getTurn())
            return false;
        if(this.hasBlockedMoves()){
            if ( !this.blockedMoves.equals(otherState.getBlockedMoves()))
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

    public boolean hasBlockedMoves() {
        return this.blockedMoves.size() != 0;
    }

    public boolean moveIsBlocked(PathagonToken mv) {
        return this.blockedMoves.stream().anyMatch(m -> (m.overlaps(mv)));
    }

    //Esta la posicion (row,col) del tablero bloqueada?
    public boolean moveIsBlocked(int row,int col) {

        return this.blockedMoves.stream().anyMatch(m-> m.row == row && m.col == col);
    }

    public boolean isInitial() {
        return this.lastMove == null;
    }


    //Cantida de fichas disponibles para el jugador
    public int playerTokensLeft(int player) {
       return PLAYER_MAX_TOKENS - (player == PLAYER1 ? this.p1Tokens.size() : this.p2Tokens.size());
    }


    public void changeTurn(){
        this.turn *= -1;
    }


    /**
     * Agrega la ficha al tablero y a la lista dle jugador correspondiente
     * si se quiere agerga runa ficha nula solo se la agrega como ultimo movimiento
     * @param tk
     */

    public void addToken(PathagonToken tk) {

        if (!tk.isNull()){
            if (tk.player > 0) {
                this.p2Tokens.add(tk);
            } else {
                this.p1Tokens.add(tk);
            }
            this.board.addToken(tk);
            this.lastMove = tk;
            this.lastMove.isNull = false;
        } else {
            this.lastMove = tk;
        }

    }


    /**
     * Dice si la Posicion (row,col) del tablero esta disponible
     * @param row
     * @param col
     * @return
     */
    public boolean positionIsAvaible(int row,int col) {
        if (this.board.getToken(row,col) != this.board.EMPTY_CELL)
            return false;
        if (this.hasBlockedMoves() && moveIsBlocked(row,col))
            return false;
        return true;
    }


    /**
     * Come la ficha @tk del tablero y la pone como movimiento blockeado
     * Si la ficha no se encuentra en el tablero no realiza nada
     * @param tk Ficha a eliminar
     *
     */
    public void eatToken(PathagonToken tk) {
        PathagonToken removedToken = this.board.removeToken(tk);
        if (removedToken != null) {
            blockedMoves.add(removedToken);
            if (removedToken.player == PLAYER1)
                p1Tokens.remove(removedToken);
            else
                p2Tokens.remove(removedToken);
        }
    }


}
