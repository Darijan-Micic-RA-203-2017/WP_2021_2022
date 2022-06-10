package dto.location;

import beans.location.Location;

public class LocationDTO {
	private long id;
	private boolean logicallyDeleted;
	private double longitude;
	private double latitude;
	private long addressId;
	
	public LocationDTO() {}
	
	public LocationDTO(long id, boolean logicallyDeleted, double longitude, 
			double latitude, long addressId) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.longitude = longitude;
		this.latitude = latitude;
		this.addressId = addressId;
	}
	
	public LocationDTO(Location location) {
		this.id = location.getId();
		this.logicallyDeleted = location.isLogicallyDeleted();
		this.longitude = location.getLongitude();
		this.latitude = location.getLatitude();
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
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public long getAddressId() {
		return addressId;
	}
	
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
}
