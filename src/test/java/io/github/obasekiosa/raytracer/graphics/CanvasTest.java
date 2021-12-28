package io.github.obasekiosa.raytracer.graphics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CanvasTest {

    
    @Test
    public void test_InstanceMethod_Constructor_ReturnCanvas() {
        Canvas canvas = new Canvas(10, 20);

        assertEquals("Width of Canvas is ", 10, canvas.getWidth());
        assertEquals("Height of Canvas is ", 20, canvas.getHeight());
    }
    
}
