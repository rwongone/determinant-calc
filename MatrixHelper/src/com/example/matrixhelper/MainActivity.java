package com.example.matrixhelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import java.util.Vector;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void test(View v) {
		TextView one;
		one = (TextView)findViewById(R.id.txtOne);
		
	}

	Matrix addMatrices (Matrix a, Matrix b) {
		Matrix c;
		if (a.m != b.m) {

		} else if (a.n != b.n){

		}
		c = new Matrix (a.m, a.n, new int[a.m][a.n]);
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
