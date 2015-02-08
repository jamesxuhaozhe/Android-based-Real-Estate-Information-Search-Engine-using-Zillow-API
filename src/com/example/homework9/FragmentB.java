package com.example.homework9;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
//import android.support.v4.app.Fragment;
/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class FragmentB extends Fragment {
	private String result;
	private JSONObject json;
	private JSONObject jsonResult;
	private JSONObject jsonChart;
	private JSONObject firstYear;
	private JSONObject fifthYear;
	private JSONObject tenthYear;
	private String year1;
	private String year5;
	private String year10;
	private String street;
	private String city;
	private String zipcode;
	private String state;
	private Button btnAdd, btnSub;
	private ImageSwitcher imageSwitcher;
	private int index = 0;
	private List<Drawable> list;
	private Drawable dr1; 
	private Drawable dr5;
	private Drawable dr10;
	private ImageView ss;
	public FragmentB(String result) {
		// Required empty public constructor
		this.result = result;
		try {
			json = new JSONObject(result);
			jsonResult = json.getJSONObject("result");
			jsonChart = json.getJSONObject("chart");
			firstYear = jsonChart.getJSONObject("1year");
			fifthYear = jsonChart.getJSONObject("5years");
			tenthYear = jsonChart.getJSONObject("10years");
			//year1 = firstYear.getString("url");
			year5 = fifthYear.getString("url");
			year10 = tenthYear.getString("url");
			//year1="http://www.zillow.com/app?chartDuration=1year&chartType=partner&height=10&page=webservice%2FGetChart&service=chart&showPercent=true&width=10&zpid=20582537";
			year1 = firstYear.getString("url");
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		System.out.println(year1);
		//System.out.println(year5);
		//System.out.println(year10);
		list = new ArrayList<Drawable>();
		View view=inflater.inflate(R.layout.fragment_b, container, false);
		ss = (ImageView) view.findViewById(R.id.imageView1);
		/*InputStream is;
		try {
			is = (InputStream) new URL(year1).getContent();
			dr1 = Drawable.createFromStream(is, "src name");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageView ss = (ImageView) view.findViewById(R.id.imageView1);
		ss.setImageDrawable(dr1);*/
		//imageSwitcher = (ImageSwitcher) view.findViewById(R.id.imageSwitcher1);
		/*putData();
		imageSwitcher = (ImageSwitcher) view.findViewById(R.id.imageSwitcher1);
		btnAdd = (Button) view.findViewById(R.id.btnadd);
		btnSub = (Button) view.findViewById(R.id.btnSub);
		btnAdd.setOnClickListener(myClick);
		btnSub.setOnClickListener(myClick);
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this.getActivity(), android.R.anim.slide_in_left));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this.getActivity(), android.R.anim.slide_out_right));
		imageSwitcher.setFactory(new ViewFactory() {
		 
		   public View makeView() {
		       // MakeView returns are currently needed to display the ImageView control, used to fill into the ImageSwitcher. 
		              return new ImageView(getActivity());
		           }
		       });*/
		        //imageSwitcher.setImageDrawable(dr1);
		Fetchstuff fetch = new Fetchstuff();
		fetch.execute(year1,year5,year10);
		  Button button = (Button) view.findViewById(R.id.btnSub);
			   button.setOnClickListener(new OnClickListener()
			   {
			             @Override
			             public void onClick(View v)
			             {
			                // do something
			                 index--;
				               if(index<0)
				               {
					                   //For the circulating display pictures
					                   index=list.size()-1;
				               }
			            	 ss.setImageDrawable(list.get(index));
			            	 //ss.setImageDrawable(list.get(2));
			             } 
			   }); 
			   Button button1 = (Button) view.findViewById(R.id.btnadd);
			   button1.setOnClickListener(new OnClickListener()
			   {
			             @Override
			             public void onClick(View v)
			             {
			                // do something
			            	    index++;
				                if(index>=list.size())
				               {
				                    //For the circulating display pictures
				                     index=0;
				                 }
			            	 ss.setImageDrawable(list.get(index));
			            	 //ss.setImageDrawable(list.get(2));
			             } 
			   }); 
		return view;
	}
	/* private View.OnClickListener myClick = new OnClickListener() {
		
	       @Override
		         public void onClick(View v) {
		            switch (v.getId()) {
	            case R.id.btnadd:
		               index--;
	               if(index<0)
	               {
		                   //For the circulating display pictures
		                   index=list.size()-1;
	               }
		               //Set ImageSwitcher to display a new picture
		               imageSwitcher.setImageDrawable(list.get(index));
	               break;
	
	            case R.id.btnSub:
		                 index++;
		                if(index>=list.size())
		               {
		                    //For the circulating display pictures
		                     index=0;
		                 }
		                  imageSwitcher.setImageDrawable(list.get(index));
		                break;
		            }
		         }
		     };*/
/*	private void putData() {
		// TODO Auto-generated method stub
		dr1 = LoadImageFromURL(year1);
		dr5 =  LoadImageFromURL(year5);
		dr10 =  LoadImageFromURL(year10);
		list = new ArrayList<Drawable>();
		list.add(dr1);
		list.add(dr5);
		list.add(dr10);
	}
	private Drawable LoadImageFromURL(String url) {
		try {
			InputStream is = (InputStream) new URL(url).getContent();
			Drawable d = Drawable.createFromStream(is, "src name");
			return d;
		} catch (Exception e) {
			System.out.println("Excecption is=" + e);
			return null;
		}
	}*/
	
	class Fetchstuff extends AsyncTask<String,Integer,Drawable>{

		@SuppressWarnings("finally")
		@Override
		protected Drawable doInBackground(String... params) {
			// TODO Auto-generated method stub
			InputStream is;
			
			try {
				is = (InputStream) new URL(params[0]).getContent();
				dr1 = Drawable.createFromStream(is, "src name");
				
				is = (InputStream) new URL(params[1]).getContent();
				dr5 = Drawable.createFromStream(is, "src name");
				
				is = (InputStream) new URL(params[2]).getContent();
				dr10 = Drawable.createFromStream(is, "src name");
				
				list.add(dr1);
				list.add(dr5);
				list.add(dr10);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				return dr1;
			}
			
			
		}
		protected void onPostExecute(Drawable result){
			 super.onPostExecute(result);
			 //list.add(dr1);
			 //list.add(dr5);
			 //list.add(dr10);
			 ss.setImageDrawable(result);
		}
	}
	
}
