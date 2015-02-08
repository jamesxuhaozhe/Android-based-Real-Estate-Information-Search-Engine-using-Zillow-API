package com.example.homework9;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//import android.support.v4.app.Fragment;
/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class FragmentA extends Fragment {
  private String ff;
  private JSONObject json;
  private JSONObject jsonResult;
  private String city;
  private String homedetails;
  private String street;
  private String zipcode;
  private String bathrooms;
  private String bedrooms;
  private String taxAssessmentYear;
  private String taxAssessment;
  private String yearBuilt;
  private String lotSize;
  private String finishedArea;
  private String propertyType;
  private String lastSoldPrice;
  private String lastSoldDate;
  private String zestimate;
  private String zestimateDate;
  private String overChange;
  private String changeSign;
  private String redDownArrow;
  private String greenUpArrow;
  private String state;
  
	public FragmentA(String sg) {
		// Required empty public constructor
		
		ff = sg;
		try {
			json = new JSONObject(ff);
			
			jsonResult = json.getJSONObject("result");
			city = jsonResult.getString("city");
			state = jsonResult.getString("state");
			homedetails = jsonResult.getString("homedetails");
			street = jsonResult.getString("street");
			zipcode = jsonResult.getString("zipcode");
			propertyType = jsonResult.getString("useCode");
			yearBuilt = jsonResult.getString("yearBuilt");
			lotSize = jsonResult.getString("lotSizeSqFt");
			finishedArea = jsonResult.getString("finishedSqFt");
			bathrooms = jsonResult.getString("bathrooms");
			bedrooms =jsonResult.getString("bedrooms");
			taxAssessmentYear = jsonResult.getString("taxAssessmentYear");
			taxAssessment = jsonResult.getString("taxAssessment");
			zestimate = jsonResult.getString("estimateAmount");
			zestimateDate = jsonResult.getString("estimateLastUpdate");
			lastSoldPrice = jsonResult.getString("lastSoldPrice");
			lastSoldDate = jsonResult.getString("lastSoldDate");
			overChange = jsonResult.getString("estimateValueChange");
			changeSign = jsonResult.getString("estimateValueChangeSign");
			redDownArrow = jsonResult.getString("imgn");
			greenUpArrow = jsonResult.getString("imgp");
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view=inflater.inflate(R.layout.fragment_a, container, false);
		
		
		TextView textView1 =(TextView) view.findViewById(R.id.textView1);
		textView1.setClickable(true);
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
		String text = "<a href='"+ homedetails + "'>"+ street +", "+ city +", "+state + "-"+zipcode+"</a>";
		textView1.setText(Html.fromHtml(text));
		
		TextView textView4 = (TextView) view.findViewById(R.id.textView4);
		textView4.setText(propertyType);
		
		TextView textView6 = (TextView) view.findViewById(R.id.textView6);
		textView6.setText(yearBuilt);
		
		TextView textView8 = (TextView) view.findViewById(R.id.textView8);
		textView8.setText(lotSize);
		
		TextView textView10 = (TextView) view.findViewById(R.id.textView10);
		textView10.setText(finishedArea);
		
		TextView textView12 = (TextView) view.findViewById(R.id.textView12);
		textView12.setText(bathrooms);
		
		TextView textView14 = (TextView) view.findViewById(R.id.textView14);
		textView14.setText(bedrooms);
		
		TextView textView16 = (TextView) view.findViewById(R.id.textView16);
		textView16.setText(taxAssessmentYear);
		
		TextView textView18 = (TextView) view.findViewById(R.id.textView18);
		textView18.setText(taxAssessment);
		
		TextView textView20 = (TextView) view.findViewById(R.id.textView20);
		textView20.setText(lastSoldPrice);
		
		TextView textView22 = (TextView) view.findViewById(R.id.textView22);
		textView22.setText(lastSoldDate);
		
		TextView textView23 = (TextView) view.findViewById(R.id.textView23);
		textView23.setText("Zestimate ¨ Property Estimate as of "+ zestimateDate);
		
		TextView textView24 = (TextView) view.findViewById(R.id.textView24);
		textView24.setText(zestimate);
		
		TextView textView26 = (TextView) view.findViewById(R.id.textView26);
		textView26.setText(overChange);
	
	
		
		TextView textView28 =(TextView) view.findViewById(R.id.textView28);
		textView28.setClickable(true);
		textView28.setMovementMethod(LinkMovementMethod.getInstance());
		String branding1 = "Use is subject to "+"<a href='http://www.zillow.com/corp/Terms.htm'>Terms of Use</a>";
		textView28.setText(Html.fromHtml(branding1));
		
		TextView textView29 =(TextView) view.findViewById(R.id.textView29);
		textView29.setClickable(true);
		textView29.setMovementMethod(LinkMovementMethod.getInstance());
		String branding2 = "<a href='http://www.zillow.com/zestimate/'>What's a Zestimate?</a>";
		textView29.setText(Html.fromHtml(branding2));
		
		
		
		//return inflater.inflate(R.layout.fragment_a, container, false);
		return view;
	}


}
