package model.test;

import model.InvalidMoveException;
import model.PathagonGameController;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;


class PathagonControllerEngineTest {
    PathagonGameController myGame;
    PathagonState st;
    PathagonState st2;
    PathagonSearchProblem<PathagonState> problem;

    @BeforeEach
    void setUp() {
        myGame = new PathagonGameController("Yo",5);
    }

    @Test
    void mkMove() {

        try {
            myGame.mkMove(3,0);
            st = myGame.getCurrState();
            myGame.iaPlay();
            myGame.mkMove(3,1);
            myGame.iaPlay();
            myGame.mkMove(3,3);
            myGame.iaPlay();
            myGame.mkMove(3,4);
            myGame.iaPlay();
            myGame.mkMove(3,5);
            myGame.iaPlay();
            myGame.mkMove(3,6);
            myGame.iaPlay();



            assertTrue(true);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
    }

    @Test
    void iaPlay() {
    }

    @Test
    void canPlay() {
    }

    @Test
    void gameEnd() {
    }

}