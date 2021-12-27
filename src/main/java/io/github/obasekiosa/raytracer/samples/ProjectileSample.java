package io.github.obasekiosa.raytracer.samples;

import io.github.obasekiosa.raytracer.geometry.Point3;
import io.github.obasekiosa.raytracer.geometry.Vector3;

public class ProjectileSample {

    private Projectile tick(Environment env, Projectile proj) {
        Point3 position = Point3.add(proj.position, proj.velocity);
        Vector3 velocity = Vector3.add(proj.velocity, env.gravity.add(env.wind)); // good reason to add a variable agrument add method
    
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
        Vector3 startVelocity = (new Vector3(1, 1, 0)).normalize(); // normalized to 1 unit per tick

        Vector3 gravity = new Vector3(0, -0.1, 0); // 0.1 unit per tick in the negative y-direction
        Vector3 wind = new Vector3(-0.01, 0, 0); // 0.001 unit per tick in the negative x-direction

        Environment e = new Environment(gravity, wind);
        Projectile p = new Projectile(startPosition, startVelocity);

        long tickCount = 0;
        System.out.println("Tick " + tickCount + " : Current Position is " + p.position);

        while (true) {
            p = tick(e, p);
            tickCount++;
            if (p.position.getY() <= 0 ) {
                break;
            }
            System.out.println("Tick " + tickCount + " : Current Position is " + p.position);
        }
    }

    public static void main(String[] args) {
        
        ProjectileSample sample = new ProjectileSample();
        sample.run();
    }
}
