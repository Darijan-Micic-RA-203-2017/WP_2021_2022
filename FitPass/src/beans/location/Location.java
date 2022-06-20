package beans.location;

public class Location {
	private long id;
	private boolean logicallyDeleted;
	private double latitude;
	private double longitude;
	private Address address;
	
	public Location() {}
	
	public Location(long id, boolean logicallyDeleted, double latitude, 
			double longitude, Address address) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.latitude = latitude;
		this.longitude = longitude;
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
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}
