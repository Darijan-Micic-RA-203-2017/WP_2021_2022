package model.user;

public class BuyerType {
	private long id;
	private String name;
	private int membershipFeeDiscount;
	private int requiredPoints;
	
	public BuyerType() {}
	
	public BuyerType(long id, String name, int membershipFeeDiscount, int requiredPoints) {
		this.id = id;
		this.name = name;
		this.membershipFeeDiscount = membershipFeeDiscount;
		this.requiredPoints = requiredPoints;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMembershipFeeDiscount() {
		return membershipFeeDiscount;
	}
	
	public void setMembershipFeeDiscount(int membershipFeeDiscount) {
		this.membershipFeeDiscount = membershipFeeDiscount;
	}
	
	public int getRequiredPoints() {
		return requiredPoints;
	}
	
	public void setRequiredPoints(int requiredPoints) {
		this.requiredPoints = requiredPoints;
	}
}
