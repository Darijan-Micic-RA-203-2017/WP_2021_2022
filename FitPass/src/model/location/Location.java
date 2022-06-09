package model.location;

public class Location {
	private long id;
	private boolean logicallyDeleted;
	private double longitude;
	private double latitude;
	private Address address;
	
	public Location() {}
	
	public Location(long id, boolean logicallyDeleted, double longitude, 
			double latitude, Address address) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
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
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}
