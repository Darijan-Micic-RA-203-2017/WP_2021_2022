package model.venue;

public class WorkingHours {
	private String openingHours;
	private String closingHours;
	
	public WorkingHours() {}
	
	public WorkingHours(String openingHours, String closingHours) {
		this.openingHours = openingHours;
		this.closingHours = closingHours;
	}
	
	public String getOpeningHours() {
		return openingHours;
	}
	
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	
	public String getClosingHours() {
		return closingHours;
	}
	
	public void setClosingHours(String closingHours) {
		this.closingHours = closingHours;
	}
}
