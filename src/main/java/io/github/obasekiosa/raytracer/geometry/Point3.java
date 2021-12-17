package io.github.obasekiosa.raytracer.geometry;

public class Point3 extends Tuple3 {


    public Point3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1.0;
    }

    public static Point3 add(Point3 a, Point3 b) {
        return new Point3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public Point3 add(Point3 other) {
        return new Point3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    @Override
    public String toString() {
        return "Point3 [ x=" + x + ", y=" + y + ", z=" + z + "]";
    }
    
}
