package model.membership;

import java.util.Date;

import model.user.User;

public class Membership {
	private String id;
	private MembershipType type;
	private Date dateOfPayment;
	private Date validUntil;
	private int fee;
	private User buyer;
	private MembershipStatus status;
	private int numberOfTerms;
	
	public Membership() {}
	
	public Membership(String id, MembershipType type, Date dateOfPayment, 
			Date validUntil, int fee, User buyer, MembershipStatus status, 
			int numberOfTerms) {
		this.id = id;
		this.type = type;
		this.dateOfPayment = dateOfPayment;
		this.validUntil = validUntil;
		this.fee = fee;
		this.buyer = buyer;
		this.status = status;
		this.numberOfTerms = numberOfTerms;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public MembershipType getType() {
		return type;
	}
	
	public void setType(MembershipType type) {
		this.type = type;
	}
	
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	
	public Date getValidUntil() {
		return validUntil;
	}
	
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	
	public int getFee() {
		return fee;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	public User getBuyer() {
		return buyer;
	}
	
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
	public MembershipStatus getStatus() {
		return status;
	}
	
	public void setStatus(MembershipStatus status) {
		this.status = status;
	}
	
	public int getNumberOfTerms() {
		return numberOfTerms;
	}
	
	public void setNumberOfTerms(int numberOfTerms) {
		this.numberOfTerms = numberOfTerms;
	}
}
