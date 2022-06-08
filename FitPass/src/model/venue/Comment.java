package model.venue;

import model.user.User;

public class Comment {
	private long id;
	private User buyer;
	private Venue venue;
	private String text;
	private int grade;
	
	public Comment() {}
	
	public Comment(long id, User buyer, Venue venue, String text, int grade) {
		this.id = id;
		this.buyer = buyer;
		this.venue = venue;
		this.text = text;
		this.grade = grade;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public User getBuyer() {
		return buyer;
	}
	
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
	public Venue getVenue() {
		return venue;
	}
	
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
