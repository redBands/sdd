package com.mapmypark.mapmypark;

public class Park {
	
	private int id;
	private double lat;
	private double lng;
    private String title;
    private String snippet;
 
    public Park(){}
 
    public Park(double aLat, double aLng, String aTitle, String aSnippet) {
        super();
        lat = aLat;
        lng = aLng;
        title = aTitle;
        snippet = aSnippet;
    }
 
    public void setId(int anId)
    {
    	id = anId;
    }
    
    public int getID()
    {
    	return id;
    }
    
    public void setLat(double aLat)
    {
    	lat = aLat;
    }
    
    public double getLat()
    {
    	return lat;
    }
    
    public void setLng(double aLng)
    {
    	lng = aLng;
    }
    
    public double getLng()
    {
    	return lng;
    }
    
    public void setTitle(String aTitle)
    {
    	title = aTitle;
    }
    
    public String getTitle()
    {
    	return title;
    }
    
    public void setSnippet(String aSnippet)
    {
    	snippet = aSnippet;
    }
    
    public String getSnippet()
    {
    	return snippet;
    }
 
    @Override
    public String toString() {
        return "Park [id=" + id + ", lat=" + lat + ", lng=" + lng + "," +
        		"title=" + title + ", snippet= " + snippet + "]";
    }

}
