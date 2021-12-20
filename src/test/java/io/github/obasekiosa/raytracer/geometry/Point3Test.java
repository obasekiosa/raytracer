package io.github.obasekiosa.raytracer.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import static io.github.obasekiosa.raytracer.geometry.TestUtils.verifyPoint3;
import static io.github.obasekiosa.raytracer.geometry.TestUtils.verifyVector3;

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
    public void test_InstanceMethod_Add_TwoPoint3AndReturnNewPoint3Instance() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        Point3 otherPoint3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = point3.add(otherPoint3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Add_TwoPoint3AndReturnNewPoint3Instance() {
        Point3 point3 = new Point3(4.3, -4.2, 3.1);
        Point3 otherPoint3 = new Point3(5.3, -4.5, -3.3);
        Point3 result = Point3.add(point3, otherPoint3);

        verifyPoint3(9.6, -8.7, -0.2, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Subtract_TwoPoint3AndReturnNewVector3Instance() {
        Point3 point3 = new Point3(3, 2, 1);
        Point3 otherPoint3 = new Point3(5, 6, 7);
        Vector3 result = point3.subtract(otherPoint3);

        verifyVector3(-2, -4, -6, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Subtract_TwoPoint3AndReturnNewVector3Instance() {
        Point3 point3 = new Point3(3, 2, 1);
        Point3 otherPoint3 = new Point3(5, 6, 7);
        Vector3 result = Point3.subtract(point3, otherPoint3);

        verifyVector3(-2, -4, -6, 0.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Subtract_Vector3FromPoint3AndReturnNewPoint3Instance() {
        Point3 point3 = new Point3(3, 2, 1);
        Vector3 vector3  = new Vector3(5, 6, 7);
        Point3 result = point3.subtract(vector3);

        verifyPoint3(-2, -4, -6, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Subtract_Vector3FromPoint3AndReturnNewPoint3Instance() {
        Point3 point3 = new Point3(3, 2, 1);
        Vector3 vector3  = new Vector3(5, 6, 7);
        Point3 result = Point3.subtract(point3, vector3);

        verifyPoint3(-2, -4, -6, 1.0, result, this.EPISILON);
    }


    
}
