package beans.training;

import beans.user.User;
import beans.venue.Venue;

public class Training {
	private long id;
	private boolean logicallyDeleted;
	private String name;
	private TrainingType type;
	private Venue venue;
	private String duration;
	private User trainer;
	private String description;
	private String imagePath;
	
	public Training() {}
	
	public Training(long id, boolean logicallyDeleted, String name, TrainingType type, 
			Venue venue, String duration, User trainer, String description, 
			String imagePath) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.name = name;
		this.type = type;
		this.venue = venue;
		this.duration = duration;
		this.trainer = trainer;
		this.description = description;
		this.imagePath = imagePath;
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
	
	public TrainingType getType() {
		return type;
	}
	
	public void setType(TrainingType type) {
		this.type = type;
	}
	
	public Venue getVenue() {
		return venue;
	}
	
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public User getTrainer() {
		return trainer;
	}
	
	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
