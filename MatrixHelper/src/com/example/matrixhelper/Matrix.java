package com.example.matrixhelper;

import java.util.*;
import java.io.*;

public class Matrix {
	int m;
	int n;
	int[][] val;
	double determinant;
	public Matrix (int M, int N, int[][] a) { // create an MxN matrix
		m = M;
		n = N;
		val = new int[m][n];
	}
	
	double determineDeterminant(Matrix mat) { // this assumes that mat is an nxn matrix
		if (n < 1) {
			return 0;
		} else if (n == 1) {
			return mat.val[0][0];
		} else if (n == 2) {
			return (mat.val[0][0] * mat.val[1][1])-(mat.val[0][1] * mat.val[1][0]);
		} else { // expansion by row 1
			int[][] newVals = new int[mat.m-1][mat.m-1];
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					
				}
			}
			Matrix newMat = new Matrix(mat.m - 1, mat.m - 1, newVals);
		}
		return 0;
	}
	
	// determinant
	// RREF form
	// invertibility, if invertible then inverse
	
}
