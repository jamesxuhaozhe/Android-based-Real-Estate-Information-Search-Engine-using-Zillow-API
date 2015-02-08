package com.example.homework9;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends FragmentActivity implements TabListener {

	ActionBar actionBar;
	String wanteddata;
	Fragment fr;
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 Intent intent = getIntent();
		 String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		 
		 wanteddata = message;
		  // Create the text view
		 //Activity ac=DisplayMessageActivity.this;
		 //TextView textView =(TextView) ac.findViewById(R.id.textView1);
		 //TextView textView = new TextView(this);
		    //textView.setTextSize(10);
		    //textView.setText(message);

		    // Set the text view as the activity layout
		    //setContentView(textView);
		    setContentView(R.layout.activity_display_message);
		    
		    actionBar = getActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			
			ActionBar.Tab tab1 = actionBar.newTab();
			tab1.setText("BASIC INFO");
			tab1.setTabListener(this);
			
			ActionBar.Tab tab2 = actionBar.newTab();
			tab2.setText("HISTORICAL ZESTIMATES");
			tab2.setTabListener(this);
			
			actionBar.addTab(tab1);
			actionBar.addTab(tab2);
			
			actionBar.setDisplayShowHomeEnabled(false); 
			actionBar.setDisplayShowCustomEnabled(true); 
			actionBar.setDisplayShowTitleEnabled(false);
			
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.d("VIVZ","onTabSelected at" + "position" + tab.getPosition() + " name " + tab.getText());
		Activity ac=DisplayMessageActivity.this;
		TextView textView =(TextView) ac.findViewById(R.id.textView1);
		textView.setTextSize(20);
		textView.setText(wanteddata);
	
        
        if(tab.getPosition()==0){
        	fr = new FragmentA(wanteddata);

            fm = getFragmentManager();
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place, fr);
            fragmentTransaction.commit();
        }else if(tab.getPosition()==1){
        	 fr = new FragmentB(wanteddata);

             fm = getFragmentManager();
             fragmentTransaction = fm.beginTransaction();
             fragmentTransaction.replace(R.id.fragment_place, fr);
             fragmentTransaction.commit();
    		
        }
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.d("VIVZ","onTabUnselected at" + "position" + tab.getPosition() + " name " + tab.getText());
		Activity ac=DisplayMessageActivity.this;
		ac.findViewById(R.id.textView1)
		.setVisibility(View.INVISIBLE);
		
	/*	 fr = new FragmentB();

         fm = getFragmentManager();
         fragmentTransaction = fm.beginTransaction();
         fragmentTransaction.replace(R.id.fragment_place, fr);
         fragmentTransaction.commit();*/
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.d("VIVZ","onTabReselected at" + "position" + tab.getPosition() + " name " + tab.getText());
		Activity ac=DisplayMessageActivity.this;
		ac.findViewById(R.id.textView1)
		.setVisibility(View.INVISIBLE);
		/* fr = new FragmentB();

         fm = getFragmentManager();
         fragmentTransaction = fm.beginTransaction();
         fragmentTransaction.replace(R.id.fragment_place, fr);
         fragmentTransaction.commit();*/
	
	}
}


