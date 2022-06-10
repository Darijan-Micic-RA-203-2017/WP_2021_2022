package dto.training;

import beans.training.TrainingRecord;

public class TrainingRecordDTO {
	private long id;
	private boolean logicallyDeleted;
	private String dateAndTimeOfApplicationAsString;
	private long trainingId;
	private long buyerId;
	private long trainerId;
	
	public TrainingRecordDTO() {}
	
	public TrainingRecordDTO(long id, boolean logicallyDeleted, 
			String dateAndTimeOfApplicationAsString, long trainingId, long buyerId, 
			long trainerId) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.dateAndTimeOfApplicationAsString = dateAndTimeOfApplicationAsString;
		this.trainingId = trainingId;
		this.buyerId = buyerId;
		this.trainerId = trainerId;
	}
	
	public TrainingRecordDTO(TrainingRecord trainingRecord) {
		this.id = trainingRecord.getId();
		this.logicallyDeleted = trainingRecord.isLogicallyDeleted();
		this.dateAndTimeOfApplicationAsString = 
				trainingRecord.getDateAndTimeOfApplication().toString();
		this.trainingId = trainingRecord.getTraining().getId();
		this.buyerId = trainingRecord.getBuyer().getId();
		if (trainingRecord.getTrainer() != null) {
			this.trainerId = trainingRecord.getTrainer().getId();
		} else {
			this.trainerId = -1;
		}
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
	
	public String getDateAndTimeOfApplicationAsString() {
		return dateAndTimeOfApplicationAsString;
	}
	
	public void setDateAndTimeOfApplicationAsString(String dateAndTimeOfApplicationAsString) {
		this.dateAndTimeOfApplicationAsString = dateAndTimeOfApplicationAsString;
	}
	
	public long getTrainingId() {
		return trainingId;
	}
	
	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}
	
	public long getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	
	public long getTrainerId() {
		return trainerId;
	}
	
	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}
}
