package io.github.obasekiosa.raytracer.basic;

public class Tuple3 {

    protected double x1;

    protected double x2;

    protected double x3;

    protected double x4;

    

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
        return new Tuple3(this.x1 + other.x1, this.x2 + other.x2, this.x3 + other.x3, this.x4 + other.x4);
    }

    public static Tuple3 add(Tuple3 a, Tuple3 b) {
        return new Tuple3(a.x1 + b.x1, a.x2 + b.x2, a.x3 + b.x3, a.x4 + b.x4);
    }

    public Tuple3 subtract(Tuple3 other) {
        return new Tuple3(this.x1 - other.x1, this.x2 - other.x2, this.x3 - other.x3, this.x4 - other.x4);
    }

    public static Tuple3 subtract(Tuple3 a, Tuple3 b) {
        return new Tuple3(a.x1 - b.x1, a.x2 - b.x2, a.x3 - b.x3, a.x4 - b.x4);
    }

    public static Tuple3 zero() {
        return new Tuple3(0, 0, 0, 0);
    }

    public static Tuple3 negate(Tuple3 tuple3) {
        return new Tuple3(-tuple3.x1, -tuple3.x2, -tuple3.x3, -tuple3.x4);
    }

    public Tuple3 negate() {
        return new Tuple3(-this.x1, -this.x2, -this.x3, -this.x4);
    }

    public Tuple3 multiply(double scalar) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public static Tuple3 multiply(Tuple3 tuple3, double scalar) {
        throw new UnsupportedOperationException("This method has not been implemented");
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tuple3 other = (Tuple3) obj;
        if (Double.doubleToLongBits(x1) != Double.doubleToLongBits(other.x1))
            return false;
        if (Double.doubleToLongBits(x2) != Double.doubleToLongBits(other.x2))
            return false;
        if (Double.doubleToLongBits(x3) != Double.doubleToLongBits(other.x3))
            return false;
        if (Double.doubleToLongBits(x4) != Double.doubleToLongBits(other.x4))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tuple3 (x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4 + ")";
    }

    
    

}

