package io.github.obasekiosa.raytracer.graphics;

import io.github.obasekiosa.raytracer.exceptions.UnImplementedMethodException;

public class Canvas {

    private int width;
    private int height;

    public Canvas(int width, int height) {
        throw new UnImplementedMethodException();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color pixelAt(int x, int y) {
        throw new UnImplementedMethodException();
    }

    public void writePixel(int x, int y, Color c) {
        throw new UnImplementedMethodException();
    }
    
}
