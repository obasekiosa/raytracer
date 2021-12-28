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
        return this.getX1();
    }

    public void setRed(double r) {
        this.setX1(r);
    }
    
    public double getGreen() {
        return this.getX2();
    }

    public void setGreen(double g) {
        this.setX2(g);
    }
    
    public double getBlue() {
        return this.getX3();
    }

    public void setBlue(double b) {
        this.setX3(b);
    }
    
    public double getAlpha() {
        return this.getX4();
    }

    public void setAlpha(double a) {
        this.setX4(a);
    }
    
    public static Color add(Color a, Color b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments can not be null");
        }
        return new Color(a.getRed() + b.getRed(), a.getGreen() + b.getGreen(), a.getBlue() + b.getBlue());
    }

    public Color add(Color color) {
        return Color.add(this, color);
    
    }
    
    public static Color subtract(Color a, Color b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments can not be null");
        }
        return new Color(a.getRed() - b.getRed(), a.getGreen() - b.getGreen(), a.getBlue() - b.getBlue());
    }

    public Color subtract(Color color) {
        return Color.subtract(this, color);
    }

    public static Color multiply(Color a, Color b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments can not be null");
        }
        return new Color(a.getRed() * b.getRed(), a.getGreen() * b.getGreen(), a.getBlue() * b.getBlue());
    }

    public Color multiply(Color color) {
        return Color.multiply(this, color);
    }

    public static Color multiply(Color color, double scalar) {
        if (color == null) {
            throw new IllegalArgumentException("Arguments can not be null");
        }
        return new Color(color.getRed() * scalar, color.getGreen() * scalar, color.getBlue() * scalar);
    }

    public Color multiply(double scalar) {
        return Color.multiply(this, scalar);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Color other = (Color) obj;

        if (Math.abs(this.getRed() - other.getRed()) > this.EPSILON) return false;
        if (Math.abs(this.getGreen() - other.getGreen()) > this.EPSILON) return false;
        if (Math.abs(this.getBlue() - other.getBlue()) > this.EPSILON) return false;
        if (Math.abs(this.getAlpha() - other.getAlpha()) > this.EPSILON) return false;

        return true;
    }

    


}
