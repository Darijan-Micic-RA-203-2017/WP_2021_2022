package dto.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import beans.training.TrainingRecord;
import beans.user.User;
import beans.venue.Venue;

public class UserDTO {
	private long id;
	private boolean logicallyDeleted;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String role;
	private List<Long> trainingRecordsIds;
	private String membershipId;
	private long ownedVenueId;
	private List<Long> visitedVenuesIds;
	private int earnedPoints;
	private long buyerTypeId;
	
	public UserDTO() {}
	
	public UserDTO(long id, boolean logicallyDeleted, String username, String password, 
			String firstName, String lastName, String gender, String dateOfBirth, 
			String role, List<Long> trainingRecordsIds, String membershipId, 
			long ownedVenueId, List<Long> visitedVenuesIds, int earnedPoints, 
			long buyerTypeId) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
		this.trainingRecordsIds = trainingRecordsIds;
		this.membershipId = membershipId;
		this.ownedVenueId = ownedVenueId;
		this.visitedVenuesIds = visitedVenuesIds;
		this.earnedPoints = earnedPoints;
		this.buyerTypeId = buyerTypeId;
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.logicallyDeleted = user.isLogicallyDeleted();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.gender = user.getGender().toString();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddT:hh:mm:ss");
		this.dateOfBirth = dateFormatter.format(user.getDateOfBirth());
		this.role = user.getRole().toString();
		this.trainingRecordsIds = new ArrayList<Long>();
		for (TrainingRecord tR: user.getTrainingRecords()) {
			this.trainingRecordsIds.add(tR.getId());
		}
		if (user.getMembership() != null) {
			this.membershipId = user.getMembership().getId();
		} else {
			this.membershipId = "";
		}
		if (user.getOwnedVenue() != null) {
			this.ownedVenueId = user.getOwnedVenue().getId();
		} else {
			this.ownedVenueId = -1;
		}
		this.visitedVenuesIds = new ArrayList<Long>();
		for (Venue v: user.getVisitedVenues()) {
			this.visitedVenuesIds.add(v.getId());
		}
		this.earnedPoints = user.getEarnedPoints();
		if (user.getBuyerType() != null) {
			this.buyerTypeId = user.getBuyerType().getId();
		} else {
			this.buyerTypeId = -1;
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Long> getTrainingRecordsIds() {
		return trainingRecordsIds;
	}
	
	public void setTrainingRecordsIds(List<Long> trainingRecordsIds) {
		this.trainingRecordsIds = trainingRecordsIds;
	}
	
	public String getMembershipId() {
		return membershipId;
	}
	
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	
	public long getOwnedVenueId() {
		return ownedVenueId;
	}
	
	public void setOwnedVenueId(long ownedVenueId) {
		this.ownedVenueId = ownedVenueId;
	}
	
	public List<Long> getVisitedVenuesIds() {
		return visitedVenuesIds;
	}
	
	public void setVisitedVenuesIds(List<Long> visitedVenuesIds) {
		this.visitedVenuesIds = visitedVenuesIds;
	}
	
	public int getEarnedPoints() {
		return earnedPoints;
	}
	
	public void setEarnedPoints(int earnedPoints) {
		this.earnedPoints = earnedPoints;
	}
	
	public long getBuyerTypeId() {
		return buyerTypeId;
	}
	
	public void setBuyerTypeId(long buyerTypeId) {
		this.buyerTypeId = buyerTypeId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(id).append(";").append(logicallyDeleted).append(";")
				.append(username).append(";").append(password).append(";")
				.append(firstName).append(";").append(lastName).append(";")
				.append(gender).append(";").append(dateOfBirth).append(";")
				.append(role).append(";").append(trainingRecordsIds).append(";")
				.append(membershipId).append(";").append(ownedVenueId).append(";")
				.append(visitedVenuesIds).append(";").append(earnedPoints).append(";")
				.append(buyerTypeId);
		
		return builder.toString();
	}
}
