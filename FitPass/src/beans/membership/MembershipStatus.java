package beans.membership;

public enum MembershipStatus {
	ACTIVE, NON_ACTIVE;
	
	public static MembershipStatus parseMembershipStatus(String s) {
		if (s.equals(MembershipStatus.ACTIVE.toString())) {
			return MembershipStatus.ACTIVE;
		} else if (s.equals(MembershipStatus.NON_ACTIVE.toString())) {
			return MembershipStatus.NON_ACTIVE;
		}
		
		return null;
	}
}
