package dto.venue;

import beans.venue.VenueContent;

public class VenueContentDTO {
	private long id;
	private boolean logicallyDeleted;
	private String name;
	private long typeId;
	private String imagePath;
	private String description;
	private String duration;
	
	public VenueContentDTO() {}
	
	public VenueContentDTO(long id, boolean logicallyDeleted, String name, 
			long typeId, String imagePath,String description, String duration) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.name = name;
		this.typeId = typeId;
		this.imagePath = imagePath;
		this.description = description;
		this.duration = duration;
	}
	
	public VenueContentDTO(VenueContent venueContent) {
		this.id = venueContent.getId();
		this.logicallyDeleted = venueContent.isLogicallyDeleted();
		this.name = venueContent.getName();
		this.typeId = venueContent.getType().getId();
		this.imagePath = venueContent.getImagePath();
		this.description = venueContent.getDescription();
		this.duration = venueContent.getDuration();
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
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
