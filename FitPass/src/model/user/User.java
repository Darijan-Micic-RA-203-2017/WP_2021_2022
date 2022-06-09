package model.user;

import java.util.Date;
import java.util.List;

import model.membership.Membership;
import model.training.TrainingRecord;
import model.venue.Venue;

public class User {
	private long id;
	private boolean logicallyDeleted;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date dateOfBirth;
	private UserRole role;
	private List<TrainingRecord> trainingRecords;
	private Membership membership;
	private Venue ownedVenue;
	private List<Venue> visitedVenues;
	private int earnedPoints;
	private BuyerType buyerType;
	
	public User() {}
	
	public User(long id, boolean logicallyDeleted, String username, String password, 
			String firstName, String lastName, Gender gender, Date dateOfBirth, 
			UserRole role, List<TrainingRecord> trainingRecords, Membership membership, 
			Venue ownedVenue, List<Venue> visitedVenues, int earnedPoints, 
			BuyerType buyerType) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
		this.trainingRecords = trainingRecords;
		this.membership = membership;
		this.ownedVenue = ownedVenue;
		this.visitedVenues = visitedVenues;
		this.earnedPoints = earnedPoints;
		this.buyerType = buyerType;
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public List<TrainingRecord> getTrainingRecords() {
		return trainingRecords;
	}
	
	public void setTrainingRecords(List<TrainingRecord> trainingRecords) {
		this.trainingRecords = trainingRecords;
	}
	
	public Membership getMembership() {
		return membership;
	}
	
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	
	public Venue getOwnedVenue() {
		return ownedVenue;
	}
	
	public void setOwnedVenue(Venue ownedVenue) {
		this.ownedVenue = ownedVenue;
	}
	
	public List<Venue> getVisitedVenues() {
		return visitedVenues;
	}
	
	public void setVisitedVenues(List<Venue> visitedVenues) {
		this.visitedVenues = visitedVenues;
	}
	
	public int getEarnedPoints() {
		return earnedPoints;
	}
	
	public void setEarnedPoints(int earnedPoints) {
		this.earnedPoints = earnedPoints;
	}
	
	public BuyerType getBuyerType() {
		return buyerType;
	}
	
	public void setBuyerType(BuyerType buyerType) {
		this.buyerType = buyerType;
	}
}
