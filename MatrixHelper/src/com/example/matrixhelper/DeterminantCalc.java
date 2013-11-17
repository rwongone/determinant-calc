package com.example.matrixhelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DeterminantCalc extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_determinant_calc);
		Spinner spinnerone = (Spinner) findViewById(R.id.spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.row_col_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerone.setAdapter(adapter);
		
		// Show the Up button in the action bar.
		setupActionBar();
	}
	public void goToSingleMatrix(View v){
		Intent intent = new Intent(this,InputSingleMatrix.class);
		startActivity(intent);
	}
	public void goToEnterMatrix(View v){
		int rows,cols;
		Spinner rowSpin;
		rowSpin=(Spinner)findViewById(R.id.spinner);
		rows = Integer.parseInt(rowSpin.getSelectedItem().toString());
		cols = rows;
		Intent intent = new Intent(this, EnterMatrix.class);
		intent.putExtra("m", rows);
		intent.putExtra("n", cols);
		startActivity(intent);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.determinant_calc, menu);
		return true;
	}

	public void mainMenuClicked(View v){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
