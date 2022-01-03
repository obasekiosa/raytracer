package io.github.obasekiosa.raytracer.basic;

import io.github.obasekiosa.raytracer.geometry.GeometryContstants;

public class Tuple3 {

    protected final double EPSILON = 1e-4;

    private double x1;

    private double x2;

    private double x3;

    private double x4;

    

    public Tuple3(double x1, double x2, double x3, double x4) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getX4() {
        return x4;
    }

    public void setX4(double x4) {
        this.x4 = x4;
    }

    public Tuple3 add(Tuple3 other) {
        return Tuple3.add(this, other);
    }

    public static Tuple3 add(Tuple3 a, Tuple3 b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return new Tuple3(a.x1 + b.x1, a.x2 + b.x2, a.x3 + b.x3, a.x4 + b.x4);
    }

    public Tuple3 subtract(Tuple3 other) {
        
        return Tuple3.subtract(this, other);
    }

    public static Tuple3 subtract(Tuple3 a, Tuple3 b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return new Tuple3(a.x1 - b.x1, a.x2 - b.x2, a.x3 - b.x3, a.x4 - b.x4);
    }

    public static Tuple3 zero() {
        return new Tuple3(0, 0, 0, 0);
    }

    public static Tuple3 negate(Tuple3 tuple3) {
        if (tuple3 == null) {
            throw new IllegalArgumentException("Argument can not be null");
        }
        return new Tuple3(-tuple3.x1, -tuple3.x2, -tuple3.x3, -tuple3.x4);
    }

    public Tuple3 negate() {
        return Tuple3.negate(this);
    }

    public Tuple3 multiply(double scalar) {
        return Tuple3.multiply(this, scalar);
    }

    public static Tuple3 multiply(Tuple3 tuple3, double scalar) {
        if (tuple3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        return new Tuple3(scalar * tuple3.x1, scalar * tuple3.x2, scalar * tuple3.x3, scalar * tuple3.x4);
    }

    public Tuple3 divide(double scalar) {
        return Tuple3.divide(this, scalar);
    }

    public static Tuple3 divide(Tuple3 tuple3, double scalar) {
        if (tuple3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }

        if (scalar == 0 && (tuple3.x1 == 0 || tuple3.x2 == 0 || tuple3.x3 == 0 || tuple3.x4 == 0)) {
            throw new ArithmeticException("Can not divide zero by zero");
        } else if (scalar == 0) {
            return new Tuple3(
                    tuple3.x1 < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY,
                    tuple3.x2 < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY,
                    tuple3.x3 < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY,
                    tuple3.x4 < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY
                    );
        } else {
            return new Tuple3(tuple3.x1 / scalar, tuple3.x2 / scalar, tuple3.x3 / scalar, tuple3.x4 / scalar);
        }
    }

    public static double magnitude(Tuple3 tuple3) {
        if (tuple3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }

        return Math.sqrt(tuple3.x1 * tuple3.x1 + tuple3.x2 * tuple3.x2 + tuple3.x3 * tuple3.x3 + tuple3.x4 * tuple3.x4);
    }

    public double magnitude() {
        return Tuple3.magnitude(this);
    }

    public static Tuple3 normalize(Tuple3 tuple3) {
        if (tuple3 == null) {
            throw new IllegalArgumentException("Method arguments can not be null");
        }
        double magnitude = tuple3.magnitude();
        if (magnitude == 0) throw new ArithmeticException("Magnitude of tuple is zero");

        return tuple3.divide(magnitude);
    }

    public Tuple3 normalize() {
        return Tuple3.normalize(this);
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x1);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x2);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x3);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x4);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    protected boolean equals(double a, double b) {
        return Math.abs(a - b) < GeometryContstants.EQUALITY_DELTA;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass()) 
            return false;
        Tuple3 other = (Tuple3) obj;
        if (!equals(x1, other.x1))
            return false;
        if (!equals(x2, other.x2))
            return false;
        if (!equals(x3, other.x3))
            return false;
        if (!equals(x4, other.x4))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tuple3 ( x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4 + " )";
    }

    
    

}

