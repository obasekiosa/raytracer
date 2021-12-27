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

    public Vector3 multiply(double scalar) {
        return Vector3.multiply(this, scalar);
    }

    public static Vector3 multiply(Vector3 vector3, double scalar) {
        if (vector3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return new Vector3(scalar * vector3.x1, scalar * vector3.x2, scalar * vector3.x3);
    }

    public Vector3 divide(double scalar) {
        return Vector3.divide(this, scalar);
    }

    public static Vector3 divide(Vector3 vector3, double scalar) {
        if (vector3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }

        if (scalar == 0 && (vector3.getX() == 0 || vector3.getY() == 0 || vector3.getZ() == 0)) {
            throw new ArithmeticException("Can not divide zero by zero");
        } else if (scalar == 0) {
            return new Vector3(
                    vector3.getX() < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY,
                    vector3.getY() < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY,
                    vector3.getZ() < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
        } else {
            return new Vector3(vector3.getX() / scalar, vector3.getY() / scalar, vector3.getZ() / scalar);
        }
    }


    public static double magnitude(Vector3 vector3) {
        if (vector3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }

        return Math.sqrt(vector3.getX() * vector3.getX() + vector3.getY() * vector3.getY() + vector3.getZ() * vector3.getZ() + vector3.getW() * vector3.getW());
    }

    public double magnitude() {
        return Vector3.magnitude(this);
    }

    public static Vector3 normalize(Vector3 vector3) {
        if (vector3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        
        double magnitude = vector3.magnitude();
        if (magnitude == 0)
            throw new ArithmeticException("Magnitude of vector is zero");

        return vector3.divide(magnitude);
    }

    public Vector3 normalize() {
        return Vector3.normalize(this);
    }

    public static double dotProduct(Vector3 a, Vector3 b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return a.getX() * b.getX()
                + a.getY() * b.getY() 
                + a.getZ() * b.getZ() 
                + a.getW() * b.getW();
    }

    public double dotProduct(Vector3 vector3) {
        if (vector3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return Vector3.dotProduct(this, vector3);
    }

    public static Vector3 crossProduct(Vector3 a, Vector3 b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }

        return new Vector3(a.getY() * b.getZ() - a.getZ() * b.getY(),
                            a.getZ() * b.getX() - a.getX() * b.getZ(),
                            a.getX() * b.getY() - a.getY() * b.getX());
    }

    public Vector3 crossProduct(Vector3 vector3) {
        if (vector3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return Vector3.crossProduct(this, vector3);
    }


    @Override
    public String toString() {
        return "Vector3 ( x=" + getX() + ", y=" + getY() + ", z=" + getZ() + " )";
    }
    
}
