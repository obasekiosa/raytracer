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
        Color color = new Color(0.5, 0.4, 1.7);

        verifyColor(0.5, 0.4, 1.7, 1.0, color, this.EPISILON);
    }

    @Test
    public void test_InstanceMethod_4ArgConstructor_CreatesAndReturnsColor() {
        Color color = new Color(0.5, 0.4, 1.7, 0.3);

        verifyColor(0.5, 0.4, 1.7, 0.3, color, this.EPISILON);
    }
}
