package dto.venue;

import beans.venue.Comment;

public class CommentDTO {
	private long id;
	private boolean logicallyDeleted;
	private long buyerId;
	private long venueId;
	private String text;
	private int grade;
	
	public CommentDTO() {}
	
	public CommentDTO(long id, boolean logicallyDeleted, long buyerId, long venueId, 
			String text, int grade) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.buyerId = buyerId;
		this.venueId = venueId;
		this.text = text;
		this.grade = grade;
	}
	
	public CommentDTO(Comment comment) {
		this.id = comment.getId();
		this.logicallyDeleted = comment.isLogicallyDeleted();
		this.buyerId = comment.getBuyer().getId();
		this.venueId = comment.getVenue().getId();
		this.text = comment.getText();
		this.grade = comment.getGrade();
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
	
	public long getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	
	public long getVenueId() {
		return venueId;
	}
	
	public void setVenueId(long venueId) {
		this.venueId = venueId;
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
