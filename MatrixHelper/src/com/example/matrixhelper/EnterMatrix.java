package com.example.matrixhelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class EnterMatrix extends Activity {
	int a = 0;
	int b = 0;
	int rows, cols;
	int[][] values;
	TextView prompt = (TextView)findViewById(R.id.prompt);
	EditText input = (EditText)findViewById(R.id.input);
	Button ok = (Button)findViewById(R.id.ok);
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_matrix);
		Intent mIntent = getIntent();
		rows = mIntent.getIntExtra("m", 0);
		cols = mIntent.getIntExtra("n", 0);
		TextView txt = (TextView)findViewById(R.id.textView1);
		txt.setText("User is filling a " + rows + " x " + cols + " matrix.");
		// Show the Up button in the action bar.
		values = new int[rows][cols];
		setupActionBar();
	}
	
	void click() {
		TextView prompt = (TextView)findViewById(R.id.prompt);
		EditText input = (EditText)findViewById(R.id.input);
		Button ok = (Button)findViewById(R.id.ok);
		
		values[a][b] = Integer.parseInt(input.getText().toString());
		b++;
		if (b == cols) {
			b = 0;
			a++;
		}
		if (a == rows) {
			prompt.setText("The determinant of your matrix thing is:");
			Matrix m = new Matrix(rows, cols, values);
			input.setText(m.determinant+"");
			ok.setClickable(false);
		}
	}
	
	public void mainMenuClicked(View v){
		Intent intent = new Intent(this, MainActivity.class);
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
		getMenuInflater().inflate(R.menu.enter_matrix, menu);
		return true;
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
