package com.example.xo;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	EditText ed;
	TextView hiname;
	boolean isOK = false;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ed = (EditText) findViewById(R.id.ed);
		hiname = (TextView) findViewById(R.id.hiname);





	}
	public void bok(View v){
		isOK = true;
		String name;
		name = ed.getText().toString();
		hiname.setText("Hello " + name);

	}

	public void bswitch(View v){

		if(isOK){
			Intent intent = new Intent(getApplicationContext(), Activity2.class);
			startActivity(intent);
		} else {
			Toast.makeText(getApplicationContext(), "Press OK", Toast.LENGTH_SHORT).show();
		}


	}

}
