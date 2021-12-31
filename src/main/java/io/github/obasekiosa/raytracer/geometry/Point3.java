package io.github.obasekiosa.raytracer.geometry;

import io.github.obasekiosa.raytracer.basic.Tuple3;
import io.github.obasekiosa.raytracer.exceptions.UnImplementedMethodException;

public class Point3 extends Tuple3 {


    public Point3(double x, double y, double z) {
        super(x, y, z, 1.0);
    }

    public void setX(double x) {
        this.setX1(x);;
    }

    public double getX() {
       return this.getX1();
    }
    
    public void setY(double y) {
        this.setX2(y);;
    }

    public double getY() {
        return this.getX2();
    }

    public void setZ(double z) {
        this.setX3(z);;
    }

    public double getZ() {
        return this.getX3();
    }

    public void setW(double w) {
        this.setX4(w);
    }

    public double getW() {
        return this.getX4();
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
        return new Point3(point3.getX() + vector3.getX(), point3.getY() + vector3.getY(), point3.getZ() + vector3.getZ());
    }

    public static Point3 add(Vector3 vector3, Point3 point3) {
        return new Point3(vector3.getX() + point3.getX(), vector3.getY() + point3.getY(), vector3.getZ() + point3.getZ());
    }

    public Vector3 subtract(Point3 other) {
        return new Vector3(this.getX() - other.getX(), this.getY() - other.getY(), this.getZ() - other.getZ());
    }

    public Point3 subtract(Vector3 vector3) {
        return new Point3(this.getX() - vector3.getX(), this.getY() - vector3.getY(), this.getZ() - vector3.getZ());
    }

    public static Vector3 subtract(Point3 a, Point3 b) {
        return new Vector3(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    public static Point3 subtract(Point3 point3, Vector3 vector3) {
        return new Point3(point3.getX() - vector3.getX(), point3.getY() - vector3.getY(), point3.getZ() - vector3.getZ());
    }

    public static Point3 zero() {
        return new Point3(0, 0, 0);
    }

    public static Point3 negate(Point3 point3) {
        return new Point3(-point3.getX(), -point3.getY(), -point3.getZ());
    }

    public Point3 negate() {
        return new Point3(-this.getX(), -this.getY(), -this.getZ());
    }


    public Point3 multiply(double scalar) {
        return Point3.multiply(this, scalar);
    }

    public static Point3 multiply(Point3 point3, double scalar) {
        if (point3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return new Point3(scalar * point3.getX(), scalar * point3.getY(), scalar * point3.getZ());
    }

    public Point3 divide(double scalar) {
        return Point3.divide(this, scalar);
    }

    public static Point3 divide(Point3 point3, double scalar) {
        if (point3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }

        if (scalar == 0 && (point3.getX() == 0 || point3.getY() == 0 || point3.getZ() == 0)) {
            throw new ArithmeticException("Can not divide zero by zero");
        } else if (scalar == 0) {
            return new Point3(
                    point3.getX() < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY,
                    point3.getY() < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY,
                    point3.getZ() < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY
            );
        } else {
            return new Point3(point3.getX() / scalar, point3.getY() / scalar, point3.getZ() / scalar);
        }
    }

    public static Point3 from(Tuple3 tuple3) {
        throw new UnImplementedMethodException();
    }

    @Override
    public String toString() {
        return "Point3 ( x=" + getX() + ", y=" + getY() + ", z=" + getZ() + " )";
    }
    
}
