package io.github.obasekiosa.raytracer.geometry;

import java.util.Arrays;

import io.github.obasekiosa.raytracer.basic.Tuple3;
import io.github.obasekiosa.raytracer.exceptions.UnImplementedMethodException;

public class Matrix {
    
    private double[] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int columns) {
        throw new UnImplementedMethodException();
    }

    public Matrix(int size) {
        throw new UnImplementedMethodException();
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return cols;
    }

    public void setEntry(int row, int column, double value) {
        throw new UnImplementedMethodException();
    }

    public double getEntry(int row, int columns) {
        throw new UnImplementedMethodException();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cols;
        result = prime * result + Arrays.hashCode(matrix);
        result = prime * result + rows;
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
        Matrix other = (Matrix) obj;
        if (cols != other.cols)
            return false;
        if (rows != other.rows)
            return false;
        if (!Arrays.equals(matrix, other.matrix))
            return false;
        return true;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        throw new UnImplementedMethodException();
    }

    public Matrix multiply(Matrix matrix) {
        throw new UnImplementedMethodException();
    }

    public static Tuple3 multiply( Matrix matrix, Tuple3 tuple3) {
        throw new UnImplementedMethodException();
    }

    public Tuple3 multiply(Tuple3 tuple3) {
        throw new UnImplementedMethodException();
    }

    public static Matrix identity(int size) {
        throw new UnImplementedMethodException();
    }

    public Matrix identity() {
        throw new UnImplementedMethodException();
    }

    public static Matrix transpose(Matrix matrix) {
        throw new UnImplementedMethodException();
    }

    public Matrix transpose() {
        throw new UnImplementedMethodException();
    }
    
    public static Matrix invert(Matrix matrix) {
        throw new UnImplementedMethodException();
    }

    public Matrix invert() {
        throw new UnImplementedMethodException();
    }

    public static double determinant(Matrix matrix) {
        throw new UnImplementedMethodException();
    }

    public double determinant() {
        throw new UnImplementedMethodException();
    }
    
    public static Matrix subMatrix(Matrix matrix, int row, int column) {
        throw new UnImplementedMethodException();
    }

    public Matrix subMatrix(int row, int column) {
        throw new UnImplementedMethodException();
    }

    public static double minor(Matrix matrix, int row, int column) {
        throw new UnImplementedMethodException();
    }

    public double minor(int row, int column) {
        throw new UnImplementedMethodException();
    }

    public static double cofactor(Matrix matrix, int row, int column) {
        throw new UnImplementedMethodException();
    }

    public double cofactor(int row, int column) {
        throw new UnImplementedMethodException();
    }

    public static boolean invertible(Matrix matrix) {
        throw new UnImplementedMethodException();
    }

    public boolean invertible() {
        throw new UnImplementedMethodException();
    }

    public static Matrix from(double[][] values) {
        throw new UnImplementedMethodException();
    }



    
}
