package io.github.obasekiosa.raytracer.graphics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

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
        assertTrue("Pixel was written onto the canvas", result);
    }


    @Test
    public void test_InstanceMethod_ToPPM_PathCreatePPMFileWithHeader() {
        Canvas canvas = new Canvas(5, 3);
        String name = "ppmfile";
        canvas.toPPM(name);

        List<String> ppmFile = null;
        try {
            ppmFile = Files.readAllLines(Paths.get(name + ".ppm"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull("Read file", ppmFile);

        assertTrue("Contains at least 3 lines", ppmFile.size() >= 3);

        assertEquals("First line matches", "P3", ppmFile.get(0));
        assertEquals("Second line matches", "5 3", ppmFile.get(1));
        assertEquals("Third line matches", "255", ppmFile.get(2));

        cleanFile(name + ".ppm");
        
    }

    @Test
    public void test_InstanceMethod_ToPPM_PathCreatePPMFileWithContent() {
        Canvas canvas = new Canvas(5, 3);
        Color color1 = new Color(1.5, 0, 0);
        Color color2 = new Color(0, 0.5, 0);
        Color color3 = new Color(-0.5, 0, 1);


        canvas.writePixel(0, 0, color1);
        canvas.writePixel(2, 1, color2);
        canvas.writePixel(4, 2, color3);

        String name = "ppmfile";
        canvas.toPPM(name);

        List<String> ppmFile = null;
        try {
            ppmFile = Files.readAllLines(Paths.get(name + ".ppm"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull("Read file", ppmFile);

        assertTrue("Contains 6 lines", ppmFile.size() == 6);

        assertEquals("Fourth line matches", "255 0 0 0 0 0 0 0 0 0 0 0 0 0 0", ppmFile.get(3));
        assertEquals("Fifth line matches", "0 0 0 0 0 0 0 128 0 0 0 0 0 0 0", ppmFile.get(4));
        assertEquals("Sixth line matches", "0 0 0 0 0 0 0 0 0 0 0 0 0 0 255", ppmFile.get(5));

        cleanFile(name + ".ppm");
        
    }

    @Test
    public void test_InstanceMethod_ToPPM_SplitLongLinesInPPMFile() {
        Canvas canvas = new Canvas(10, 2);
        
        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                canvas.writePixel(j, i, new Color(1, 0.8, 0.6));
            }
        }

        String name = "ppmfile";
        canvas.toPPM(name);

        List<String> ppmFile = null;
        try {
            ppmFile = Files.readAllLines(Paths.get(name + ".ppm"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull("Read file", ppmFile);

        assertTrue("Contains 7 lines", ppmFile.size() == 7);

        assertEquals("Fourth line matches", "255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204", ppmFile.get(3));
        assertEquals("Fifth line matches", "153 255 204 153 255 204 153 255 204 153 255 204 153", ppmFile.get(4));
        assertEquals("Sixth line matches", "255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204", ppmFile.get(5));
        assertEquals("Seventh line matches", "153 255 204 153 255 204 153 255 204 153 255 204 153", ppmFile.get(6));

        
        cleanFile(name + ".ppm");
        
    }

    @Test
    public void test_InstanceMethod_ToPPM_EndsWithNewLineCharacter() {
        Canvas canvas = new Canvas(5, 3);

        String name = "ppmfile";
        canvas.toPPM(name);

        try {
            RandomAccessFile file = new RandomAccessFile(Paths.get("name"+".ppm").toFile(), "r");
            long fileLength = file.length() - 1;
            assertTrue("File is not empty", fileLength - 1 >= 0);

            file.seek(fileLength);

            byte lastByte = file.readByte();
            file.close();

            assertTrue("Last character in file is new line", lastByte == 0xA || lastByte == 0xD );
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        cleanFile(name + ".ppm");
        
    }

    private void cleanFile(String name) {
        try {
            Files.delete(Paths.get(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
