package com.mapmypark.mapmypark;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.os.Bundle;

//@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	private GoogleMap mMap;
	private List <Park> aList = new LinkedList<Park>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //get a handle to the map fragment
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        
        //check map availability
        setUpMapIfNeeded();
        
        ParksDB mDB = new ParksDB(this);
        
        try
        {
        	String file = "scotland.txt";
        	mDB.importParks(file);
        }
        catch (IOException e)
        {
           System.out.println(e);
        }
        catch (Exception e)
        {
           System.out.println(e);
           System.out.println("Class Tester may still be incomplete.");
        }
        
        //get all parks
        aList = mDB.getAllParks();
        
        //place the park markers
        for (int i =0; i<aList.size(); i++)
        {
        	Park aPark = aList.get(i);
        	LatLng loc = new LatLng(aPark.getLat(), aPark.getLng());
        	mMap.setMyLocationEnabled(true);
        	mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 13));
        	mMap.addMarker(new MarkerOptions()
        		.title(aPark.getTitle())
        		.snippet(aPark.getSnippet())
        		.position(loc));
        }
        
    }
    
 
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                                .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                // The Map is verified. It is now safe to manipulate the map.

            }
        }
    }
    
    
}