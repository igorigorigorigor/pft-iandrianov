package com.example.fw;

public class Site {

	private String categoryOfAd;
	private String typeOfAd;
	private String objectType;
	private String cityDistance;
	private String subwayStation;
	private String areaOfSite;
	private String description;
	private String price;
	private String imagesFolder;
	
	public Site(String categoryOfAd, String typeOfAd,  String objectType, String cityDistance, String subwayStation, 
			String areaOfSite, String description, String price, String imagesFolder) {
		this.categoryOfAd = categoryOfAd;
		this.typeOfAd = typeOfAd;
		this.objectType = objectType;
		this.cityDistance = cityDistance;
		this.subwayStation = subwayStation;
		this.areaOfSite = areaOfSite;
		this.description = description;
		this.price = price;
		this.imagesFolder = imagesFolder; 
	}
	
	public Site(){
		
	}
	
	public Site withCategoryOfAd(String categoryOfAd) {
		this.categoryOfAd = categoryOfAd;
		return this;
	}
	
	public Site withTypeOfAd(String typeOfAd) {
		this.typeOfAd = typeOfAd;
		return this;
	}
	
	public Site withObjectType(String objectType) {
		this.objectType = objectType;
		return this;
	}
	
	
	public Site withCityDistance(String cityDistance) {
		this.cityDistance = cityDistance;
		return this;
	}
	
	public Site withSubwayStation(String subwayStation) {
		this.subwayStation = subwayStation;
		return this;
	}
	
	public Site withAreaOfSite(String areaOfSite) {
		this.areaOfSite = areaOfSite;
		return this;
	}
	
	public Site withDescription(String description) {
		this.description = description;
		return this;
	} 
	
	public Site withPrice(String price) {
		this.price = price;
		return this;
	} 
	
	public Site withImagesFolder(String imagesFolder) {
		this.imagesFolder = imagesFolder;
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
	
	public String getCityDistance() {
		return cityDistance;
	}
	
	public String getSubwayStation() {
		return subwayStation;
	}
		
	public String getAreaOfSite() {
		return areaOfSite;
	}
	
	public String getDescription() {
		return description;
	} 
	
	public String getPrice() {
		return price;
	} 
	
	public String getImagesFolder() {
		return imagesFolder;
	}
	
	
	
	public int compareTo(Site other) {
		int f = this.description.toLowerCase().compareTo(other.description.toLowerCase());
		int t = this.description.toLowerCase().compareTo(other.description.toLowerCase());
		return t+f;
	}
	
}
