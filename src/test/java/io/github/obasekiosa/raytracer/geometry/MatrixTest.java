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
    public void test_StaticMethod_From_ArrayOfDoublesCreateMatrix() {
        double[][] values = {
                { 1, 2, 3, 4 },
                { 5.5, 6.5, 7.5, 8.5 },
                { 9, 10, 11, 12 },
                { 13.5, 14.5, 15.5, 16.5 },
        };

        Matrix matrix = Matrix.from(values);
    
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

        verifyMatrix(values, 3, 3, matrix, this.EPISILON);

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
    public void test_InstanceMethod_SubMatrix_3x3Return2x2Matrix() {
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
    public void test_InstanceMethod_SubMatrix_4x4Return3x3Matrix() {
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

    @Test
    public void test_InstanceMethod_Minor_ReturnDouble() {
        double[][] values = {
            {3, 5, 0},
            {2, -1, -7},
            {6, -1, 5},
        };

        Matrix matrix = Matrix.from(values);
        Matrix B = matrix.subMatrix(1, 0);

        double determinant = B.determinant();
        assertEquals("Determinant of submatrix", 25, determinant, this.EPISILON);

        double minor = matrix.minor(1, 0);
        assertEquals("Minor of matrix", 25, minor, this.EPISILON);

    }

    @Test
    public void test_InstanceMethod_Cofactor_ReturnDouble() {
        double[][] values = {
                { 3, 5, 0 },
                { 2, -1, -7 },
                { 6, -1, 5 },
        };

        Matrix A = Matrix.from(values);

        double minor00 = A.minor(0, 0);
        assertEquals("Computed minor of matrix", -12, minor00, this.EPISILON);
        
        double cofactor00 = A.cofactor(0, 0);
        assertEquals("Computed cofactor of matrix", -12, cofactor00, this.EPISILON);

        double minor10 = A.minor(1, 0);
        assertEquals("Computed minor of matrix", 25, minor10, this.EPISILON);

        double cofactor10 = A.cofactor(1, 0);
        assertEquals("Computed cofactor of matrix", -25, cofactor10, this.EPISILON);
    }
    
    @Test
    public void test_InstanceMethod_Determinant_3x3MatrixReturnDouble() {
        double[][] values = {
                { 1, 2, 6 },
                { -5, 8, -4 },
                { 2, 6, 4 },
        };

        Matrix A = Matrix.from(values);
        double cofactor00 = A.cofactor(0, 0);
        assertEquals("Cofactor of matrix computed", 56, cofactor00, this.EPISILON);

        double cofactor01 = A.cofactor(0, 1);
        assertEquals("Cofactor of matrix computed", 12, cofactor01, this.EPISILON);

        double cofactor02 = A.cofactor(0, 2);
        assertEquals("Cofactor of matrix computed", -46, cofactor02, this.EPISILON);

        double determinant = A.determinant();
        assertEquals("Determinant of matrix computed", -196, determinant, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Determinant_4x4MatrixReturnDouble() {
        double[][] values = {
                { -2, -8, 3, 5 },
                { -3, 1, 7, 3 },
                { 1, 2, -9, 6 },
                { -6, 7, 7, -9 }
        };

        Matrix A = Matrix.from(values);
        double cofactor00 = A.cofactor(0, 0);
        assertEquals("Cofactor of matrix computed", 690, cofactor00, this.EPISILON);

        double cofactor01 = A.cofactor(0, 1);
        assertEquals("Cofactor of matrix computed", 447, cofactor01, this.EPISILON);

        double cofactor02 = A.cofactor(0, 2);
        assertEquals("Cofactor of matrix computed", 210, cofactor02, this.EPISILON);

        double cofactor03 = A.cofactor(0, 3);
        assertEquals("Cofactor of matrix computed", 51, cofactor03, this.EPISILON);

        double determinant = A.determinant();
        assertEquals("Determinant of matrix computed", -4071, determinant, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Invertible_ReturnBooleanTrue() {
        double[][] values = {
            {6, 4, 4, 4},
            {5, 5, 7, 6},
            {4, -9, 3, -7},
            {9, 1, 7, -6}
        };

        Matrix A = Matrix.from(values);
        double determinant = A.determinant();
        assertEquals("Computed determinat of matrix", -2120, determinant, this.EPISILON);

        boolean isInvertible = A.isInvertible();
        assertTrue("Matrix is Invertible", isInvertible);
    }
    
    @Test
    public void test_InstanceMethod_Invertible_ReturnBooleanFalse() {
        double[][] values = {
            {-4, 2, -2, -3},
            {9, 6, 2, 6},
            {0, -5, 1, -5},
            {0, 0, 0, 0}
        };

        Matrix A = Matrix.from(values);
        double determinant = A.determinant();
        assertEquals("Computed determinat of matrix", 0, determinant, this.EPISILON);

        boolean isInvertible = A.isInvertible();
        assertFalse("Matrix is not Invertible", isInvertible);
    }
    

    @Test
    public void test_InstanceMethod_Inverse_ShouldRetrunTheInverseOf4x4MatrixWithCorrectIntermediateSteps() {
        double[][] values = {
            {-5, 2, 6, -8},
            {1, -5, 1, 8},
            {7, 7, -7, -7},
            {1, -3, 7, 4}
        };

        Matrix A = Matrix.from(values);

        Matrix B = A.inverse();

        double ADeterminant = A.determinant();
        assertEquals("Determinat of matrix", 532, ADeterminant, this.EPISILON);

        double ACofactor23 = A.cofactor(2, 3);
        assertEquals("Cofactor 2 3 of matrix", -160, ACofactor23, this.EPISILON);

        double B32 = B.getEntry(3, 2);
        assertEquals("Inverse matrix entry at 3, 2", -0.30075, B32, this.EPISILON); // -160/532

        double ACofactor32 = A.cofactor(3, 2);
        assertEquals("Cofactor 2 3 of matrix", 105, ACofactor32, this.EPISILON);

        double B23 = B.getEntry(2, 3);
        assertEquals("Inverse matrix entry at 2, 3", 0.19737, B23, this.EPISILON); // 105/532

        double[][] BValues = {
            {0.21805, 0.45113, 0.24060, -0.04511},
            {-0.80827, -1.45677, -0.44361, 0.52068},
            {-0.07895, -0.22368, -0.05263, 0.19737},
            {-0.52256, -0.81391, -0.30075, 0.30639}
        };

        verifyMatrix(BValues, 4, 4, B, this.EPISILON);

    }
    
    @Test
    public void test_InstanceMethod_Inverse_ShouldRetrunTheInverseOf4x4Matrix() {
        double[][][][] values = {
            {
                {
                    { 8, -5, 9, 2},
                    { 7, 5, 6, 1},
                    { -6, 0, 9, 6},
                    { -3, 0, -9, -4}
                },
                {
                    { -0.15385, -0.15385, -0.28205, -0.53846 },
                    { -0.07692, 0.12308, 0.02564, 0.03077 },
                    { 0.35897, 0.35897, 0.43590, 0.92308 },
                    { -0.69231, -0.69231, -0.76923, -1.92308 }
                }, 
            },
            {
                {
                    { 9, 3, 0, 9},
                    { -5, -2, -6, -3},
                    { -4, 9, 6, 4},
                    { -7, 6, 6, 2}
                },
                {
                    { -0.04074, -0.07778, 0.14444, -0.22222 },
                    { -0.07778, 0.03333, 0.36667, -0.33333 },
                    { -0.02901, -0.14630, -0.10926, 0.12963 },
                    { 0.17778, 0.06667, -0.26667, 0.33333 }
                }, 
            },
            
        };

        for (int i = 0; i < values.length; i++) {
            double[][] AValues = values[i][0];
            double[][] InverseValues = values[i][1];;

            Matrix A = Matrix.from(AValues);
            Matrix B = A.inverse();
            verifyMatrix(InverseValues, 4, 4, B, this.EPISILON);
        }
        
    }

    @Test
    public void test_InstanceMethod_Inverse_ShouldReverseProductByMultiplicaton() {
        double[][] valuesA = {
            {3, -9, 7, 3},
            {3, -8, 2, -9},
            {-4, 4, 4, 1},
            {-6, 5, -1, 1}
        };

        double[][] valuesB = {
            {8, 2, 2, 2},
            {3, -1, 7, 0},
            {7, 0, 5, 4},
            {6, -2, 0, 5}
        };

        Matrix A = Matrix.from(valuesA);
        Matrix B = Matrix.from(valuesB);

        Matrix C = A.multiply(B); // A * B
        Matrix inverseB = B.inverse(); // B'

        Matrix D = C.multiply(inverseB); // A * B * B'

        boolean dEqualsA = D.equals(A); // A * B * B' = A

        assertTrue("Multiplying Product By inverse reverses product", dEqualsA);
    }
    
}
