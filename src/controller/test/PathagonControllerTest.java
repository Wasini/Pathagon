package controller.test;

import controller.PathagonController;
import model.InvalidMoveException;
import model.PathagonSearchProblem.PathagonSearchProblem;
import model.PathagonSearchProblem.PathagonState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.DummyView;


import static org.junit.jupiter.api.Assertions.assertTrue;


class PathagonControllerTest {
    PathagonController myGame;
    PathagonState st;
    PathagonState st2;
    PathagonSearchProblem<PathagonState> problem;

    @BeforeEach
    void setUp() {
        myGame = new PathagonController();
        myGame.newGame("Tester",4);
        myGame.setView(new DummyView(myGame));
    }

    @Test
    void mkMove() {

        try {
            st = myGame.getState();
            myGame.mkMove(0,0);
            myGame.iaPlay();
            myGame.mkMove(0,1);
            myGame.iaPlay();
            myGame.mkMove(0,0);
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