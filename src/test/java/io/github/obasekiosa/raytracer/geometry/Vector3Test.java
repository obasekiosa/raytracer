package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Vector3Test {
    

    @Test
    public void hasWSetToZero() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        assertEquals("Has w set to 0.0", 0.0, vector3.getW(), 0);
    }

    @Test
    public void isInstanceOfTuple() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        assertTrue(vector3 + " object is a Vector", vector3 instanceof Tuple3);
    }
}
