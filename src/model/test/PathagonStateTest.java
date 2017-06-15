package model.test;

import model.PathagonBoard;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by grazi on 15/06/17.
 */
class PathagonStateTest {

    PathagonState st;


    //Add dummy moves and board positions
    @BeforeEach
    void setUp() {
        st = new PathagonState();
        PathagonBoard board = st.getBoard();

        st.getPlayerTokens(st.PLAYER1).add(new PathagonToken(-1,2,3));
        board.putPiece(-1,2,3);
        st.getPlayerTokens(st.PLAYER1).add(new PathagonToken(-1,3,3));
        board.putPiece(-1,3,3);
        st.getPlayerTokens(st.PLAYER1).add(new PathagonToken(-1,3,4));
        board.putPiece(-1,3,4);
        st.getPlayerTokens(st.PLAYER2).add(new PathagonToken(1,6,1));
        board.putPiece(1,6,1);
        st.getPlayerTokens(st.PLAYER2).add(new PathagonToken(1,5,1));
        board.putPiece(1,5,1);

        PathagonToken lastMove = new PathagonToken(1,4,1);
        board.putPiece(1,4,1);
        st.getPlayerTokens(st.PLAYER2).add(lastMove);
        st.setLastMove(lastMove);

    }

    @Test
    void isMax() {
        PathagonState newSt = new PathagonState();
        //Is player turn
        assertFalse(newSt.isMax());
    }



    @Test
    void equals() {


        //Copy the same State
        PathagonState other = new PathagonState(st);
        assertTrue(st.equals(other),"A copy is equal");

        st.getBoard().putPiece(-1,2,2);
        assertFalse(st.equals(other),"Board difers");
        st.getBoard().removePiece(2,2);

        PathagonToken newMove = new PathagonToken(1,4,4);
        st.getPlayerTokens(st.PLAYER2).add(newMove);
        assertFalse(st.equals(other),"Movements difers");


    }

    @Test
    void eatTokenAt() {
        int ownerOfToken = st.getBoard().getPiece(5,1);
        int tokenAmountForPlayer = st.getPlayerTokens(ownerOfToken).size();
        st.eatTokenAt(5,1);
        PathagonToken eatenToken = st.getBlockedMove();
        PathagonBoard board = st.getBoard();
        assertTrue(eatenToken.row ==5 && eatenToken.col == 1 && eatenToken.player == ownerOfToken,"La ficha comida esta como blockeada");
        assertTrue(tokenAmountForPlayer -1 == st.getPlayerTokens(ownerOfToken).size(),"La ficha se removio de la lista del jugador");
        assertTrue(board.getPiece(5,1) == board.EMPTY_CELL,"Se removio la ficha en el tablero");

    }

    @Test
    void ruleApplied() {
    }

}