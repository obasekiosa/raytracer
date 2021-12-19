package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.github.obasekiosa.raytracer.basic.Tuple3;

public class Point3Test {

    public double EPISILON;

    @Before
    public void setUp() {
        this.EPISILON = 1e-4;
    }
    

    @Test
    public void testHasWSetToOne() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        assertEquals("Has w set to 1.0", 1.0, point3.getW(), 0);
    }

    @Test
    public void testIsInstanceOfTuple() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        assertTrue(point3 + " object is a Point3", point3 instanceof Tuple3);
    }

    @Test
    public void testAddPoint3ToSelfAndReturnsNewInstance() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        Point3 otherPoint3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = point3.add(otherPoint3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void testAddsTwoPoint3AndReturnsNewInstance() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        Point3 otherPoint3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = Point3.add(point3, otherPoint3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    /**
     * 
     * @param expectedX
     * @param expectedY
     * @param expectedZ
     * @param expectedW
     * @param point3
     * @param delta
     */
    private void verifyPoint3(
        double expectedX, 
        double expectedY, 
        double expectedZ, 
        double expectedW,
        Point3 point3,
        double delta
        ) {

            assertNotNull("Result object is not null", point3);
            assertTrue("Result object is a Point3", point3 instanceof Point3);
            assertEquals("Result X value is correct", expectedX, point3.getX(), delta);
            assertEquals("Result Y value is correct", expectedY, point3.getY(), delta);
            assertEquals("Result Z value is correct", expectedZ, point3.getZ(), delta);
            assertEquals("Result W value is correct", expectedW, point3.getW(), delta);

        }
}
