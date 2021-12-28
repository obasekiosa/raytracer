package io.github.obasekiosa.raytracer.graphics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CanvasTest {

    
    @Test
    public void test_InstanceMethod_Constructor_ReturnCanvas() {
        Canvas canvas = new Canvas(10, 20);

        assertTrue("Is instance of Canvas", canvas instanceof Canvas);
        assertEquals("Width of Canvas is ", 10, canvas.getWidth());
        assertEquals("Height of Canvas is ", 20, canvas.getHeight());

        Color zero = new Color(0, 0, 0);
        for (Color[] row : canvas.getPixels())
            for (Color c : row) assertTrue("Pixel is Zero", c.equals(zero));
    }

    @Test
    public void test_Behaviour_Write_And_Read_Pixel() {
        Canvas canvas = new Canvas(10, 20);
        Color red = new Color(1, 0, 0);

        canvas.writePixel(2, 3, red);
        boolean result =  red.equals(canvas.pixelAt(2, 3));
        assertEquals("Pixel was written onto the canvas", result);
    }


    
}
