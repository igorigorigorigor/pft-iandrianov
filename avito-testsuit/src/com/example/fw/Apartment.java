package com.example.fw;


public class Apartment implements Comparable<Apartment>{

		private String subwayStation;
		private String categoryOfAd;
		private String typeOfAd;
		private String numberOfRooms;
		private String objectType;
		private String floorNumber;
		private String floorsQuantity;
		private String buildingType;
		private String area;
		private String address;
		private String description;
		private String price;
		
		

		public Apartment(String subwayStation, String categoryOfAd, String typeOfAd, 
				String numberOfRooms, String objectType, String floorNumber, String floorsQuantity, 
				String buildingType, String area, String address, String description, String price) {
			this.subwayStation = subwayStation;
			this.categoryOfAd = categoryOfAd;
			this.typeOfAd = typeOfAd;
			this.numberOfRooms = numberOfRooms;
			this.objectType = objectType;
			this.floorNumber = floorNumber;
			this.floorsQuantity = floorsQuantity;
			this.buildingType = buildingType;
			this.area = area;
			this.address = address;
			this.description = description;
			this.price = price;
		}
		
		public Apartment(){
			
		}
		
		public Apartment withSubwayStation(String subwayStation) {
			this.subwayStation = subwayStation;
			return this;
		}
			
		public Apartment withCategoryOfAd(String categoryOfAd) {
			this.categoryOfAd = categoryOfAd;
			return this;
		}
		
		public Apartment withTypeOfAd(String typeOfAd) {
			this.typeOfAd = typeOfAd;
			return this;
		}
		
		public Apartment withNumberOfRooms(String numberOfRooms) {
			this.numberOfRooms = numberOfRooms;
			return this;
		}
		
		public Apartment withObjectType(String objectType) {
			this.objectType = objectType;
			return this;
		}
		
		public Apartment withFloorNumber(String floorNumber) {
			this.floorNumber = floorNumber;
			return this;
		}
		
		public Apartment withFloorsQuantity(String floorsQuantity) {
			this.floorsQuantity = floorsQuantity;
			return this;
		}
		
		public Apartment withBuildingType(String buildingType) {
			this.buildingType = buildingType;
			return this;
		}
		
		public Apartment withArea(String area) {
			this.area = area;
			return this;
		}
		
		public Apartment withAddress(String address) {
			this.address = address;
			return this;
		}
		
		public Apartment withDescription(String description) {
			this.description = description;
			return this;
		} 
		
		public Apartment withPrice(String price) {
			this.price = price;
			return this;
		} 
		
		
		public String getSubwayStation() {
			return subwayStation;
		}
			
		public String getCategoryOfAd() {
			return categoryOfAd;
		}
		
		public String getTypeOfAd() {
			return typeOfAd;
		}
		
		public String getNumberOfRooms() {
			return numberOfRooms;
		}
		
		public String getObjectType() {
			return objectType;
		}
		
		public String getFloorNumber() {
			return floorNumber;
		}
		
		public String getFloorsQuantity() {
			return floorsQuantity;
		}
		
		public String getBuildingType() {
			return buildingType;
		}
		
		public String getArea() {
			return area;
		}
		
		public String getAddress() {
			return address;
		}
		
		public String getDescription() {
			return description;
		} 
		
		public String getPrice() {
			return price;
		} 
		
		@Override
		public String toString() {
			return "Apartment advertisement for Address: " + address;
		}
		
		@Override
		public int compareTo(Apartment other) {
			int f = this.address.toLowerCase().compareTo(other.address.toLowerCase());
			int t = this.address.toLowerCase().compareTo(other.address.toLowerCase());
			return t+f;
		}

}
