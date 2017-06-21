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
        st.addToken(new PathagonToken(st.PLAYER1,2,3));
        st.addToken(new PathagonToken(st.PLAYER1,3,3));
        st.addToken(new PathagonToken(st.PLAYER1,3,4));
        st.addToken(new PathagonToken( st.PLAYER2,6,1));
        st.addToken(new PathagonToken(st.PLAYER2,5,1));
        st.addToken(new PathagonToken(st.PLAYER2,4,1));

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

        st.getBoard().addToken(-1,2,2);
        assertFalse(st.equals(other),"Board difers");
        st.getBoard().removeToken(2,2);

        st.addToken(new PathagonToken(1,4,4));
        assertFalse(st.equals(other),"Movements difers");


    }

    @Test
    void eatTokenAt() {
        int ownerOfToken = st.getBoard().getToken(5,1).player;
        int tokenAmountForPlayer = st.getPlayerTokenAmount(ownerOfToken);

        st.eatToken(st.getBoard().getToken(5,1));
        PathagonToken eatenToken = st.getBlockedMoves().get(0);
        PathagonBoard board = st.getBoard();
        assertTrue(eatenToken.row ==5 && eatenToken.col == 1 && eatenToken.player == ownerOfToken,"La ficha comida esta como blockeada");
        assertTrue(tokenAmountForPlayer -1 == st.getPlayerTokenAmount(ownerOfToken),"La ficha se removio de la lista del jugador");
        assertTrue(board.getToken(5,1) == board.EMPTY_CELL,"Se removio la ficha en el tablero");

    }

    @Test
    void ruleApplied() {
    }

}