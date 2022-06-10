package dto.membership;

import beans.membership.Membership;
import beans.membership.MembershipStatus;

public class MembershipDTO {
	private String id;
	private boolean logicallyDeleted;
	private long typeId;
	private String dateOfPaymentAsString;
	private String validUntilAsString;
	private int fee;
	private long buyerId;
	private MembershipStatus status;
	private int numberOfTerms;
	
	public MembershipDTO() {}
	
	public MembershipDTO(String id, boolean logicallyDeleted, long typeId, 
			String dateOfPaymentAsString, String validUntilAsString, int fee, 
			long buyerId, MembershipStatus status, int numberOfTerms) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.typeId = typeId;
		this.dateOfPaymentAsString = dateOfPaymentAsString;
		this.validUntilAsString = validUntilAsString;
		this.fee = fee;
		this.buyerId = buyerId;
		this.status = status;
		this.numberOfTerms = numberOfTerms;
	}
	
	public MembershipDTO(Membership membership) {
		this.id = membership.getId();
		this.logicallyDeleted = membership.isLogicallyDeleted();
		this.typeId = membership.getType().getId();
		this.dateOfPaymentAsString = membership.getDateOfPayment().toString();
		this.validUntilAsString = membership.getValidUntil().toString();
		this.fee = membership.getFee();
		this.buyerId = membership.getBuyer().getId();
		this.status = membership.getStatus();
		this.numberOfTerms = membership.getNumberOfTerms();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isLogicallyDeleted() {
		return logicallyDeleted;
	}
	
	public void setLogicallyDeleted(boolean logicallyDeleted) {
		this.logicallyDeleted = logicallyDeleted;
	}
	
	public long getTypeId() {
		return typeId;
	}
	
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
	public String getDateOfPaymentAsString() {
		return dateOfPaymentAsString;
	}
	
	public void setDateOfPaymentAsString(String dateOfPaymentAsString) {
		this.dateOfPaymentAsString = dateOfPaymentAsString;
	}
	
	public String getValidUntilAsString() {
		return validUntilAsString;
	}
	
	public void setValidUntilAsString(String validUntilAsString) {
		this.validUntilAsString = validUntilAsString;
	}
	
	public int getFee() {
		return fee;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	public long getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
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
