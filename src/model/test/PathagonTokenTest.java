package model.test;

import static org.junit.jupiter.api.Assertions.*;

import model.PathagonToken;
import org.junit.jupiter.api.Test;


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

    @Test
    void trappedBy() {
        PathagonToken a = new PathagonToken(1,4,6);
        PathagonToken b = new PathagonToken(-1,5,6);
        PathagonToken c = new PathagonToken(1,6,6);
        assertTrue(b.isTrapedBy(a,c),b.toString()+" atrapado por, "+a.toString()+" + "+b.toString());

        a.player=-1;
        assertFalse(b.isTrapedBy(a,c),b.toString()+"no atrapado por, "+a.toString()+" + "+b.toString());

        a.player= 1;
        a.col=5;
        a.row=5;
        assertFalse(b.isTrapedBy(a,c),b.toString()+"no atrapado por, "+a.toString()+" + "+b.toString());
    }

}