package io.github.obasekiosa.raytracer.geometry;

import java.util.Arrays;

import io.github.obasekiosa.raytracer.basic.Tuple3;
import io.github.obasekiosa.raytracer.exceptions.UnImplementedMethodException;

public class Matrix {
    
    private double[] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) throw new IllegalArgumentException("rows and columns must be greater than 0");
        this.matrix = new double[rows * columns];
        this.rows = rows;
        this.cols = columns;
    }

    public Matrix(int size) {
        this(size, size);
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return cols;
    }

    private int getIndex(int row, int col) {
        if (row < 0 || row >= this.rows) throw new IllegalArgumentException("row must be between 0 (inclusive) and " + this.rows);
        if (col < 0 || col >= this.cols) throw new IllegalArgumentException("column must be between 0 (inclusive) and " + this.cols);
        return this.cols * row + col;
    }

    public void setEntry(int row, int column, double value) {
        int index = getIndex(row, column);
        this.matrix[index] = value;
    }

    public double getEntry(int row, int columns) {
        int index = getIndex(row, columns);
        return this.matrix[index];
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

    public Matrix inverse() {
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

    public boolean isInvertible() {
        throw new UnImplementedMethodException();
    }

    public static Matrix from(double[][] values) {
        throw new UnImplementedMethodException();
    }



    
}
