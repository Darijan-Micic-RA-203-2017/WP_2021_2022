package model.venue;

import model.location.Location;

public class Venue {
	private long id;
	private String name;
	private VenueType type;
	private String content;
	private VenueStatus status;
	private Location location;
	private String logoPath;
	private double averageGrade;
	private WorkingHours workingHours;
	
	public Venue() {}
	
	public Venue(long id, String name, VenueType type, String content, 
			VenueStatus status, Location location, String logoPath, 
			double averageGrade, WorkingHours workingHours) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.content = content;
		this.status = status;
		this.location = location;
		this.logoPath = logoPath;
		this.averageGrade = averageGrade;
		this.workingHours = workingHours;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public VenueType getType() {
		return type;
	}
	
	public void setType(VenueType type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public VenueStatus getStatus() {
		return status;
	}
	
	public void setStatus(VenueStatus status) {
		this.status = status;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getLogoPath() {
		return logoPath;
	}
	
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
	public double getAverageGrade() {
		return averageGrade;
	}
	
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	public WorkingHours getWorkingHours() {
		return workingHours;
	}
	
	public void setWorkingHours(WorkingHours workingHours) {
		this.workingHours = workingHours;
	}
}
