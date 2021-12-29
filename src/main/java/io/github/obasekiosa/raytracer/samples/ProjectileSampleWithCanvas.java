package io.github.obasekiosa.raytracer.samples;

import io.github.obasekiosa.raytracer.geometry.Point3;
import io.github.obasekiosa.raytracer.geometry.Vector3;
import io.github.obasekiosa.raytracer.graphics.Canvas;
import io.github.obasekiosa.raytracer.graphics.Color;

public class ProjectileSampleWithCanvas {
    private Projectile tick(Environment env, Projectile proj) {
        Point3 position = Point3.add(proj.position, proj.velocity);
        Vector3 velocity = Vector3.add(proj.velocity, env.gravity.add(env.wind)); // good reason to add a variable
                                                                                  // agrument add method

        return new Projectile(position, velocity);
    }

    private class Projectile {
        Point3 position;
        Vector3 velocity;

        public Projectile(Point3 position, Vector3 velocity) {
            this.position = position;
            this.velocity = velocity;
        }
    }

    private class Environment {
        Vector3 gravity;
        Vector3 wind;

        public Environment(Vector3 gravity, Vector3 wind) {
            this.gravity = gravity;
            this.wind = wind;
        }
    }

    public void run() {
        Point3 startPosition = new Point3(0, 1, 0); // on unit above origin
        Vector3 startVelocity = (new Vector3(1, 1.8, 0)).normalize(); // normalized to 1 unit per tick
        startVelocity = startVelocity.multiply(11.5);
        Projectile p = new Projectile(startPosition, startVelocity);

        Vector3 gravity = new Vector3(0, -0.1, 0); // 0.1 unit per tick in the negative y-direction
        Vector3 wind = new Vector3(-0.01, 0, 0); // 0.001 unit per tick in the negative x-direction
        Environment e = new Environment(gravity, wind);

        Canvas canvas = new Canvas(900, 550);
        plotWithinBounds(p.position, canvas);

        while (true) {
            p = tick(e, p);
            if (p.position.getY() <= 0) {
                break;
            }
    
            plotWithinBounds(p.position, canvas);
        }

        canvas.toPPM();
    }

    private int approximate(double value) {
        return (int) Math.ceil(value);
    }

    private void plotWithinBounds(Point3 position, Canvas canvas) {
        int x = approximate(position.getX());
        int y = approximate(canvas.getHeight() - position.getY());

        if (x < 0 || x >= canvas.getWidth() || y < 0 || y >= canvas.getHeight()) return;

        canvas.writePixel(x, y, new Color(1, 0, 0));
    }


    public static void main(String[] args) {

        ProjectileSampleWithCanvas sample = new ProjectileSampleWithCanvas();
        sample.run();
    }
}
