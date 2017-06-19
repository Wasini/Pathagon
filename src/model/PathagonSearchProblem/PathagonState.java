package model.PathagonSearchProblem;
import framework.AdversarySearchState;
import model.PathagonBoard;
import model.PathagonToken;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by grazi on 13/06/17.
 */
public class PathagonState implements AdversarySearchState {

    public final int MAX_TOKENS = 14;
    public final int PLAYER1 = -1;
    public final int PLAYER2 = 1;
    public final int BOARDSIZE = 7;
    private int turn;   //Turno del juego: turn>0 => IA (player2)
    private PathagonBoard board;
    private List<PathagonToken> p1Tokens;
    private List<PathagonToken> p2Tokens;
    private int player1TokenAmount;
    private int player2TokenAmount;
    private List<PathagonToken> blockedMoves;
    private PathagonToken lastMove;


    public PathagonState() {
        this.board = new PathagonBoard();
        this.blockedMoves = new LinkedList<>();
        this.p1Tokens = new LinkedList<>();
        this.p2Tokens = new LinkedList<>();
        this.player1TokenAmount = 0;
        this.player2TokenAmount = 0;
        this.turn = -1;
    }

    //Copy constructor
    //CUIDADO: Los tokens son copiados por referencia!
    public PathagonState(PathagonState another) {
        this.turn = another.getTurn();
        this.board = new PathagonBoard(another.board);
        this.player1TokenAmount = another.getPlayerTokenAmount(PLAYER1);
        this.player2TokenAmount = another.getPlayerTokenAmount(PLAYER2);
        this.p1Tokens = new LinkedList<> (another.getPlayerTokens(PLAYER1));
        this.p2Tokens = new LinkedList<> (another.getPlayerTokens(PLAYER2));
        this.blockedMoves = another.getBlockedMoves();
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
        return player == PLAYER1 ? this.player1TokenAmount : this.player2TokenAmount;
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
        if(this.hasBlockedMoves() && otherState.hasBlockedMoves()){
            if (!this.blockedMoves.equals(otherState.getBlockedMoves()))
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

    public boolean moveIsBlocked(int row,int col) {
        return this.blockedMoves.stream().anyMatch(m-> m.row == row && m.col == col);
    }

    public boolean isInitial() {
        return this.lastMove == null;
    }

    public int playerTokensLeft(int player) {
       return MAX_TOKENS - (player > 0 ? this.player2TokenAmount : this.player1TokenAmount);
    }

    public void changeTurn(){
        this.turn *= -1;
    }




    public void addMove(PathagonToken mv) {

        if (!mv.isNull()){
            if (mv.player > 0) {
                this.player2TokenAmount++;
                this.p2Tokens.add(mv);
            } else {
                this.player1TokenAmount++;
                this.p1Tokens.add(mv);
            }
            this.board.addToken(mv);
            this.lastMove = mv;
        }
    }


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
                this.player1TokenAmount--;
            else
                this.player2TokenAmount--;
        }
    }


    /**
     * Metodo auxiliar para encontrar un elemento que cumpla el predicado test en una lista
     * removerlo y retornalo
     * si no lo encuentra retorna null
     * @param collection La lista a buscar el elemento
     * @param test predicado que debe cumplir el elemento de la lista
     * @param <T> Tipo de elemento de la lista
     * @return El elemento que cumple el predicado test en la lista o null si no es encontrado
     */
    private static <T> T findAndRemoveFirst(Iterable<? extends T> collection, Predicate<? super T> test) {
        T value = null;
        for (Iterator<? extends T> it = collection.iterator(); it.hasNext();)
            if (test.test(value = it.next())) {
                it.remove();
                return value;
            }
        return null;
    }


}
