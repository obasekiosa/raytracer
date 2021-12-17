package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Point3Test {
    

    @Test
    public void hasWSetToOne() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        assertEquals("Has w set to 1.0", 1.0, point3.getW(), 0);
    }

    @Test
    public void isInstanceOfTuple() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        assertTrue(point3 + " object is a Point", point3 instanceof Tuple3);
    }
}
