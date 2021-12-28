package io.github.obasekiosa.raytracer.graphics;

import java.util.Arrays;

public class Canvas {

    private final Color[][] canvas;

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
