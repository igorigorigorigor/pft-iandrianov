package com.example.fw;

public class House {

	private String categoryOfAd;
	private String typeOfAd;
	private String objectType;
	private String floorsQuantity;
	private String wallsMaterial;
	private String cityDistance;
	private String subwayStation;
	private String areaOfHouse;
	private String areaOfSite;
	private String description;
	private String price;
	private String imagesFolder;
	
	public House(String categoryOfAd, String typeOfAd,  String objectType, 
			String floorsQuantity, String wallsMaterial, String cityDistance, String subwayStation, 
			String areaOfHouse, String areaOfSite, String description, String price, String imagesFolder) {
		this.categoryOfAd = categoryOfAd;
		this.typeOfAd = typeOfAd;
		this.objectType = objectType;
		this.floorsQuantity = floorsQuantity;
		this.wallsMaterial = wallsMaterial;
		this.cityDistance = cityDistance;
		this.subwayStation = subwayStation;
		this.areaOfHouse = areaOfHouse;
		this.areaOfSite = areaOfSite;
		this.description = description;
		this.price = price;
		this.imagesFolder = imagesFolder; 
	}
	
	public House(){
		
	}
	
	public House withCategoryOfAd(String categoryOfAd) {
		this.categoryOfAd = categoryOfAd;
		return this;
	}
	
	public House withTypeOfAd(String typeOfAd) {
		this.typeOfAd = typeOfAd;
		return this;
	}
	
	public House withObjectType(String objectType) {
		this.objectType = objectType;
		return this;
	}
	
	public House withFloorsQuantity(String floorsQuantity) {
		this.floorsQuantity = floorsQuantity;
		return this;
	}
	
	public House withWallsMaterial(String wallsMaterial) {
		this.wallsMaterial = wallsMaterial;
		return this;
	}
	
	public House withCityDistance(String cityDistance) {
		this.cityDistance = cityDistance;
		return this;
	}
	
	public House withSubwayStation(String subwayStation) {
		this.subwayStation = subwayStation;
		return this;
	}
	
	public House withAreaOfHouse(String areaOfHouse) {
		this.areaOfHouse = areaOfHouse;
		return this;
	}
	
	public House withAreaOfSite(String areaOfSite) {
		this.areaOfSite = areaOfSite;
		return this;
	}
	
	public House withDescription(String description) {
		this.description = description;
		return this;
	} 
	
	public House withPrice(String price) {
		this.price = price;
		return this;
	} 
	
	public House withImagesFolder(String imagesFolder) {
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
	
	public String getFloorsQuantity() {
		return floorsQuantity;
	}
	
	public String getWallsMaterial() {
		return wallsMaterial;
	}
	
	public String getCityDistance() {
		return cityDistance;
	}
	
	public String getSubwayStation() {
		return subwayStation;
	}
	
	public String getAreaOfHouse() {
		return areaOfHouse;
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
	
	@Override
	public String toString() {
		return "House advertisement for: " + description.substring(1, 30);
	}
	
	public int compareTo(House other) {
		int f = this.description.toLowerCase().compareTo(other.description.toLowerCase());
		int t = this.description.toLowerCase().compareTo(other.description.toLowerCase());
		return t+f;
	}
	
}
