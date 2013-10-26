package com.example.matrixhelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void test(View v) {
    	TextView one;
    	one = (TextView)findViewById(R.id.txtOne);
    	one.setText("asdf");
    	
    	Matrix m = new Matrix(1, 1);
    	m.val[0][0] = 1337;
    	one.setText(Integer.toString(m.val[0][0]));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
