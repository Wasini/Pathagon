package model.test;

import model.PathagonBoard;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by grazi on 15/06/17.
 */
class PathagonStateTest {
    @Test
    void isMax() {
        PathagonState st = new PathagonState();
        //Is player turn
        assertFalse(st.isMax());
    }

    @Test
    void equals() {
        PathagonState st = new PathagonState();
        PathagonBoard oldBoard = st.getBoard();
        //Add dummy moves and board positions
        st.getPlayer1Tokens().add(new PathagonToken(-1,2,3));
        oldBoard.putPiece(-1,2,3);
        st.getPlayer1Tokens().add(new PathagonToken(-1,3,3));
        oldBoard.putPiece(-1,3,3);
        st.getPlayer1Tokens().add(new PathagonToken(-1,3,4));
        oldBoard.putPiece(-1,3,4);
        st.getPlayer2Tokens().add(new PathagonToken(1,6,1));
        oldBoard.putPiece(1,6,1);
        st.getPlayer2Tokens().add(new PathagonToken(1,5,1));
        oldBoard.putPiece(1,5,1);
        PathagonToken lastMove = new PathagonToken(1,4,1);
        oldBoard.putPiece(1,4,1);
        st.getPlayer2Tokens().add(lastMove);

        //Copy the same State
        st.setLastMove(lastMove);
        PathagonState other = new PathagonState(st);
        assertTrue(st.equals(other),"A copy is equal");

        oldBoard.putPiece(-1,2,2);
        assertFalse(st.equals(other),"Board difers");
        oldBoard.removePiece(2,2);

        PathagonToken newMove = new PathagonToken(1,4,4);
        st.getPlayer2Tokens().add(newMove);
        assertFalse(st.equals(other),"Movements difers");


    }

    @Test
    void ruleApplied() {
    }

}