package beans.venue;

public enum VenueStatus {
	WORKING, NOT_WORKING;
	
	public static VenueStatus parseVenueStatus(String s) {
		if (s.equals(VenueStatus.WORKING.toString())) {
			return VenueStatus.WORKING;
		} else if (s.equals(VenueStatus.NOT_WORKING.toString())) {
			return VenueStatus.NOT_WORKING;
		}
		
		return null;
	}
}
