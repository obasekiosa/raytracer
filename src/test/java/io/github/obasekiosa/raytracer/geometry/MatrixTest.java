package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.github.obasekiosa.raytracer.basic.Tuple3;

import static io.github.obasekiosa.raytracer.geometry.GeometryTestUtils.verifyMatrix;
import static io.github.obasekiosa.raytracer.geometry.GeometryTestUtils.verifyTuple3;

public class MatrixTest {

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

    @Test
    public void test_InstanceMethod_Multiply_ByMatrixReturnMatrix() {
        double[][] valuesA = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 8, 7, 6 },
                { 5, 4, 3, 2 }
        };

        double[][] valuesB = {
                { -2, 1, 2, 3 },
                { 3, 2, 1, -1 },
                { 4, 3, 6, 5 },
                { 1, 2, 7, 8 }
        };

        double[][] valuesAxB = {
                { 20, 22, 50, 48 },
                { 44, 54, 114, 108 },
                { 40, 58, 110, 102 },
                { 16, 26, 46, 42 }
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, valuesA[i][j]);
            }
        }

        Matrix otherMatrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                otherMatrix.setEntry(i, j, valuesB[i][j]);
            }
        }

        Matrix result = matrix.multiply(otherMatrix);

        verifyMatrix(valuesAxB, 4, 4, result, this.EPISILON);
    }
    
    @Test
    public void test_StaticMethod_Multiply_MatrixbyMatrixReturnMatrix() {
        double[][] valuesA = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 8, 7, 6 },
                { 5, 4, 3, 2 }
        };

        double[][] valuesB = {
                { -2, 1, 2, 3 },
                { 3, 2, 1, -1 },
                { 4, 3, 6, 5 },
                { 1, 2, 7, 8 }
        };

        double[][] valuesAxB = {
                { 20, 22, 50, 48 },
                { 44, 54, 114, 108 },
                { 40, 58, 110, 102 },
                { 16, 26, 46, 42 }
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, valuesA[i][j]);
            }
        }

        Matrix otherMatrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                otherMatrix.setEntry(i, j, valuesB[i][j]);
            }
        }

        Matrix result = Matrix.multiply(matrix, otherMatrix);
        verifyMatrix(valuesAxB, 4, 4, result, this.EPISILON);
    }
    
    @Test
    public void test_StaticMethod_Multiply_MatrixByTuple3ReturnTuple() {
        double[][] values = {
                { 1, 2, 3, 4 },
                { 2, 4, 4, 2 },
                { 8, 6, 4, 1 },
                { 0, 0, 0, 1 }
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        Tuple3 tuple3 = new Tuple3(1, 2, 3, 1);

        Tuple3 result = Matrix.multiply(matrix, tuple3);

        verifyTuple3(18, 24, 33, 1, result, this.EPISILON);

    }
    
    @Test
    public void test_StaticMethod_Identity_ReturnsMatrix() {

        Matrix matrix = Matrix.identity(4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j ) {
                    assertEquals("Diagonal contains a 1", 1, matrix.getEntry(i, j), this.EPISILON);
                } else {
                    assertEquals("Non Diagonal contains a 0", 0, matrix.getEntry(i, j), this.EPISILON);
                }
            }
        }

    }
    
    @Test
    public void test_InstanceMethod_Multiply_ByIdentityMatrixReturnMatrix() {
        double[][] values = {
                { 0, 1, 2, 4 },
                { 1, 2, 4, 8 },
                { 2, 4, 8, 16 },
                { 4, 8, 16, 32 }
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }
        Matrix identityMatrix = Matrix.identity(4);

        Matrix result = matrix.multiply(identityMatrix);
        boolean theSame = result.equals(matrix);
        assertTrue("Multiplying by the identity matrix does not change the matrix", theSame);

        Matrix reverse = identityMatrix.multiply(matrix);
        theSame = reverse.equals(matrix);
        assertTrue("Multiplying the identity matrix by a matrix does not change the matrix", theSame);

    }
    
    @Test
    public void test_InstanceMethod_Multiply_IdentityMatrixByTuple3ReturnTuple3() {


        Tuple3 tuple3 = new Tuple3(1, 2, 3, 4);
        Matrix identityMatrix = Matrix.identity(4);

        Tuple3 result = identityMatrix.multiply(tuple3);
        boolean theSame = result.equals(tuple3);
        assertTrue("Multiplying by the identity matrix does not change the Tuple", theSame);
    }
    
    @Test
    public void test_InstanceMethod_Transpose_ReturnMatrix() {
        double[][] values = {
                {0, 9, 3, 0},
                {9, 8, 0, 8},
                {1, 8, 5, 3},
                {0, 0, 5, 8}
        };

        double[][] expectedValues = {
                { 0, 9, 1, 0},
                { 9, 8, 8, 0},
                { 3, 0, 5, 5},
                { 0, 8, 3, 8}
        };

        Matrix matrix = new Matrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }
        
        Matrix result = matrix.transpose();

        verifyMatrix(expectedValues, 4, 4, result, this.EPISILON);
    }
    
    @Test
    public void test_InstanceMethod_Transpose_IdentityMatrixReturnMatrix() {

        Matrix identityMatrix = Matrix.identity(4);
        
        Matrix result = identityMatrix.transpose();

        boolean theSame = result.equals(identityMatrix);

        assertTrue("Transpose of identity matrix is an identity matrix", theSame);
    }

    @Test
    public void test_InstanceMethod_Determinant_2x2MatrixReturnDouble() {
        double[][] values = {
            {1, 5},
            {-3, 2}
        };

        Matrix matrix = new Matrix(2);
        matrix.setEntry(0, 0, values[0][0]);
        matrix.setEntry(0, 1, values[0][1]);
        matrix.setEntry(1, 0, values[1][0]);
        matrix.setEntry(1, 1, values[1][1]);

        double result = matrix.determinant();

        assertEquals("Determinant of a 2x2 matrix is correctly calculated", 17, result, this.EPISILON);

    }


    @Test
    public void test_InstanceMethod_SubMatrix_3x3Returns2x2Matrix() {
        double[][] values = {
            {1, 5, 0},
            {-3, 2, 7},
            {0, 6, -3}
        };
        double[][] expectedValues = {
            {-3, 2},
            {0, 6}
        };

        Matrix matrix = new Matrix(3);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        Matrix result = matrix.subMatrix(0, 2);

        verifyMatrix(expectedValues, 2, 2, result, this.EPISILON);
    }
    
    @Test
    public void test_InstanceMethod_SubMatrix_4x4Returns3x3Matrix() {
        double[][] values = {
            {-6, 1, 1, 6},
            {-8, 5, 8, 6},
            {-1, 0, 8, 2},
            {-7, 1, -1, 1},
        };
        double[][] expectedValues = {
            { -6, 1, 6 },
            { -8, 8, 6 },
            { -7, -1, 1 },
        };

        Matrix matrix = new Matrix(3);
        for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < values[0].length; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        Matrix result = matrix.subMatrix(2, 1);

        verifyMatrix(expectedValues, 3, 3, result, this.EPISILON);
    }
    
}
