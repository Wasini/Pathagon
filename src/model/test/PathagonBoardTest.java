package model.test;

import model.PathagonBoard;
import model.PathagonToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PathagonBoardTest {

    PathagonBoard board;

    @BeforeEach
    void setUp() {
        board = new PathagonBoard();
        board.addToken(new PathagonToken(-1,2,2));
        board.addToken(new PathagonToken(-1,2,3));
        board.addToken(new PathagonToken(1,2,4));
        board.addToken(new PathagonToken(1,3,3));
        board.addToken(new PathagonToken(-1,4,3));
        board.addToken(new PathagonToken(1,5,3));

        board.addToken(new PathagonToken(-1,6,6));


    }

    @Test
    void getAdyacents() {
        PathagonToken token = board.getToken(2,3);
        List<PathagonToken> eatable = board.getAdyacents(token,(tk -> tk.player != token.player));
        assertTrue(eatable.contains(board.getToken(2,4)));
        assertTrue(eatable.contains(board.getToken(3,3)));

        assertTrue(board.getAdyacents(board.getToken(6,6)).isEmpty());

    }

    @Test
    void equals() {
    }

}