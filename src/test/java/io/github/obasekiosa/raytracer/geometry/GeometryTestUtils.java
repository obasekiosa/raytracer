package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import io.github.obasekiosa.raytracer.basic.Tuple3;

public abstract class GeometryTestUtils {
    
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

    /**
     * 
     * @param expectedX1
     * @param expectedX2
     * @param expectedX3
     * @param expectedX4
     * @param tuple3
     * @param delta
     */
    public static void verifyTuple3(
            double expectedX1,
            double expectedX2,
            double expectedX3,
            double expectedX4,
            Tuple3 tuple3,
            double delta) {

        assertNotNull("Result object is not null", tuple3);
        assertTrue("Result object is a Tuple3", tuple3 instanceof Tuple3);
        assertEquals("Result X1 value is correct", expectedX1, tuple3.getX1(), delta);
        assertEquals("Result X2 value is correct", expectedX2, tuple3.getX2(), delta);
        assertEquals("Result X3 value is correct", expectedX3, tuple3.getX3(), delta);
        assertEquals("Result X4 value is correct", expectedX4, tuple3.getX4(), delta);

    }

    /**
     * 
     * @param values
     * @param expectedRows
     * @param expectedColumns
     * @param matrix
     * @param delta
     */
    public static void verifyMatrix(
            double[][] values,
            int expectedRows,
            int expectedColumns,
            Matrix matrix,
            double delta
            ) {

        assertEquals("Create a matrix of correct row size", expectedRows, matrix.getRowCount());
        assertEquals("Create a matrix of correct col size", expectedColumns, matrix.getColumnCount());

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                assertEquals("Matrix has correct entry", values[i][j], matrix.getEntry(i, j), delta);
            }
        }
    }
}
