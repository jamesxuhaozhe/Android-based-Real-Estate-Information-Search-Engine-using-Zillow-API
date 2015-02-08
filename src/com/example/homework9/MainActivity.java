package com.example.homework9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity  {
	//define the key 
	
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	//define the dropdown list
	Spinner spnr;
	@Override
	//This onCreate method is automatically called before a new view is presented.
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
		
		
		
		 
		spnr = (Spinner)findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.states, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnr.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	//the method which will be called once the Submit button is clicked
	public void sendMessage(View view) {
		//use intent to pass the value to the next view
		System.out.println("clicked1");
		//Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText1 = (EditText) findViewById(R.id.address);
		EditText editText2 = (EditText) findViewById(R.id.city);
		//String message = editText1.getText().toString();
		String message = spnr.getSelectedItem().toString();
		//EXTRA_MESSAGE is the key to the message, the purpose of having a key is to make it easy for the next view to grab the data
		//intent.putExtra(EXTRA_MESSAGE, message);
		//startActivity(intent);
		String theAddress = editText1.getText().toString();
		String theCity = editText2.getText().toString();
		Fetchstuff ss = new Fetchstuff();
		ss.execute(theAddress,theCity,message);
	
		
	}
	
	 class Fetchstuff extends AsyncTask<String,Integer,String>{

		@SuppressWarnings("finally")
		@Override
		protected String doInBackground(String... params) {
			
			String path = "http://zillow-search-env.elasticbeanstalk.com/?address="+params[0]+"&city="+params[1]+"&state="+params[2];
			path = path.replaceAll(" ", "%20");
			//System.out.println(path);
			//String path ="http://zillow-search-env.elasticbeanstalk.com/?address=2636%20Menlo%20Ave&city=Los%20Angeles&state=CA";
			StringBuilder builder = new StringBuilder();
			//return params[0];
			InputStream input=null;
			try {				
				
				URL url=new URL(path);
				
				input = url.openStream();
				InputStreamReader reader=new InputStreamReader(input);
				BufferedReader reader_1 = new BufferedReader(reader);
				String line=null;
				while((line=reader_1.readLine())!=null){
					builder.append(line);
				}
				input.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e2){
				e2.printStackTrace();
			} catch (IOException e3){
				e3.printStackTrace();
			}finally{
				return builder.toString();
			}	
		}
		
		protected void onPostExecute(String result){
			System.out.println(result);
			Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
			intent.putExtra(EXTRA_MESSAGE, result);
			startActivity(intent);
		}
	}


	
}
