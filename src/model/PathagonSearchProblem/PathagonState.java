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

    public final int MAX_TOKENS = 14;
    public final int PLAYER1 = -1;
    public final int PLAYER2 = 1;
    private int turn;   //Turno del juego: turn>0 => IA (player2)
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
        this.player1Tokens = new LinkedList<>(another.getPlayerTokens(PLAYER1));
        this.player2Tokens = new LinkedList<>(another.getPlayerTokens(PLAYER2));
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

    public List<PathagonToken> getPlayerTokens(int player) {
        return player > 0 ? this.player2Tokens : this.player1Tokens;
    }


    ////////////////////

    @Override
    public boolean isMax() {
        return (this.turn>0);
    }


    @Override
    public boolean equals(AdversarySearchState state) {
        PathagonState otherState = (PathagonState) state;
        if (!this.player1Tokens.equals(otherState.getPlayerTokens(PLAYER1)))
            return false;
        if (!this.player2Tokens.equals(otherState.getPlayerTokens(PLAYER2)))
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

    public int playerTokensLeft(int player) {
       return MAX_TOKENS - (player > 0 ? this.player2Tokens.size() : this.player1Tokens.size());
    }

    public void removeBlockedMove() {
        this.blockedMove = null;
    }

    public void addMove(PathagonToken mv) {
        if (mv.player > 0)
            this.player2Tokens.add(mv);
        else
            this.player1Tokens.add(mv);
    }



    /**
     * Come una ficha en la posicion (row,col) del tablero, la remueve de la lista de fichas
     * del jugador correspondiente y la pone como movimiento blockeado para el dueño de la ficha
     * Si no hay ficha en la posicion (row,col) del tablero no se hace nada
     * @param row fila del tablero
     * @param col columna del tablero
     */
    public void eatTokenAt(int row,int col) {
        int removedTokenPlayer = this.board.getPiece(row,col);

        if (removedTokenPlayer != 0) {
            List<PathagonToken> playerTokens = getPlayerTokens(removedTokenPlayer);
            blockedMove = findAndRemoveFirst(playerTokens,tk -> (tk.row == row && tk.col == col));
            this.board.removePiece(row,col);
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
