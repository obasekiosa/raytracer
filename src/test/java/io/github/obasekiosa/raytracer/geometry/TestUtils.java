package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class TestUtils {
    
    /**
     * 
     * @param expectedX double
     * @param expectedY
     * @param expectedZ
     * @param expectedW
     * @param vector3
     * @param delta
     */
    public static void verifyVector3(
            double expectedX,
            double expectedY,
            double expectedZ,
            double expectedW,
            Vector3 vector3,
            double delta) {

        assertNotNull("Result object is not null", vector3);
        assertTrue("Result object is a Vector3", vector3 instanceof Vector3);
        assertEquals("Result X value is correct", expectedX, vector3.getX(), delta);
        assertEquals("Result Y value is correct", expectedY, vector3.getY(), delta);
        assertEquals("Result Z value is correct", expectedZ, vector3.getZ(), delta);
        assertEquals("Result W value is correct", expectedW, vector3.getW(), delta);

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
    public static void verifyPoint3(
            double expectedX,
            double expectedY,
            double expectedZ,
            double expectedW,
            Point3 point3,
            double delta) {

        assertNotNull("Result object is not null", point3);
        assertTrue("Result object is a Point3", point3 instanceof Point3);
        assertEquals("Result X value is correct", expectedX, point3.getX(), delta);
        assertEquals("Result Y value is correct", expectedY, point3.getY(), delta);
        assertEquals("Result Z value is correct", expectedZ, point3.getZ(), delta);
        assertEquals("Result W value is correct", expectedW, point3.getW(), delta);

    }
}
