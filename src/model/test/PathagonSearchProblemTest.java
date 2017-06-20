package model.test;

import model.PathagonBoard;
import model.PathagonPath;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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
    void generatePath1() {
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,0));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,1,0));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,1));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,1,1));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,2));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,1,2));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,3));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,1,3));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,4));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,1,4));
        PathagonPath p1Path = PathagonSearchProblem.generatePath(currState.getBoard(),currState.getPlayerTokens(-1).get(0));
        PathagonPath p2Path = PathagonSearchProblem.generatePath(currState.getBoard(),currState.getPlayerTokens(1).get(0));
        assertTrue(p1Path.extension()== 1 && p2Path.extension()==5);

    }


    @Test
    void generatePath2() {

        /*
        p1: x x
            x x
              x
        p2:
            o o
            o o o
         */

        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,0));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,5,4));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,1));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,5,3));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,1,1));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,4,4));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,1,0));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,4,3));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,2,1));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,5,5));
        PathagonPath p1Path = PathagonSearchProblem.generatePath(currState.getBoard(),currState.getPlayerTokens(-1).get(0));
        PathagonPath p2Path = PathagonSearchProblem.generatePath(currState.getBoard(),currState.getPlayerTokens(1).get(0));
        assertTrue(p1Path.extension()== 3 && p2Path.extension()==3);

    }

    @Test
    void getAvaibleMoves() {
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,2,3));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,3,3));
        List<PathagonToken> moves = p.getAvaibleMoves(currState);
        assertTrue(moves.size() == 47);
        assertTrue(moves.stream().noneMatch(mv -> (mv.col == 3 && mv.row ==2) || (mv.col == 3 && mv.row == 2)));
    }

    @Test
    void applyMove() {
    }


    @Test
    void validMove() {
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,2,3));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,3,3));
        PathagonToken myMove = new PathagonToken(1,2,4);
        assertFalse(PathagonSearchProblem.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n No es el turno del jugador");


        myMove.player = -1;
        assertTrue(PathagonSearchProblem.validMove(currState,myMove),"movimiento valido "+myMove.toString());


        myMove.col = 3;
        assertFalse(PathagonSearchProblem.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n Lugar ocupado");


        PathagonToken blocked = new PathagonToken(1,4,5);
        currState.addBlockedMove(blocked);
        myMove.col=5; myMove.row =4;
        assertFalse(PathagonSearchProblem.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n Lugar bloqueado");
        currState.removeBlockedMoves();

        IntStream.range(0,currState.playerTokensLeft(myMove.player)).forEach(nbr -> currState.addMove(new PathagonToken(-1,1,1)));
        myMove.col = 1;
        myMove.row = 6;
        assertFalse(PathagonSearchProblem.validMove(currState,myMove),"movimiento invalido "+myMove.toString()+"/n Sin fichas disponibles");

    }

}