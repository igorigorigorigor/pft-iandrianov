package com.example.fw;

public class Commercial implements Comparable<Commercial> {

	
	private String categoryOfAd;
	private String typeOfAd;
	private String objectType;
	private String isBusinessReady;
	private String area;
	private String subwayStation;
	private String address;
	private String adName;	
	private String description;
	private String price;
	
	public Commercial(String categoryOfAd, String typeOfAd,  String objectType, 
			String isBusinessReady, String area, String subwayStation, 
			String address, String adName, String description, String price) {
		this.categoryOfAd = categoryOfAd;
		this.typeOfAd = typeOfAd;
		this.objectType = objectType;
		this.isBusinessReady = isBusinessReady;
		this.area = area;
		this.subwayStation = subwayStation;
		this.address = address;
		this.adName = adName;
		this.description = description;
		this.price = price;
	}
	
	public Commercial(){
		
	}
	
			
	public Commercial withCategoryOfAd(String categoryOfAd) {
		this.categoryOfAd = categoryOfAd;
		return this;
	}
	
	public Commercial withTypeOfAd(String typeOfAd) {
		this.typeOfAd = typeOfAd;
		return this;
	}
			
	public Commercial withObjectType(String objectType) {
		this.objectType = objectType;
		return this;
	}
			
	public Commercial withIsBusinessReady(String isBusinessReady) {
		this.isBusinessReady = isBusinessReady;
		return this;
	}
	
	public Commercial withArea(String area) {
		this.area = area;
		return this;
	}
	
	public Commercial withSubwayStation(String subwayStation) {
		this.subwayStation = subwayStation;
		return this;
	}
	
	public Commercial withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public Commercial withAdName(String adName) {
		this.adName = adName;
		return this;
	}
	
	public Commercial withDescription(String description) {
		this.description = description;
		return this;
	} 
	
	public Commercial withPrice(String price) {
		this.price = price;
		return this;
	} 
	
		
		
	public String getCategoryOfAd() {
		return categoryOfAd;
	}
	
	public String getTypeOfAd() {
		return typeOfAd;
	}
	
	public String getObjectType() {
		return objectType;
	}
	
	public String getIsBusinessReady() {
		return isBusinessReady;
	}
			
	public String getArea() {
		return area;
	}
	
	public String getSubwayStation() {
		return subwayStation;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getAdName() {
		return adName;
	}
	
	public String getDescription() {
		return description;
	} 
	
	public String getPrice() {
		return price;
	} 
	
	
	@Override
	public String toString() {
		return "Commercial advertisement for Address: " + address;
	}
	
	@Override
	public int compareTo(Commercial other) {
		int f = this.address.toLowerCase().compareTo(other.address.toLowerCase());
		int t = this.address.toLowerCase().compareTo(other.address.toLowerCase());
		return t+f;
	}	

}
