package model.test;

import framework.AdversarySearchEngine;
import framework.AdversarySearchProblem;
import framework.AdversarySearchState;
import model.PathagonSearchProblem.MinMaxAlphaBetaEngine;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import model.PathagonToken;
import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;

import static org.junit.Assert.*;

public class MinMaxAlphaBetaEngineTest {



    private MinMaxAlphaBetaEngine<PathagonSearchProblem<PathagonState>,PathagonState> ia;
    private PathagonState currState;
    private PathagonSearchProblem p;

    @Before
    public void setUp() throws Exception {
        p = new PathagonSearchProblem<>();
        ia = new MinMaxAlphaBetaEngine<>(p,2);
        currState = p.initialState();
    }

    @Test
    public void computeValue1() throws Exception {
        /*
        o   x o o o
            x
            x

        o: Player1 (filas)
        x: ia   (columnas)
         */

        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,0));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,0,2));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,3));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,2,2));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,4));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(1,3,2));
        PathagonSearchProblem.applyMove(currState,new PathagonToken(-1,0,5));
        int calculatedValue = ia.computeValue(currState);
        assertFalse("Valor futuro favorable para el jugador1", calculatedValue <0);
        PathagonState next = ia.computeSuccessor(currState);
        //assertTrue("El elegido tien el mismo valor al calculado",p.value(next)==calculatedValue);
        //ia.report();

    }

    @Test
    public void computeSuccessor1() throws Exception {
    }

    @Test
    public void computeSuccessor() throws Exception {
    }

}