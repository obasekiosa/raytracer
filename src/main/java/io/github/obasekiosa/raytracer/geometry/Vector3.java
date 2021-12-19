package io.github.obasekiosa.raytracer.geometry;

public class Vector3 extends Tuple3 {

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 0.0;
    }

    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    @Override
    public String toString() {
        return "Vector3 [ x=" + x + ", y=" + y + ", z=" + z + "]";
    }
    
}
