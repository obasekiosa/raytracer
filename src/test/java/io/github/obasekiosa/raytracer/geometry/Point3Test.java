package io.github.obasekiosa.raytracer.geometry;

import static io.github.obasekiosa.raytracer.geometry.GeometryTestUtils.verifyPoint3;
import static io.github.obasekiosa.raytracer.geometry.GeometryTestUtils.verifyVector3;
import static org.junit.Assert.assertEquals;
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
    public void test_StaticMethod_From_Tuple3ReturnPoint3() {
        Tuple3 tuple3 = new Tuple3(4.3, -4.2, 3.1, 1.0);
        Point3 point3 = Point3.from(tuple3);
        assertTrue(point3 + " object is a Point3", point3 instanceof Tuple3);
    }

    @Test
    public void test_InstanceMethod_Add_TwoPoint3AndReturnPoint3() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        Point3 otherPoint3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = point3.add(otherPoint3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Add_TwoPoint3AndReturnPoint3() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        Point3 otherPoint3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = Point3.add(point3, otherPoint3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Add_Vector3ToPoint3AndReturnPoint3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Point3 point3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = point3.add(vector3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Add_Vector3ToPoint3AndReturnPoint3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Point3 point3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = Point3.add(point3, vector3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Add_Point3ToVector3AndReturnPoint3() {
        Vector3 vector3 = new Vector3(4.3, -4.2, 3.1);
        Point3 point3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = Point3.add(vector3, point3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }


    @Test
    public void test_InstanceMethod_Subtract_TwoPoint3AndReturnVector3() {
        Point3 point3 = new Point3(3, 2, 1);
        Point3 otherPoint3 = new Point3(5, 6, 7);
        Vector3 result = point3.subtract(otherPoint3);

        verifyVector3(-2, -4, -6, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Subtract_TwoPoint3AndReturnVector3() {
        Point3 point3 = new Point3(3, 2, 1);
        Point3 otherPoint3 = new Point3(5, 6, 7);
        Vector3 result = Point3.subtract(point3, otherPoint3);

        verifyVector3(-2, -4, -6, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Subtract_Vector3FromPoint3AndReturnPoint3() {
        Point3 point3 = new Point3(3, 2, 1);
        Vector3 vector3  = new Vector3(5, 6, 7);
        Point3 result = point3.subtract(vector3);

        verifyPoint3(-2, -4, -6, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Subtract_Vector3FromPoint3AndReturnPoint3() {
        Point3 point3 = new Point3(3, 2, 1);
        Vector3 vector3  = new Vector3(5, 6, 7);
        Point3 result = Point3.subtract(point3, vector3);

        verifyPoint3(-2, -4, -6, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Zero_ReturnPoint3AllZero() {
        Point3 result = Point3.zero();

        verifyPoint3(0, 0, 0, 1.0, result, 0);
    }

    @Test
    public void test_InstanceMethod_Negate_ReturnPoint3() {
        Point3 point3 = new Point3(1, -2, 3);
        Point3 result = point3.negate();

        verifyPoint3(-1, 2, -3, 1.0, result, 0);
    }

    @Test
    public void test_StaticMethod_Negate_Point3ReturnPoint3() {
        Point3 point3 = new Point3(1, -2, 3);
        Point3 result = Point3.negate(point3);

        verifyPoint3(-1, 2, -3, 1.0, result, 0);
    }

    @Test
    public void test_InstanceMethod_Multiply_Point3ByDoubleReturnPoint3() {
        Point3 point3 = new Point3(1, -2, 3);
        double scalar = 3.5;
        Point3 result = point3.multiply(scalar);

        verifyPoint3(3.5, -7, 10.5, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Multiply_DoubleReturnPoint3() {
        Point3 point3 = new Point3(1, -2, 3);
        double scalar = 3.5;
        Point3 result = Point3.multiply(point3, scalar);

        verifyPoint3(3.5, -7, 10.5, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Divide_Point3ByDoubleReturnPoint3() {
        Point3 point3 = new Point3(1, -2, 3);
        double scalar = 2;
        Point3 result = point3.divide(scalar);

        verifyPoint3(0.5, -1, 1.5, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Divide_DoubleReturnPoint3() {
        Point3 point3 = new Point3(1, -2, 3);
        double scalar = 2;
        Point3 result = Point3.divide(point3, scalar);

        verifyPoint3(0.5, -1, 1.5, 1.0, result, this.EPISILON);
    }

}
