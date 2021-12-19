package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Vector3Test {
    
    public double EPISILON;

    @Before
    public void setUp() {
        this.EPISILON = 1e-4;
    }

    @Test
    public void hasWSetToZero() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        assertEquals("Has w set to 0.0", 0.0, vector3.getW(), 0);
    }

    @Test
    public void isInstanceOfTuple() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        assertTrue(vector3 + " object is a Vector3", vector3 instanceof Tuple3);
    }

    @Test
    public void testAddVector3ToSelfAndReturnsNewInstance() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Vector3 otherVector3 = new Vector3(5.3, -4.5, -3.3);
        Vector3 result = vector3.add(otherVector3);

        verifyVector3(9.6, -8.7, -0.2, 0.0, result, this.EPISILON);
    }

    @Test
    public void testAddsTwoVector3AndReturnsNewInstance() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Vector3 otherVector3 = new Vector3(5.3, -4.5, -3.3);
        Vector3 result = Vector3.add(vector3, otherVector3);

        verifyVector3(9.6, -8.7, -0.2, 0.0, result, this.EPISILON);
    }

    /**
     * 
     * @param expectedX double
     * @param expectedY
     * @param expectedZ
     * @param expectedW
     * @param vector3
     * @param delta
     */
    private void verifyVector3(
            double expectedX,
            double expectedY,
            double expectedZ,
            double expectedW,
            Vector3 vector3,
            double delta
            ) {

        assertNotNull("Result object is not null", vector3);
        assertTrue("Result object is a Vector3", vector3 instanceof Vector3);
        assertEquals("Result X value is correct", expectedX, vector3.getX(), delta);
        assertEquals("Result Y value is correct", expectedY, vector3.getY(), delta);
        assertEquals("Result Z value is correct", expectedZ, vector3.getZ(), delta);
        assertEquals("Result W value is correct", expectedW, vector3.getW(), delta);

    }
}
