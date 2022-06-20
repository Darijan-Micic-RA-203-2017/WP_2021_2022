package dto.venue;

import java.util.ArrayList;
import java.util.List;

import beans.venue.Venue;
import beans.venue.VenueContent;
import beans.venue.WorkingHours;

public class VenueDTO {
	private long id;
	private boolean logicallyDeleted;
	private String name;
	private long typeId;
	private List<Long> contentsIds;
	private String status;
	private long locationId;
	private String logoPath;
	private double averageGrade;
	private WorkingHours workingHours;
	
	public VenueDTO() {}
	
	public VenueDTO(long id, boolean logicallyDeleted, String name, long typeId, 
			List<Long> contentsIds, String status, long locationId, String logoPath, 
			double averageGrade, WorkingHours workingHours) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.name = name;
		this.typeId = typeId;
		this.contentsIds = contentsIds;
		this.status = status;
		this.locationId = locationId;
		this.logoPath = logoPath;
		this.averageGrade = averageGrade;
		this.workingHours = workingHours;
	}
	
	public VenueDTO(Venue venue) {
		this.id = venue.getId();
		this.logicallyDeleted = venue.isLogicallyDeleted();
		this.name = venue.getName();
		this.typeId = venue.getType().getId();
		this.contentsIds = new ArrayList<Long>();
		for (VenueContent vC: venue.getContents()) {
			this.contentsIds.add(vC.getId());
		}
		this.status = venue.getStatus().toString();
		this.locationId = venue.getLocation().getId();
		this.logoPath = venue.getLogoPath();
		this.averageGrade = venue.getAverageGrade();
		this.workingHours = venue.getWorkingHours();
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
	
	public long getTypeId() {
		return typeId;
	}
	
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
	public List<Long> getContentsIds() {
		return contentsIds;
	}
	
	public void setContentsIds(List<Long> contentsIds) {
		this.contentsIds = contentsIds;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getLocationId() {
		return locationId;
	}
	
	public void setLocationId(long locationId) {
		this.locationId = locationId;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(id).append(";").append(logicallyDeleted).append(";")
				.append(name).append(";").append(typeId).append(";")
				.append(contentsIds).append(";").append(status).append(";")
				.append(locationId).append(";").append(logoPath).append(";")
				.append(averageGrade).append(";").append(workingHours);
		
		return builder.toString();
	}
}
