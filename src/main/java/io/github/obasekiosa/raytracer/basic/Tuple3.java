package io.github.obasekiosa.raytracer.basic;

public abstract class Tuple3 {

    protected double x1;

    protected double x2;

    protected double x3;

    protected double x4;

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

    
    

}

