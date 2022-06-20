package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.venue.WorkingHours;
import dto.venue.VenueDTO;

public class VenueDAO {
	private HashMap<Long, VenueDTO> venues = new HashMap<Long, VenueDTO>();
	private String contextPath;
	
	public VenueDAO() {}
	
	public VenueDAO(String contextPath) {
		this.contextPath = contextPath;
		
		loadVenues();
	}
	
	public HashMap<Long, VenueDTO> getAllVenues() {
		return venues;
	}
	
	public VenueDTO findByName(String name) {
		for (VenueDTO v: venues.values()) {
			if (v.getName().equals(name)) {
				return v;
			}
		}
		
		return null;
	}
	
	private void loadVenues() {
		BufferedReader reader = null;
		try {
			File venuesFile = new File(contextPath + "/storage/venues.txt");
			reader = new BufferedReader(new FileReader(venuesFile));
			
			String line;
			StringTokenizer stringTokenizer;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0) {
					continue;
				}
				
				stringTokenizer = new StringTokenizer(line, ";", true);
				while (stringTokenizer.hasMoreTokens()) {
					long id = 
							Long.parseLong(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					boolean logicallyDeleted = 
							Boolean.parseBoolean(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					String name = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					long typeId = 
							Long.parseLong(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					String contentsIdsListAsString = 
							stringTokenizer.nextToken().trim();
					ArrayList<Long> contentsIds = StringToListConverter
							.convertToLongArrayList(contentsIdsListAsString);
					stringTokenizer.nextToken();
					String status = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					Long locationId = 
							Long.parseLong(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					String logoPath = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					double averageGrade = 
							Double.parseDouble(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					String workingHoursAsString = stringTokenizer.nextToken().trim();
					WorkingHours workingHours = StringToWorkingHoursConverter
							.convertToWorkingHours(workingHoursAsString);
					
					venues.put(id, new VenueDTO(id, logicallyDeleted, name, typeId, 
							contentsIds, status, locationId, logoPath, averageGrade, 
							workingHours));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void saveVenues() {
		BufferedWriter writer = null;
		try {
			File venuesFile = new File(contextPath + "/storage/venues.txt");
			writer = new BufferedWriter(new FileWriter(venuesFile));
			
			StringBuilder stringBuilder = new StringBuilder();
			for (VenueDTO v: venues.values()) {
				stringBuilder.append(v).append("\n");
			}
			
			writer.write(stringBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
