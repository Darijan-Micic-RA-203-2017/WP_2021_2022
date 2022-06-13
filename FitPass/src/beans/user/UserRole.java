package beans.user;

public enum UserRole {
	ADMINISTRATOR, VENUE_MANAGER, TRAINER, BUYER;
	
	public static UserRole parseUserRole(String s) {
		if (s.equals(UserRole.ADMINISTRATOR.toString())) {
			return UserRole.ADMINISTRATOR;
		} else if (s.equals(UserRole.VENUE_MANAGER.toString())) {
			return UserRole.VENUE_MANAGER;
		} else if (s.equals(UserRole.TRAINER.toString())) {
			return UserRole.TRAINER;
		} else if (s.equals(UserRole.BUYER.toString())) {
			return UserRole.BUYER;
		}
		
		return null;
	}
}
