package io.github.obasekiosa.raytracer.geometry;

import io.github.obasekiosa.raytracer.basic.Tuple3;

public class Vector3 extends Tuple3 {

    public Vector3(double x, double y, double z) {
        super(x, y, z, 0.0);
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

    public Vector3 add(Vector3 other) {
        return new Vector3(this.getX() + other.getX(), this.getY() + other.getY(), this.getZ() + other.getZ());
    }

    public Point3 add(Point3 point3) {
        return new Point3(this.getX() + point3.getX(), this.getY() + point3.getY(), this.getZ() + point3.getZ());
    }

    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    public static Point3 add(Point3 point3, Vector3 vector3) {
        return new Point3(point3.getX() + vector3.getX(), point3.getY() + vector3.getY(), point3.getZ() + vector3.getZ());
    }

    public static Point3 add(Vector3 vector3, Point3 point3) {
        return new Point3(vector3.getX() + point3.getX(), vector3.getY() + point3.getY(), vector3.getZ() + point3.getZ());
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.getX() - other.getX(), this.getY() - other.getY(), this.getZ() - other.getZ());
    }

    public static Vector3 subtract(Vector3 a, Vector3 b) {
        return new Vector3(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    public static Point3 subtract(Point3 point3, Vector3 vector3) {
        return new Point3(point3.getX() - vector3.getX(), point3.getY() - vector3.getY(), point3.getZ() - vector3.getZ());
    }

    public static Vector3 zero() {
        return new Vector3(0, 0, 0);
    }

    public Vector3 negate() {
        return new Vector3(-this.getX(), -this.getY(), -this.getZ());
    }

    public static Vector3 negate(Vector3 vector3) {
        return new Vector3(-vector3.getX(), -vector3.getY(), -vector3.getZ());
    }


    @Override
    public String toString() {
        return "Vector3 ( x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ")";
    }
    
}
