package io.github.obasekiosa.raytracer.geometry;

import static io.github.obasekiosa.raytracer.geometry.GeometryTestUtils.verifyPoint3;
import static io.github.obasekiosa.raytracer.geometry.GeometryTestUtils.verifyVector3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.github.obasekiosa.raytracer.basic.Tuple3;

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
    public void test_StaticMethod_From_Tuple3ReturnPoint3() {
        Tuple3 tuple3 = new Tuple3(4.3, -4.2, 3.1, 0.0);
        Vector3 point3 = Vector3.from(tuple3);
        assertTrue(point3 + " object is a Point3", point3 instanceof Tuple3);
    }

    @Test
    public void test_InstanceMethod_Add_TwoVector3AndReturnVector3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Vector3 otherVector3 = new Vector3(5.3, -4.5, -3.3);
        Vector3 result = vector3.add(otherVector3);

        verifyVector3(9.6, -8.7, -0.2, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Add_TwoVector3AndReturnVector3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Vector3 otherVector3 = new Vector3(5.3, -4.5, -3.3);
        Vector3 result = Vector3.add(vector3, otherVector3);

        verifyVector3(9.6, -8.7, -0.2, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Add_Point3ToVector3AndReturnPoint3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Point3 point3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = vector3.add(point3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Add_Vector3ToPoint3AndReturnPoint3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Point3 point3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = Vector3.add(point3, vector3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Add_Point3ToVector3AndReturnPoint3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Point3 point3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = Vector3.add(vector3, point3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Subtract_TwoVector3AndReturnVector3() {
        Vector3 vector3 = new Vector3(3, 2, 1);
        Vector3 otheVector3 = new Vector3(5, 6, 7);
        Vector3 result = Vector3.subtract(vector3, otheVector3);

        verifyVector3(-2, -4, -6, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Subtract_TwoVector3AndReturnVector3() {
        Vector3 vector3 = new Vector3(3, 2, 1);
        Vector3 otheVector3 = new Vector3(5, 6, 7);
        Vector3 result = vector3.subtract(otheVector3);

        verifyVector3(-2, -4, -6, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Subtract_Vector3FromPoint3AndReturnPoint3() {
        Point3 point3 = new Point3(3, 2, 1);
        Vector3 vector3 = new Vector3(5, 6, 7);
        Point3 result = Vector3.subtract(point3, vector3);

        verifyPoint3(-2, -4, -6, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Zero_ReturnVetor3AllZero() {
        Vector3 result = Vector3.zero();
        verifyVector3(0, 0, 0, 0.0, result, 0);
    }

    @Test 
    public void test_StaticMethod_Subtract_NonZeroVector3FromZeroVector3ReturnVector3() {
        Vector3 zero = Vector3.zero();
        Vector3 vector3 = new Vector3(1, -2, 3);
        Vector3 result = Vector3.subtract(zero, vector3);

        verifyVector3(-1, 2, -3, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Negate_ReturnVector3() {
        Vector3 vector3 = new Vector3(1, -2, 3);
        Vector3 result = vector3.negate();

        verifyVector3(-1, 2, -3, 0.0, result, 0);
    }

    @Test
    public void test_StaticMethod_Negate_Vetor3ReturnVector3() {
        Vector3 vector3 = new Vector3(1, -2, 3);
        Vector3 result = Vector3.negate(vector3);

        verifyVector3(-1, 2, -3, 0.0, result, 0);
    }

    @Test
    public void test_InstanceMethod_Multiply_Point3ByDoubleReturnVector3() {
        Vector3 point3 = new Vector3(1, -2, 3);
        double scalar = 3.5;
        Vector3 result = point3.multiply(scalar);

        verifyVector3(3.5, -7, 10.5, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Multiply_DoubleReturnVector3() {
        Vector3 vector3 = new Vector3(1, -2, 3);
        double scalar = 3.5;
        Vector3 result = Vector3.multiply(vector3, scalar);

        verifyVector3(3.5, -7, 10.5, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Divide_Point3ByDoubleReturnVector3() {
        Vector3 vector3 = new Vector3(1, -2, 3);
        double scalar = 2;
        Vector3 result = vector3.divide(scalar);

        verifyVector3(0.5, -1, 1.5, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Divide_DoubleReturnVector3() {
        Vector3 vector3 = new Vector3(1, -2, 3);
        double scalar = 2;
        Vector3 result = Vector3.divide(vector3, scalar);

        verifyVector3(0.5, -1, 1.5, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Magnitude_Vector3ReturnDouble() {

        double[][] values = {
            {1, 0 , 0, 1},
            {0, 1 , 0, 1},
            {0, 0 , 1, 1},
            {1, 2 , 3, 3.741657386773941},
            {-1, -2 , -3, 3.741657386773941},
        };

        for (double[] testCase : values) {
            Vector3 vector3 = new Vector3(testCase[0], testCase[1], testCase[2]);
            double result = Vector3.magnitude(vector3);

            assertEquals("Magnitude of " + vector3 + " is", testCase[3], result, this.EPISILON);
        }
    }

    @Test
    public void test_InstanceMethod_Magnitude_ReturnDouble() {
        double[][] values = {
                { 1, 0, 0, 1 },
                { 0, 1, 0, 1 },
                { 0, 0, 1, 1 },
                { 1, 2, 3, 3.741657386773941 },
                { -1, -2, -3, 3.741657386773941 },
        };

        for (double[] testCase : values) {
            Vector3 vector3 = new Vector3(testCase[0], testCase[1], testCase[2]);
            double result = vector3.magnitude();

            assertEquals("Magnitude of " + vector3 + " is", testCase[3], result, this.EPISILON);
        }
    }

    @Test
    public void test_StaticMethod_Normalize_Vector3RetunVector3() {
        double[][][] values = {
            {{4, 0, 0}, {1, 0, 0}},
            {{1, 2, 3}, {0.26726, 0.53452, 0.80178}}
        };

        for (double[][] testCase : values) {
            double[] test = testCase[0];
            double[] expected = testCase[1];
            Vector3 vector3 = new Vector3(test[0], test[1], test[2]);
            Vector3 result = Vector3.normalize(vector3);

            verifyVector3(expected[0], expected[1], expected[2], 0, result, this.EPISILON);
        }
    }


    @Test
    public void test_InstanceMethod_Normalize_Vector3RetunVector3() {
        double[][][] values = {
                { { 4, 0, 0 }, { 1, 0, 0 } },
                { { 1, 2, 3 }, { 0.26726, 0.53452, 0.80178 } }
        };

        for (double[][] testCase : values) {
            double[] test = testCase[0];
            double[] expected = testCase[1];
            Vector3 vector3 = new Vector3(test[0], test[1], test[2]);
            Vector3 result = vector3.normalize();

            verifyVector3(expected[0], expected[1], expected[2], 0, result, this.EPISILON);
        }
    }



    @Test
    public void test_StaticMethod_Normalize_ResultMagnitudeIsOne() {
        double[][][] values = {
                { { 4, 0, 0 }, { 1, 0, 0 } },
                { { 1, 2, 3 }, { 0.26726, 0.53452, 0.80178 } }
        };

        for (double[][] testCase : values) {
            double[] test = testCase[0];
            double[] expected = testCase[1];
            Vector3 vector3 = new Vector3(test[0], test[1], test[2]);
            Vector3 result = Vector3.normalize(vector3);

            verifyVector3(expected[0], expected[1], expected[2], 0, result, this.EPISILON);

            assertEquals("Magnitude of normalized " + vector3 + " is", 1, result.magnitude(), this.EPISILON);
        }
    }

    @Test
    public void test_InstanceMethod_Normalize_ResultMagnitudeIsOne() {
        double[][][] values = {
                { { 4, 0, 0 }, { 1, 0, 0 } },
                { { 1, 2, 3 }, { 0.26726, 0.53452, 0.80178 } }
        };

        for (double[][] testCase : values) {
            double[] test = testCase[0];
            double[] expected = testCase[1];
            Vector3 vector3 = new Vector3(test[0], test[1], test[2]);
            Vector3 result = vector3.normalize();

            verifyVector3(expected[0], expected[1], expected[2], 0, result, this.EPISILON);

            assertEquals("Magnitude of normalized " + vector3 + " is", 1, result.magnitude(), this.EPISILON);
        }
    }

    @Test
    public void test_StaticMethod_DotProduct_TwoVector3ReturnDouble() {
        double[][][] values = {
                { { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 0, 1, 0, 0 } } // value, test the first with itself and the others,
                                                                   // the forth entry is the expected result
        };

        for (double[][] testCase : values) {
            double[] test = testCase[0];
            Vector3 first = new Vector3(test[0], test[1], test[2]);
            for (double[] expected : testCase) {
                Vector3 second = new Vector3(expected[0], expected[1], expected[2]);
                double result = Vector3.dotProduct(first, second);
                double reverse = Vector3.dotProduct(second, first);

                assertEquals(first + " dot " + second + " is ", expected[3], result, this.EPISILON);

                assertEquals(second + " dot " + first + " is ", expected[3], reverse, this.EPISILON);
            }
        }
    }

    @Test
    public void test_InstanceMethod_DotProduct_Vector3ReturnDouble() {
        double[][][] values = {
            {{1, 0, 0, 1}, {1, 0, 0, 1}, {0, 1, 0, 0}} // value, test the first with itself and the others, the forth entry is the expected result
        };

        for (double[][] testCase : values) {
            double[] test = testCase[0];
            Vector3 first = new Vector3(test[0], test[1], test[2]);
            for(double[] expected : testCase) {
                Vector3 second = new Vector3(expected[0], expected[1], expected[2]);
                double result = first.dotProduct(second);
                double reverse = second.dotProduct(first);
                
                assertEquals(first + " dot " + second + " is ", expected[3], result, this.EPISILON);
                
                assertEquals(second + " dot " + first + " is ", expected[3], reverse, this.EPISILON);
            }
        }
    }


    @Test
    public void test_StaticMethod_CrossProduct_TwoVector3ReturnVector3() {
        double[][][] values = {
            {{1, 2, 3}, {2, 3, 4}, {-1, 2, -1}} // a, b, a x b in that order
        };

        for (double[][] testCase : values) {
            double[] aValues = testCase[0];
            double[] bValues = testCase[1];
            double[] axbValues = testCase[2];

            Vector3 a = new Vector3(aValues[0], aValues[1], aValues[2]);
            Vector3 b = new Vector3(bValues[0], bValues[1], bValues[2]);

            Vector3 result = Vector3.crossProduct(a, b);
            verifyVector3(axbValues[0], axbValues[1], axbValues[2], 0.0, result, this.EPISILON);

            Vector3 reverse = Vector3.crossProduct(b, a);
            verifyVector3(-axbValues[0], -axbValues[1], -axbValues[2], 0.0, reverse, this.EPISILON);
        }
    }

    @Test
    public void test_InstanceMethod_CrossProduct_Vector3ReturnVector3() {
        double[][][] values = {
            {{1, 2, 3}, {2, 3, 4}, {-1, 2, -1}} // a, b, a x b in that order
        };

        for (double[][] testCase : values) {
            double[] aValues = testCase[0];
            double[] bValues = testCase[1];
            double[] axbValues = testCase[2];

            Vector3 a = new Vector3(aValues[0], aValues[1], aValues[2]);
            Vector3 b = new Vector3(bValues[0], bValues[1], bValues[2]);

            Vector3 result = a.crossProduct(b);
            verifyVector3(axbValues[0], axbValues[1], axbValues[2], 0.0, result, this.EPISILON);

            Vector3 reverse = b.crossProduct(a);
            verifyVector3(-axbValues[0], -axbValues[1], -axbValues[2], 0.0, reverse, this.EPISILON);
        }
    }
}
