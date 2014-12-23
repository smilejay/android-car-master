package com.cardata.carmaster;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Oil extends Fragment implements LocationListener{

	private static final String LOG_TAG = "UseLocation";
	
	LocationManager mLocationManager = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
		Location loc = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		View view = inflater.inflate(R.layout.oil, null);
		((TextView) view.findViewById(R.id.tv_latitude)).setText("latitude = " + loc.getLatitude());
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5, 10, this);
		return view;
	}
	
	private void displayLocation(Location loc) {
		((TextView) getView().findViewById(R.id.tv_latitude)).setText("latitude = " + loc.getLatitude());
	}

	int count = 0;

	@Override
	public void onLocationChanged(Location location) {
		count++ ;
		displayLocation(location);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}	
}