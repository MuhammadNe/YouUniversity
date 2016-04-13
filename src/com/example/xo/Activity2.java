package com.example.xo;

import android.support.v7.app.ActionBarActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Activity2 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		
	}
	
	public void openGoogle(View v){
		
		Intent googleIntent = new Intent(Intent.ACTION_WEB_SEARCH);
		googleIntent.putExtra(SearchManager.QUERY, "how to use intent in android");
		startActivity(googleIntent);
		
	}

	public void openDialer(View v){
		Intent dialerIntent = new Intent(Intent.ACTION_DIAL);
		dialerIntent.setData(Uri.parse("tel:0526781234"));
		startActivity(dialerIntent);
	}
}
