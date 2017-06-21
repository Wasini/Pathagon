package model.test;

import model.PathagonPath;
import model.PathagonToken;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by grazi on 17/06/17.
 */
class PathagonPathTest {

    private PathagonPath path;
    private PathagonPath path2;

    @Test
    void add() {
        path = new PathagonPath(-1);
        path.add(new PathagonToken(-1,0,0));
        path.add(new PathagonToken(-1,1,0));
        path.add(new PathagonToken(-1,1,1));
        path.add(new PathagonToken(-1,2,1));
        path.add(new PathagonToken(-1,3,1));
        path.add(new PathagonToken(-1,3,2));
        path.add(new PathagonToken(-1,4,2));
        path.add(new PathagonToken(-1,4,1));

        assertTrue(path.size() == 8);
    }

    @Test
    void extension() {
        path = new PathagonPath(-1);
        path.add(new PathagonToken(-1,0,0));
        path.add(new PathagonToken(-1,1,0));
        path.add(new PathagonToken(-1,1,1));
        path.add(new PathagonToken(-1,2,1));

        assertTrue(path.extension()==3);

        path2 = new PathagonPath(1);
        path2.add(new PathagonToken(1,0,0));
        path2.add(new PathagonToken(1,1,0));
        path2.add(new PathagonToken(1,2,0));
        path2.add(new PathagonToken(1,3,0));

        assertTrue(path2.extension()==1);


    }

    @Test
    void pathHead() {
    }

    @Test
    void pathEnd() {
    }

}