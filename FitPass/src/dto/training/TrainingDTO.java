package dto.training;

import beans.training.Training;

public class TrainingDTO {
	private long id;
	private boolean logicallyDeleted;
	private String name;
	private long typeId;
	private long venueId;
	private String duration;
	private long trainerId;
	private String description;
	private String imagePath;
	
	public TrainingDTO() {}
	
	public TrainingDTO(long id, boolean logicallyDeleted, String name, long typeId, 
			long venueId, String duration, long trainerId, String description, 
			String imagePath) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.name = name;
		this.typeId = typeId;
		this.venueId = venueId;
		this.duration = duration;
		this.trainerId = trainerId;
		this.description = description;
		this.imagePath = imagePath;
	}
	
	public TrainingDTO(Training training) {
		this.id = training.getId();
		this.logicallyDeleted = training.isLogicallyDeleted();
		this.name = training.getName();
		this.typeId = training.getType().getId();
		this.venueId = training.getVenue().getId();
		this.duration = training.getDuration();
		if (training.getTrainer() != null) {
			this.trainerId = training.getTrainer().getId();
		} else {
			this.trainerId = -1;
		}
		this.description = training.getDescription();
		this.imagePath = training.getImagePath();
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
	
	public long getVenueId() {
		return venueId;
	}
	
	public void setVenueId(long venueId) {
		this.venueId = venueId;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public long getTrainerId() {
		return trainerId;
	}
	
	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
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
