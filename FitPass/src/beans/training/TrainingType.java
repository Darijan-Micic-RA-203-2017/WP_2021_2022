package beans.training;

public class TrainingType {
	private long id;
	private boolean logicallyDeleted;
	private String name;
	
	public TrainingType() {}
	
	public TrainingType(long id, boolean logicallyDeleted, String name) {
		this.id = id;
		this.logicallyDeleted = logicallyDeleted;
		this.name = name;
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
}
