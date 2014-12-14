package com.cardata.library;

import org.apache.http.client.methods.HttpUriRequest;

import com.cardata.library.AsyncHttpTask;

public abstract class HttpHandler {

	public abstract HttpUriRequest getHttpRequestMethod();
	
	public abstract void onResponse(String result);
	
	public void execute(){
		new AsyncHttpTask(this).execute();
	}

	
}
