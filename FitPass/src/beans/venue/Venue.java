package beans.venue;

import java.util.List;

import beans.location.Location;

public class Venue {
	private long id;
	private boolean logicallyDeleted;
	private String name;
	private VenueType type;
	private List<VenueContent> contents;
	private VenueStatus status;
	private Location location;
	private String logoPath;
	private double averageGrade;
	private WorkingHours workingHours;
	
	public Venue() {}
	
	public Venue(long id, boolean logicallyDeleted, String name, VenueType type, 
			List<VenueContent> contents, VenueStatus status, Location location, 
			String logoPath, double averageGrade, WorkingHours workingHours) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.name = name;
		this.type = type;
		this.contents = contents;
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
	
	public boolean isLogicallyDeleted() {
		return logicallyDeleted;
	}
	
	public void setLogicallyDeleted(boolean logicallyDeleted) {
		this.logicallyDeleted = logicallyDeleted;
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
	
	public List<VenueContent> getContents() {
		return contents;
	}
	
	public void setContents(List<VenueContent> contents) {
		this.contents = contents;
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
