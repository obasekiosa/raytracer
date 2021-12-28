package io.github.obasekiosa.raytracer.graphics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class GraphicsTestUtils {
    
    /**
     * 
     * @param expectedR double
     * @param expectedG
     * @param expectedB
     * @param expectedA
     * @param vector3
     * @param delta
     */
    public static void verifyColor(
            double expectedR,
            double expectedG,
            double expectedB,
            double expectedA,
            Color color,
            double delta
            ) {

        assertNotNull("Result object is not null", color);
        assertTrue("Result object is a Vector3", color instanceof Color);
        assertEquals("Result R value is correct", expectedR, color.getRed(), delta);
        assertEquals("Result G value is correct", expectedG, color.getGreen(), delta);
        assertEquals("Result B value is correct", expectedB, color.getBlue(), delta);
        assertEquals("Result A value is correct", expectedA, color.getAlpha(), delta);

    }
}
