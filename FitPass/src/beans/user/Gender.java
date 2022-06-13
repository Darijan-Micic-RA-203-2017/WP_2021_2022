package beans.user;

public enum Gender {
	MALE, FEMALE;
	
	public static Gender parseGender(String s) {
		if (s.equals(Gender.MALE.toString())) {
			return Gender.MALE;
		} else if (s.equals(Gender.FEMALE.toString())) {
			return Gender.FEMALE;
		}
		
		return null;
	}
}
