package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import static io.github.obasekiosa.raytracer.geometry.GeometryTestUtils.verifyMatrix;

public class MatixTest {

    double EPISILON;

    @Before
    public void setup() {
        this.EPISILON = GeometryContstants.EQUALITY_DELTA;
    }

    @Test
    public void test_InstanceMethod_Constructor_TwoIntegersCreate4x4Matrix() {
        double[][] values = {
                { 1, 2, 3, 4 },
                { 5.5, 6.5, 7.5, 8.5 },
                { 9, 10, 11, 12 },
                { 13.5, 14.5, 15.5, 16.5 },
        };

        Matrix matrix = new Matrix(4, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        verifyMatrix(values, 4, 4, matrix, this.EPISILON);
    }
    
    @Test
    public void test_InstanceMethod_Constructor_OneIntegerCreate4x4Matrix() {
        double[][] values = {
            {1, 2, 3, 4},
            {5.5, 6.5, 7.5, 8.5},
            {9, 10, 11, 12},
            {13.5, 14.5, 15.5, 16.5},
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        verifyMatrix(values, 4, 4, matrix, this.EPISILON);
    }


    @Test
    public void test_InstanceMethod_Constructor_Create2x2Matrix() {
        double[][] values = {
            {-3, 5},
            {1, -2}
        };

        Matrix matrix = new Matrix(2);
        matrix.setEntry(0, 0, values[0][0]);
        matrix.setEntry(0, 1, values[0][1]);
        matrix.setEntry(1, 0, values[1][0]);
        matrix.setEntry(1, 1, values[1][1]);

        verifyMatrix(values, 2, 2, matrix, this.EPISILON);

    }

    @Test
    public void test_InstanceMethod_Constructor_Create3x3Matrix() {
        double[][] values = {
            {-3, 5, 0},
            {1, -2, -7},
            {0, 1, 1},
        };

        Matrix matrix = new Matrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        verifyMatrix(values, 2, 2, matrix, this.EPISILON);

    }
    
    @Test
    public void test_InstanceMethod_Equals_ReturnBooleanTrue() {
        double[][] values = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 8, 7, 6},
            {5, 4, 3, 2}
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        Matrix otherMatrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                otherMatrix.setEntry(i, j, values[i][j]);
            }
        }

        boolean equals = matrix.equals(otherMatrix);
        boolean reverse = otherMatrix.equals(matrix);
        assertTrue("Matrix are equal", equals);
        assertTrue("Matrix are equal when the order of comparison is reversed", reverse);

    }

    @Test
    public void test_InstanceMethod_Equals_ReturnBooleanFalse() {
        double[][] valuesA = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 8, 7, 6},
            {5, 4, 3, 2}
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, valuesA[i][j]);
            }
        }

        double[][] valuesB = {
                { 2, 3, 4, 5},
                { 6, 7, 8, 9},
                { 8, 7, 6, 5},
                { 4, 3, 2, 1}
        };
        Matrix otherMatrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                otherMatrix.setEntry(i, j, valuesB[i][j]);
            }
        }

        boolean equals = matrix.equals(otherMatrix);
        boolean reverse = otherMatrix.equals(matrix);
        assertFalse("Matrix are not equal", equals);
        assertFalse("Matrix are not equal when the order of comparison is reversed", reverse);
    }
    
}
