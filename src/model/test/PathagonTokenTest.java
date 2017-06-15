package model.test;

import static org.junit.jupiter.api.Assertions.*;

import model.PathagonToken;
import org.junit.jupiter.api.Test;

/**
 * Created by grazi on 15/06/17.
 */

class PathagonTokenTest {
    @Test
    void isAdyacent() {
        PathagonToken a = new PathagonToken(1,5,6);
        PathagonToken c = new PathagonToken(1,6,6);
        assertTrue(a.isAdyacent(c),() -> a.toString() + " is adyacent to " + c.toString());
        c.col = 7;
        assertFalse(a.isAdyacent(c),() -> a.toString() + " isn't adyacent to " + c.toString());
        c.row = 5;
        c.col = 6;
        assertFalse(a.isAdyacent(c),() -> a.toString() + " isn't adyacent to " + c.toString());
    }

    @Test
    void overlaps() {
        PathagonToken a = new PathagonToken(1,5,6);
        PathagonToken c = new PathagonToken(1,6,6);
        assertFalse(a.overlaps(c),() -> a.toString() + " doesn't overlaps " + c.toString());
        c.row = 5;
        assertTrue(a.overlaps(c),() -> a.toString() + " overlaps " + c.toString());

    }

}