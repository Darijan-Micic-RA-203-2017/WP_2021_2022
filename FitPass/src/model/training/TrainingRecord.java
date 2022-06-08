package model.training;

import java.util.Date;

import model.user.User;

public class TrainingRecord {
	private long id;
	private Date dateAndTimeOfApplication;
	private Training training;
	private User buyer;
	private User trainer;
	
	public TrainingRecord() {}
	
	public TrainingRecord(long id, Date dateAndTimeOfApplication, Training training, 
			User buyer, User trainer) {
		this.id = id;
		this.dateAndTimeOfApplication = dateAndTimeOfApplication;
		this.training = training;
		this.buyer = buyer;
		this.trainer = trainer;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDateAndTimeOfApplication() {
		return dateAndTimeOfApplication;
	}
	
	public void setDateAndTimeOfApplication(Date dateAndTimeOfApplication) {
		this.dateAndTimeOfApplication = dateAndTimeOfApplication;
	}
	
	public Training getTraining() {
		return training;
	}
	
	public void setTraining(Training training) {
		this.training = training;
	}
	
	public User getBuyer() {
		return buyer;
	}
	
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
	public User getTrainer() {
		return trainer;
	}
	
	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}
}
