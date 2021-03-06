package com.example.matrixhelper;

public class Matrix {
	int m;
	int n;
	double[][] val;
	double determinant;
	public Matrix (int M, int N, double[][] a) { // create an MxN matrix
		m = M;
		n = N;
		val = new double[m][n];

		if (m == n) {
			determinant = det(M, a);
		}
	}
	
	Matrix swap(Matrix mat, int A, int B) {
		Matrix swapped = new Matrix(mat.m, mat.n, mat.val);
		double[] tempRow = new double[mat.n];
		for (int i=0; i<n; i++) {
			tempRow[i] = swapped.val[A][i];
			swapped.val[A][i] = swapped.val[B][i];
			swapped.val[B][i] = tempRow[i];
		}
		return swapped;
	}
	
	double det(int m, double[][] val) { // this assumes that mat is an nxn matrix
		double toReturn = 0;
		if (m < 1) {
			return 0; // mathematically accurate?
		} else if (m == 1) {
			return val[0][0];
		} else if (m == 2) {
			return (val[0][0] * val[1][1])-(val[0][1] * val[1][0]);
		} else { // expansion by row 1, could later extend to expansion by best row OR column (r/c with most zeroes)
			double[][] newVals = {{0.0}};
			int bestRow = 0;
			int bestCol = 0;
			int max = -1;
			int useRow = 1;
			for (int i=0; i<m; i++) { // best row?
				int rowZeroes = 0;
				int colZeroes = 0;
				for (int j=0; j<m; j++) {
					if (val[i][j] == 0) {
						rowZeroes++;
					}
					if (val[j][i] == 0) {
						colZeroes++;
					}
				}
				if (rowZeroes > max) {
					bestRow = i;
					max = rowZeroes;
					useRow = 1;
				}
				if (colZeroes > max) {
					bestCol = i;
					max = colZeroes;
					useRow = 0;
					//System.out.println("Col " + bestCol + " has " + max + " zeroes!");
				}
			}
			
			//System.out.println(bestRow + ", " + bestCol);
			
			if (useRow == 1) {
				for (int i=0; i<m; i++) { // for each element in the best row or column
					double coefficient = val[bestRow][i];
					if (coefficient == 0) continue;
					newVals = new double[m-1][m-1];
					int newRow = 0;
					int newCol = 0;
					for (int j=0; j<m; j++) { // add the element value times its cofactor to the sum
						newCol = 0;
						if (j != bestRow) {
							for (int k=0; k<m; k++) { // j, k go through original matrix mat
								if (k != i) {
									newVals[newRow][newCol] = val[j][k];
									newCol++;	
								}
							}
							newRow++;
						}
					}
					toReturn += coefficient * Math.pow(-1, i+bestRow) * det(m - 1, newVals);
					//System.out.println(coefficient + " * " + det(m-1, newVals));
				}
			} else {
				for (int i=0; i<m; i++) {
					double coefficient = val[i][bestCol];
					if (coefficient == 0) continue;
					newVals = new double[m-1][m-1];
					int newRow = 0;
					int newCol = 0;
					for (int j=0; j<m; j++) {
						newRow = 0;
						if (j != bestCol) {
							for (int k=0; k<m; k++) {
								if (k != i) {
									newVals[newRow][newCol] = val[k][j];
									newRow++;
								}
							}
							newCol++;
						}
					}
					toReturn += coefficient * Math.pow(-1, i + bestCol) * det(m - 1, newVals);
					//System.out.println(coefficient + " * " + det(m-1, newVals));
				}
			}
		}
		return toReturn;
	}

	// determinant
	// RREF form
	// invertibility, if invertible then inverse
}
