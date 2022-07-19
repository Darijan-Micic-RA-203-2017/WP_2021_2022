package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.venue.VenueType;

public class VenueTypeDAO {
	private HashMap<Long, VenueType> venueTypes = new HashMap<Long, VenueType>();
	private String contextPath;
	
	public VenueTypeDAO() {}
	
	public VenueTypeDAO(String contextPath) {
		this.contextPath = contextPath;
		
		loadVenueTypes();
	}
	
	public HashMap<Long, VenueType> getAllVenueTypes() {
		return venueTypes;
	}
	
	public VenueType findById(long id) {
		for (VenueType vType: venueTypes.values()) {
			if (vType.getId() == id) {
				return vType;
			}
		}
		
		return null;
	}
	
	public VenueType findByName(String name) {
		for (VenueType vType: venueTypes.values()) {
			if (vType.getName().equals(name)) {
				return vType;
			}
		}
		
		return null;
	}
	
	private void loadVenueTypes() {
		BufferedReader reader = null;
		try {
			File venueTypesFile = new File(contextPath + "/storage/venueTypes.txt");
			reader = new BufferedReader(new FileReader(venueTypesFile));
			
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
					
					venueTypes.put(id, new VenueType(id, logicallyDeleted, name));
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
	
	public void saveVenueTypes() {
		BufferedWriter writer = null;
		try {
			File venueTypesFile = new File(contextPath + "/storage/venueTypes.txt");
			writer = new BufferedWriter(new FileWriter(venueTypesFile));
			
			StringBuilder stringBuilder = new StringBuilder();
			for (VenueType vType: venueTypes.values()) {
				stringBuilder.append(vType).append("\n");
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
