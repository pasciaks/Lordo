package com.skilldistillery.lordo.entities;

public class Location {

	private String locationName = "";

	public Location(String name) {
		this.locationName = name;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n----------------------------");
		builder.append(locationName);
		builder.append("----------------------------\n");
		return builder.toString();
	}

}
