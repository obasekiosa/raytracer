package io.github.obasekiosa.raytracer.graphics;

import org.junit.Before;
import org.junit.Test;

import static io.github.obasekiosa.raytracer.graphics.GraphicsTestUtils.verifyColor;

public class ColorTest {

    private double EPISILON;

    @Before
    public void setUp() {
            this.EPISILON = 1E-4;
    }
    

    @Test
    public void test_InstanceMethod_3ArgConstructor_CreatesAndReturnsColor() {
        Color color = new Color(-0.5, 0.4, 1.7);

        verifyColor(-0.5, 0.4, 1.7, 1.0, color, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_4ArgConstructor_CreatesAndReturnsColor() {
        Color color = new Color(-0.5, 0.4, 1.7, 0.3);

        verifyColor(-0.5, 0.4, 1.7, 0.3, color, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Add_ColorReturnColor() {
        Color color = new Color(0.9, 0.6, 0.75);
        Color otherColor = new Color(0.7, 0.1, 0.25);

        Color result = color.add(otherColor);
        verifyColor(1.6, 0.7, 1.0, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Subtract_ColorReturnColor() {
        Color color = new Color(0.9, 0.6, 0.75);
        Color otherColor = new Color(0.7, 0.1, 0.25);

        Color result = color.subtract(otherColor);
        verifyColor(0.2, 0.5, 0.5, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Multiply_DoubleReturnColor() {
        Color color = new Color(0.2, 0.3, 0.4);
        double scalar = 2;

        Color result = color.multiply(scalar);
        verifyColor(0.4, 0.6, 0.8, 1.0, result, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_Multiply_ColorReturnColor() {
        Color color = new Color(1, 0.2, 0.4);
        Color otherColor = new Color(0.9, 1, 0.1);

        Color result = color.multiply(otherColor);
        verifyColor(0.9, 0.2, 0.04, 1.0, result, this.EPISILON);
    }
}
