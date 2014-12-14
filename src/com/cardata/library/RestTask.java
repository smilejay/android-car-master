package com.cardata.library;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class RestTask extends AsyncTask<HttpUriRequest, Void, String>{
	
	public static final String HTTP_RESPONSE = "httpResponse";
	
	private Context mContext;
	private HttpClient mClient;
	private String mAction;
	
	public RestTask(Context context, String action) {
		mContext = context;
		mAction = action;
		mClient = new DefaultHttpClient();
	}
	
	public RestTask(Context context, String action, HttpClient httpClient) {
		mContext = context;
		mAction = action;
		mClient = httpClient;
	}

	@Override
	protected String doInBackground(HttpUriRequest... arg0) {
		try {
			HttpUriRequest request = arg0[0];
			HttpResponse httpResponse = mClient.execute(request);
			
			BasicResponseHandler handler = new BasicResponseHandler();
			String response = handler.handleResponse(httpResponse);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	protected void onPostExecute(String result) {
//		super.onPostExecute(result);
		Intent intent = new Intent(mAction);
		intent.putExtra(HTTP_RESPONSE, result);
		mContext.sendBroadcast(intent);
	}

}
