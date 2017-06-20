package controller.test;

import controller.PathagonController;
import model.InvalidMoveException;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;


class PathagonControllerTest {
    PathagonController myGame;
    PathagonState st;
    PathagonState st2;
    PathagonSearchProblem<PathagonState> problem;

    @BeforeEach
    void setUp() {
        myGame = new PathagonController("Tester",1);
       // myGame.setView(new DummyView(myGame));
    }

    @Test
    void mkMove() {/*

        try {
            st = myGame.getState();
            int value;
            myGame.mkMove(3,1);
            value = myGame.getValue();
            myGame.mkMove(3,0);
            myGame.mkMove(4,0);
            value = myGame.getValue();

            myGame.mkMove(3,2);

            value = myGame.getValue();
            value = myGame.getValue();





            //  assertTrue(myGame.hasEnded());



            assertTrue(true);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        */
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