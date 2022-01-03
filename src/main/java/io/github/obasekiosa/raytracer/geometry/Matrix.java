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

    private boolean equals(double[] a, double[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!equals(a[i], b[i])) return false;
        }
        return true;
    }

    private boolean equals(double a, double b) {
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
        Matrix other = (Matrix) obj;
        if (cols != other.cols)
            return false;
        if (rows != other.rows)
            return false;
        if (!equals(matrix, other.matrix))
            return false;
        return true;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        throw new UnImplementedMethodException();
    }

    public Matrix multiply(Matrix matrix) {
        if (this.cols != matrix.rows) {
            throw new ArithmeticException("rows of argument must match cols of Matrix object");
        }

        Matrix result = new Matrix(this.rows, matrix.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.cols; j++) {
                double value = 0;
                for (int k = 0; k < this.cols; k++) {
                    value += (this.getEntry(i, k) * matrix.getEntry(k, j));
                    
                }
    
                result.setEntry(i, j, value);
            }
        }

        return result;
    }

    public Tuple3 multiply(Tuple3 tuple3) {
        if (this.rows != 4) throw new ArithmeticException("Matrix object must have 4 rows");

        double x1 = this.getEntry(0, 0) * tuple3.getX1() + this.getEntry(0, 1) * tuple3.getX2() + this.getEntry(0, 2) * tuple3.getX3() + this.getEntry(0, 3) * tuple3.getX4();
        double x2 = this.getEntry(1, 0) * tuple3.getX1() + this.getEntry(1, 1) * tuple3.getX2() + this.getEntry(1, 2) * tuple3.getX3() + this.getEntry(1, 3) * tuple3.getX4();
        double x3 = this.getEntry(2, 0) * tuple3.getX1() + this.getEntry(2, 1) * tuple3.getX2() + this.getEntry(2, 2) * tuple3.getX3() + this.getEntry(2, 3) * tuple3.getX4();
        double x4 = this.getEntry(3, 0) * tuple3.getX1() + this.getEntry(3, 1) * tuple3.getX2() + this.getEntry(3, 2) * tuple3.getX3() + this.getEntry(3, 3) * tuple3.getX4();

        return new Tuple3(x1, x2, x3, x4);
    }

    public static Matrix identity(int size) {
        if (size <= 0) throw new IllegalArgumentException("Argument size must be greater than 0");
        Matrix result = new Matrix(size);

        for (int i = 0; i < size; i++) {
            result.setEntry(i, i, 1.0);
        }

        return result;
    }

    public Matrix identity() {
        int size = this.cols > this.rows ? this.cols : this.rows;
        return Matrix.identity(size);
    }

    public static Matrix transpose(Matrix matrix) {
        throw new UnImplementedMethodException();
    }

    public Matrix transpose() {
        Matrix result = new Matrix(this.cols, this.rows);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setEntry(j, i, this.getEntry(i, j));
            }
        }

        return result;
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
        if (this.rows != this.cols) throw new ArithmeticException("Determinant is only valid for a square matrix. number of rows must equal number of columns");

        if (this.rows == 1) return this.getEntry(0, 0);

        if (this.rows == 2) return this.getEntry(0, 0) * this.getEntry(1, 1) - this.getEntry(0, 1) * this.getEntry(1, 0);
        
        else {
            double det = 0;
            for (int j = 0; j < this.cols; j++) {
                det += this.getEntry(0, j) * this.cofactor(0, j);
            }
            return det;
        }
    }
    
    public static Matrix subMatrix(Matrix matrix, int row, int column) {
        throw new UnImplementedMethodException();
    }

    public Matrix subMatrix(int row, int column) {
        if (this.rows == 1) throw new ArithmeticException("Can not find a sub matrix of a 1 x n Matrix");
        if (this.cols == 1) throw new ArithmeticException("Can not find a sub matrix of a n x 1 Matrix");

        if (row < 0 || row >= this.rows) throw new IllegalArgumentException("row out of bounds. row must be between 0 (inclusive) and " + this.rows);
        if (column < 0 || column >= this.cols) throw new IllegalArgumentException("column out of bounds. column must be between 0 (inclusive) and " + this.cols);

        Matrix result = new Matrix(this.rows - 1, this.cols - 1);

        int resultRow = 0;
        for (int i = 0; i < this.rows; i++) {
            if (i == row) continue;

            int resultCol = 0;
            for (int j = 0; j < this.cols; j++){
                if (j == column) continue;

                result.setEntry(resultRow, resultCol, this.getEntry(i, j));
                resultCol++;
            }

            resultRow++;
        }

        return result;
    }

    public static double minor(Matrix matrix, int row, int column) {
        throw new UnImplementedMethodException();
    }

    public double minor(int row, int column) {
        if (this.rows != this.cols) 
            throw new ArithmeticException(
                    "Minor is only valid for a square matrix. number of rows must equal number of columns");

        if (this.rows == 1)
            throw new ArithmeticException("Can not find a minor of a 1 x n Matrix");
        if (this.cols == 1)
            throw new ArithmeticException("Can not find a minor of a n x 1 Matrix");

        if (row < 0 || row >= this.rows)
            throw new IllegalArgumentException("row out of bounds. row must be between 0 (inclusive) and " + this.rows);
        if (column < 0 || column >= this.cols)
            throw new IllegalArgumentException(
                    "column out of bounds. column must be between 0 (inclusive) and " + this.cols);

        Matrix sub = this.subMatrix(row, column);
        
        return sub.determinant();

    }

    public static double cofactor(Matrix matrix, int row, int column) {
        throw new UnImplementedMethodException();
    }

    public double cofactor(int row, int column) {
        if (this.rows != this.cols)
            throw new ArithmeticException(
                    "Cofactor is only valid for a square matrix. number of rows must equal number of columns");

        if (this.rows == 1)
            throw new ArithmeticException("Can not find a cofactor of a 1 x n Matrix");
        if (this.cols == 1)
            throw new ArithmeticException("Can not find a cofactor of a n x 1 Matrix");

        if (row < 0 || row >= this.rows)
            throw new IllegalArgumentException("row out of bounds. row must be between 0 (inclusive) and " + this.rows);
        if (column < 0 || column >= this.cols)
            throw new IllegalArgumentException(
                    "column out of bounds. column must be between 0 (inclusive) and " + this.cols);

        double minor = this.minor(row, column);
        return minor * ((row + column) % 2 == 0 ? 1 : -1);

    }

    public static boolean invertible(Matrix matrix) {
        throw new UnImplementedMethodException();
    }

    public boolean isInvertible() {
        if (this.rows != this.cols) return false;
        return !equals(this.determinant(), 0);
    }

    public static Matrix from(double[][] values) {
        if (values.length == 0) throw new IllegalArgumentException("rows can not be zero");
        
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i].length == 0) throw new IllegalArgumentException("column can not be zero");
            if (max < values[i].length) max = values[i].length;
        }

        Matrix matrix = new Matrix(values.length, max);

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                matrix.setEntry(i, j, values[i][j]);
            }
        }

        return matrix;
    }



    
}
