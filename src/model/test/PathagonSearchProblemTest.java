package model.test;

import model.PathagonBoard;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by grazi on 15/06/17.
 */
class PathagonSearchProblemTest {

    private PathagonSearchProblem<PathagonState> p;
    private PathagonState currState;

    @BeforeEach
    void setUp() {
        p = new PathagonSearchProblem<>();
        currState = p.initialState();
        PathagonBoard board = currState.getBoard();
        currState.addMove(new PathagonToken(-1,2,3));
        board.addToken(-1,2,3);
        PathagonToken lm = new PathagonToken(1,3,3);
        currState.addMove(lm);
        board.addToken(1,3,3);
        currState.setTurn(-1);
        currState.setLastMove(lm);
    }


    @Test
    void getSuccessors() {
    }

    @Test
    void end() {
    }

    @Test
    void value() {
    }

    @Test
    void getAvaibleMoves() {
        List<PathagonToken> moves = p.getAvaibleMoves(currState);
        assertTrue(moves.size() == 47);
        assertTrue(moves.stream().noneMatch(mv -> (mv.col == 3 && mv.row ==2) || (mv.col == 3 && mv.row == 2)));
    }

    @Test
    void applyMove() {
    }


    @Test
    void validMove() {
        PathagonToken myMove = new PathagonToken(1,2,4);
        assertFalse(p.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n No es el turno del jugador");


        myMove.player = -1;
        assertTrue(p.validMove(currState,myMove),"movimiento valido "+myMove.toString()+"/n No es el turno del jugador");


        myMove.col = 3;
        assertFalse(p.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n Lugar ocupado");


        PathagonToken blocked = new PathagonToken(1,4,5);
        currState.addBlockedMove(blocked);
        myMove.col=5; myMove.row =4;
        assertFalse(p.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n Lugar bloqueado");
        currState.removeBlockedMoves();

        IntStream.range(0,currState.playerTokensLeft(myMove.player)).forEach(nbr -> currState.addMove(new PathagonToken(-1,1,1)));
        myMove.col = 1;
        myMove.row = 6;
        assertFalse(p.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n Sin fichas disponibles");

    }

}