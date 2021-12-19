package io.github.obasekiosa.raytracer.geometry;

import io.github.obasekiosa.raytracer.basic.Tuple3;

public class Vector3 extends Tuple3 {

    public Vector3(double x, double y, double z) {
        this.x1 = x;
        this.x2 = y;
        this.x3 = z;
        this.x4 = 0.0;
    }

    public void setX(double x) {
        this.x1 = x;
    }

    public double getX() {
        return this.x1;
    }

    public void setY(double y) {
        this.x2 = y;
    }

    public double getY() {
        return this.x2;
    }

    public void setZ(double z) {
        this.x3 = z;
    }

    public double getZ() {
        return this.x3;
    }

    public void setW(double w) {
        this.x4 = w;
    }

    public double getW() {
        return this.x4;
    }

    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(this.getX() + other.getX(), this.getY() + other.getY(), this.getZ() + other.getZ());
    }

    @Override
    public String toString() {
        return "Vector3 [ x=" + getX() + ", y=" + getY() + ", z=" + getW() + "]";
    }
    
}
