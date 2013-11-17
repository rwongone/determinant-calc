package com.example.matrixhelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
/*
	public void test(View v) {
		TextView one;
		one = (TextView)findViewById(R.id.txtOne);
		Matrix m = new Matrix(3, 3, new int[][] {{1, 6, 7}, {-2, 0, 4}, {-5, 2, 3}});
		one.setText(Double.toString(m.determinant));
	}
*/
	public void goToDetCalc(View v){
		Intent intent = new Intent(this, DeterminantCalc.class);
		startActivity(intent);
	}

	Matrix addMatrices (Matrix a, Matrix b) {
		Matrix c;
		if (a.m != b.m) {

		} else if (a.n != b.n){

		}
		c = new Matrix (a.m, a.n, new double[a.m][a.n]);
		for (int i=0; i<a.m; i++) {
			for (int j=0; j<a.n; j++) {
				c.val[i][j] = a.val[i][j] + b.val[i][j];
			}
		}

		return c;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
