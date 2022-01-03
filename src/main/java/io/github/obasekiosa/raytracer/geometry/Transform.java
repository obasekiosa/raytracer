package io.github.obasekiosa.raytracer.geometry;

import io.github.obasekiosa.raytracer.exceptions.UnImplementedMethodException;

public abstract class Transform {
    
    public static Matrix translation(double deltaX, double deltaY, double deltaZ) {
        throw new UnImplementedMethodException();
    }
}
