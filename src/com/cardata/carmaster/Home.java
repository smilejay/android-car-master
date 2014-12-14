package com.cardata.carmaster;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONException;
import org.json.JSONObject;

import com.cardata.library.HttpHandler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Fragment{

//	private static final String HOME_ACTION = "com.cardata.carmaster.HOME";
	private static final String url = "http://smilejay.com:8000/api/get_all_categories/";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home, null); 
		final TextView textView = (TextView)view.findViewById(R.id.textView1);
		new HttpHandler() {
			@Override
			public HttpUriRequest getHttpRequestMethod() {
			return new HttpGet(url);
			// return new HttpPost(url)
			}
			@Override
			public void onResponse(String result) {
			Toast.makeText(getActivity(), "Received!", Toast.LENGTH_LONG).show();
			JSONObject json;
			try {
				json = new JSONObject(result);
				String key = "1";
				textView.setText((CharSequence) json.get(key));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}.execute();
		return view;		
	}

}
