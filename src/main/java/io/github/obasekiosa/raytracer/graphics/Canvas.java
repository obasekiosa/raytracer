package io.github.obasekiosa.raytracer.graphics;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import io.github.obasekiosa.raytracer.exceptions.UnImplementedMethodException;

public class Canvas {

    private final Color[][] canvas;

    private final int LINE_MAX_LENGTH = 70;

    public Canvas(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and Height must be > 0");
        }
        this.canvas = new Color[height][width];

        for(int i = 0; i < this.canvas.length; i++)
            for(int j = 0; j < this.canvas[0].length; j++)
                this.canvas[i][j] = new Color(0, 0, 0);
    }

    public int getWidth() {
        return this.canvas[0].length;
    }


    public int getHeight() {
        return this.canvas.length;
    }

    public Color pixelAt(int x, int y) {
        if (x < 0 || x >= this.canvas[0].length || y < 0 || y >= this.canvas.length) {
            throw new IllegalArgumentException("x and y must be between the boundries of the canvas");
        }

        Color pixel = this.canvas[y][x];
        return new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue(), pixel.getAlpha());
    }

    public void writePixel(int x, int y, Color c) {
        if (x < 0 || x >= this.canvas[0].length || y < 0 || y >= this.canvas.length) {
            throw new IllegalArgumentException("x and y must be between the boundries of the canvas");
        }

        this.canvas[y][x] = c;
    }

    public Color[][] getPixels() {
        Color[][] result = new Color[this.canvas.length][this.canvas[0].length];

        for (int i = 0; i < result.length; i++)
            for(int j = 0; j < result[0].length; j++)
                result[i][j] = this.pixelAt(j, i);
            
        return result;
    }


    public void toPPM() {
        toPPM(null);
    }


    public void toPPM(String name) {

        if (name == null) {
            name = "output";
        }
        
        File file = null;

        try {
            file = new File(name + ".ppm");
            file.createNewFile();
            boolean fileExists = file.exists();

            if (!fileExists) {
                throw new IOException("File could not be created");
            }

            StringBuilder sBuilder = new StringBuilder();

            // write header
            sBuilder.append("P3");
            sBuilder.append(System.lineSeparator());
            sBuilder.append(this.getWidth() + " " + this.getHeight());
            sBuilder.append(System.lineSeparator());
            sBuilder.append("255");
            sBuilder.append(System.lineSeparator());

            // write content
            for (int i = 0; i < this.canvas.length; i++) {

                StringBuilder line = new StringBuilder();
                for (int j = 0; j < this.canvas[0].length; j++) {
                    Color pixel = this.canvas[i][j];
                    int r = Math.min(255, Math.max(0, (int) Math.ceil(pixel.getRed() * 255)));
                    int g = Math.min(255, Math.max(0, (int) Math.ceil(pixel.getGreen() * 255)));
                    int b = Math.min(255, Math.max(0, (int) Math.ceil(pixel.getBlue() * 255)));

                    line = addChannel(sBuilder, line, r);
                    line.append(" ");
                    line = addChannel(sBuilder, line, g);
                    line.append(" ");
                    line = addChannel(sBuilder, line, b);
                    if (j != this.canvas[0].length - 1) {
                        line.append(" ");
                    }
                        
                }

                if (line.length() > 0) {
                    sBuilder.append(line.toString());
                }
                sBuilder.append(System.lineSeparator());
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.append(sBuilder.toString());
            bw.close();

        } catch (IOException e) {
            if (file != null) {
                file.delete();
            }
            e.printStackTrace();
            System.out.println("Error: Could not create file");
        }
    }

    /**
     * Adds the string representation of value to line and returns line if the total length of line would be 
     * <= LINE_MAX_LENGTH otherwise it removes the last charater of line if it is a white space, creates a 
     * new line and adds the string representation of value to the new StringBuilder and returns it
     * @param sBuilder StringBuilder
     * @param line StringBuilder
     * @param value int
     * @return StringBuilder
     */
    private StringBuilder addChannel(StringBuilder sBuilder, StringBuilder line, int value) {
        String valueStr = String.valueOf(value);
        if ((line.length() + valueStr.length()) > LINE_MAX_LENGTH) {

            line.deleteCharAt(line.length() - 1);
            line.append(System.lineSeparator());

            sBuilder.append(line.toString());
            line = new StringBuilder();

        }
        line.append(valueStr);
        return line;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Canvas [canvas= \n");

        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                sb.append("(x=")
                    .append(i)
                    .append(", y=")
                    .append(j)
                    .append(") -> ")
                    .append(this.canvas[i][j])
                    .append("\t");
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
    
}
