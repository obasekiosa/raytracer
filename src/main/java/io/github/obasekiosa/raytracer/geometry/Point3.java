package io.github.obasekiosa.raytracer.geometry;

import io.github.obasekiosa.raytracer.basic.Tuple3;

public class Point3 extends Tuple3 {


    public Point3(double x, double y, double z) {
        this.x1 = x;
        this.x2 = y;
        this.x3 = z;
        this.x4 = 1.0;
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

    public Point3 add(Point3 other) {
        return new Point3(this.getX() + other.getX(), this.getY() + other.getY(), this.getZ() + other.getZ());
    }

    public Point3 add(Vector3 vector3) {
        return new Point3(this.getX() + vector3.getX(), this.getY() + vector3.getY(), this.getZ() + vector3.getZ());
    }

    public static Point3 add(Point3 a, Point3 b) {
        return new Point3(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    public static Point3 add(Point3 point3, Vector3 vector3) {
        return new Point3(point3.getX() + vector3.getX(), point3.getY() + vector3.getY(), point3.getZ() + vector3.getZ())
    }

    public static Point3 add(Vector3 vector3, Point3 point3) {
        return new Point3(vector3.getX() + point3.getX(), vector3.getY() + point3.getY(), vector3.getZ() + point3.getZ())
    }

    public Vector3 subtract(Point3 other) {
        throw new UnsupportedOperationException("This method has not been Implemented");
    }

    public Point3 subtract(Vector3 vector3) {
        throw new UnsupportedOperationException("This method has not been Implemented");
    }

    public static Vector3 subtract(Point3 a, Point3 b) {
        throw new UnsupportedOperationException("This method has not been Implemented");
    }

    public static Point3 subtract(Point3 point3, Vector3 vector3) {
        throw new UnsupportedOperationException("This method has not been Implemented");
    }

    @Override
    public String toString() {
        return "Point3 [ x=" + getX() + ", y=" + getY() + ", z=" + getW() + "]";
    }
    
}
