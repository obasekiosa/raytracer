package io.github.obasekiosa.raytracer.geometry;

import static io.github.obasekiosa.raytracer.TestUtils.verifyPoint3;
import static io.github.obasekiosa.raytracer.TestUtils.verifyVector3;
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
    public void test_InstanceMethod_Negate_Vetor3ReturnVector3() {
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
    
}
