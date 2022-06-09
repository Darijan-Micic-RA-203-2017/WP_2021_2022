package model.location;

public class Address {
	private long id;
	private boolean logicallyDeleted;
	private String street;
	private String number;
	private String populatedPlace;
	private String postalCode;
	
	public Address() {}
	
	public Address(long id, boolean logicallyDeleted, String street, String number, 
			String populatedPlace, String postalCode) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.street = street;
		this.number = number;
		this.populatedPlace = populatedPlace;
		this.postalCode = postalCode;
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
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getPopulatedPlace() {
		return populatedPlace;
	}
	
	public void setPopulatedPlace(String populatedPlace) {
		this.populatedPlace = populatedPlace;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
