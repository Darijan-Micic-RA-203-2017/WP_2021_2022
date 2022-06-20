package dto.location;

import beans.location.Location;

public class LocationDTO {
	private long id;
	private boolean logicallyDeleted;
	private double latitude;
	private double longitude;
	private long addressId;
	
	public LocationDTO() {}
	
	public LocationDTO(long id, boolean logicallyDeleted, double latitude, 
			double longitude, long addressId) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.latitude = latitude;
		this.longitude = longitude;
		this.addressId = addressId;
	}
	
	public LocationDTO(Location location) {
		this.id = location.getId();
		this.logicallyDeleted = location.isLogicallyDeleted();
		this.latitude = location.getLatitude();
		this.longitude = location.getLongitude();
		this.addressId = location.getAddress().getId();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isLogicallyDeleted() {
		return logicallyDeleted;
	}
	
	public void setLogicallyDeleted(boolean logicallyDeleted) {
		this.logicallyDeleted = logicallyDeleted;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public long getAddressId() {
		return addressId;
	}
	
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
}
