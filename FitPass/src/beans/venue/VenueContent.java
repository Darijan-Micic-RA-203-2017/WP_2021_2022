package beans.venue;

public class VenueContent {
	private long id;
	private boolean logicallyDeleted;
	private String name;
	private VenueContentType type;
	private String imagePath;
	private String description;
	private String duration;
	
	public VenueContent() {}
	
	public VenueContent(long id, boolean logicallyDeleted, String name, 
			VenueContentType type, String imagePath,String description, String duration) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.name = name;
		this.type = type;
		this.imagePath = imagePath;
		this.description = description;
		this.duration = duration;
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
	
	public VenueContentType getType() {
		return type;
	}
	
	public void setType(VenueContentType type) {
		this.type = type;
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
