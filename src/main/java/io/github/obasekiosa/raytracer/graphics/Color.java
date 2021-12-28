package io.github.obasekiosa.raytracer.graphics;

import io.github.obasekiosa.raytracer.basic.Tuple3;

public class Color extends Tuple3 {

    
    public Color(double r, double g, double b, double a) {
        super(r, g, b, a);
    }

    public Color(double r, double g, double b) {
        this(r, g, b, 1.0);
    }

    public double getRed() {
        return this.x1;
    }

    public void setRed(double r) {
        this.x1 = r;
    }
    
    public double getGreen() {
        return this.x2;
    }

    public void setGreen(double g) {
        this.x2 = g;
    }
    
    public double getBlue() {
        return this.x3;
    }

    public void setBlue(double b) {
        this.x3 = b;
    }
    
    public double getAlpha() {
        return this.x4;
    }

    public void setAlpha(double a) {
        this.x4 = a;
    }
    
}
