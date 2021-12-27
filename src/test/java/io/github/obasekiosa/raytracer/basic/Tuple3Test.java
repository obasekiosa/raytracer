package io.github.obasekiosa.raytracer.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import static io.github.obasekiosa.raytracer.TestUtils.verifyTuple3;;

public class Tuple3Test {
    public double EPISILON;

    @Before
    public void setUp() {
        this.EPISILON = 1e-4;
    }

    @Test
    public void test_InstanceMethod_Add_Tuple3ReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(3, -2, 5, 1);
        Tuple3 otherTuple3 = new Tuple3(-2, 3, 1, 0);
        Tuple3 result = tuple3.add(otherTuple3);

        verifyTuple3(1, 1, 6, 1, result, this.EPISILON);

    }

    @Test
    public void test_StaticMethod_Add_TwoTuple3ReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(3, -2, 5, 1);
        Tuple3 otherTuple3 = new Tuple3(-2, 3, 1, 0);
        Tuple3 result = Tuple3.add(tuple3, otherTuple3);

        verifyTuple3(1, 1, 6, 1, result, this.EPISILON);

    }

    @Test
    public void test_InstanceMethod_Subtract_Tuple3ReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(3, 2, 1, 4);
        Tuple3 otherTuple3 = new Tuple3(5, 6, 7, 1);
        Tuple3 result = tuple3.subtract(otherTuple3);

        verifyTuple3(-2, -4, -6, 3, result, this.EPISILON);

    }

    @Test
    public void test_StaticMethod_Subtract_TwoTuple3ReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(3, 2, 1, 4);
        Tuple3 otherTuple3 = new Tuple3(5, 6, 7, 1);
        Tuple3 result = Tuple3.subtract(tuple3, otherTuple3);

        verifyTuple3(-2, -4, -6, 3, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Zero_ReturnTuple3AllZero() {
        Tuple3 result = Tuple3.zero();

        verifyTuple3(0, 0, 0, 0, result, 0);
    }

    @Test
    public void test_StaticMethod_Subtract_NonZeroTuple3FromZeroTuple3ReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(1, -2, 3, -4);
        Tuple3 zero = Tuple3.zero();
        Tuple3 result = Tuple3.subtract(zero, tuple3);

        verifyTuple3(-1, 2, -3, 4, result, this.EPISILON);
    }

    @Test 
    public void test_InstanceMethod_Negate_ReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(1, -2, 3, -4);
        Tuple3 result = tuple3.negate();

        verifyTuple3(-1, 2, -3, 4, result, 0);
    }

    @Test 
    public void test_StaticMethod_Negate_Tuple3ReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(1, -2, 3, -4);
        Tuple3 result = Tuple3.negate(tuple3);

        verifyTuple3(-1, 2, -3, 4, result, 0);
    }

    @Test
    public void test_InstanceMethod_Multiply_Tuple3ByDoubleReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(1, -2, 3, -4);
        double scalar = 3.5;
        Tuple3 result = tuple3.multiply(scalar);

        verifyTuple3(3.5, -7, 10.5, -14, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Multiply_DoubleReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(1, -2, 3, -4);
        double scalar = 3.5;
        Tuple3 result = Tuple3.multiply(tuple3, scalar);

        verifyTuple3(3.5, -7, 10.5, -14, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Divide_Tuple3ByDoubleReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(1, -2, 3, -4);
        double scalar = 2;
        Tuple3 result = tuple3.divide(scalar);

        verifyTuple3(0.5, -1, 1.5, -2, result, this.EPISILON);
    }

    @Test
    public void test_StaticMethod_Divide_DoubleReturnTuple3() {
        Tuple3 tuple3 = new Tuple3(1, -2, 3, -4);
        double scalar = 2;
        Tuple3 result = Tuple3.divide(tuple3, scalar);

        verifyTuple3(0.5, -1, 1.5, -2, result, this.EPISILON);
    }
}
