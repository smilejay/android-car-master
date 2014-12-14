package com.cardata.carmaster;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Ticket extends Fragment{
	 WebView myWebView;
	 final static String defaultUrl = "http://m.dianping.com/shanghai/";
	 String myUrl;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ticket, container, false);
		myWebView = (WebView)view.findViewById(R.id.myWebView);
		
		myWebView.getSettings().setJavaScriptEnabled(true);                
		myWebView.setWebViewClient(new MyWebViewClient());
		
		if(myUrl == null) {
		    myUrl = defaultUrl;
		}
		myWebView.loadUrl(myUrl);
		
		return view;
	}
	
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
         myUrl = url;
            view.loadUrl(url);
            return true;
        }
    }
}