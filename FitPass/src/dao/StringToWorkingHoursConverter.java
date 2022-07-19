package dao;

import java.util.StringTokenizer;

import beans.venue.WorkingHours;

public class StringToWorkingHoursConverter {
	public StringToWorkingHoursConverter() {}
	
	public static WorkingHours convertToWorkingHours(String workingHoursAsString) {
		workingHoursAsString = workingHoursAsString.substring(1, 
				workingHoursAsString.length() - 1);
		
		WorkingHours workingHours = new WorkingHours();
		
		StringTokenizer stringTokenizer = 
				new StringTokenizer(workingHoursAsString, ",", true);
		while (stringTokenizer.hasMoreTokens()) {
			String openingHoursSegment = stringTokenizer.nextToken().trim();
			workingHours.setOpeningHours(openingHoursSegment);
			
			stringTokenizer.nextToken();
			
			String closingHoursSegment = stringTokenizer.nextToken().trim();
			workingHours.setClosingHours(closingHoursSegment);
		}
		
		return workingHours;
	}
}
