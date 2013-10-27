package com.example.matrixhelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
public class MainActivity extends Activity {

	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_main);
	    Spinner spinnerone = (Spinner) findViewById(R.id.spinner);
	    Spinner spinnertwo=(Spinner)findViewById(R.id.spinner2);
	    // Create an ArrayAdapter using the string array and a default spinner layout
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	            R.array.row_col_array, android.R.layout.simple_spinner_item);
	    ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,
	        R.array.row_col_array,android.R.layout.simple_spinner_item);
	    // Specify the layout to use when the list of choices appears
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    // Apply the adapter to the spinner
	    spinnerone.setAdapter(adapter);
	    spinnertwo.setAdapter(adapter2);
	   }

	public void test(View v) {
		TextView one;
		one = (TextView)findViewById(R.id.txtOne);
		Matrix m = new Matrix(3, 3, new int[][] {{1, 6, 7}, {-2, 0, 4}, {-5, 2, 3}});
		one.setText(Double.toString(m.determinant));
	}
	public void goToEnterMatrix(View v){
		Intent intent = new Intent(this, EnterMatrix.class);
		startActivity(intent);
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
