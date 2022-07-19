package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import dto.location.LocationDTO;

public class LocationDAO {
	private HashMap<Long, LocationDTO> locations = new HashMap<Long, LocationDTO>();
	private String contextPath;
	
	public LocationDAO() {}
	
	public LocationDAO(String contextPath) {
		this.contextPath = contextPath;
		
		loadLocations();
	}
	
	public HashMap<Long, LocationDTO> getAllLocations() {
		return locations;
	}
	
	public LocationDTO findById(long id) {
		for (LocationDTO l: locations.values()) {
			if (l.getId() == id) {
				return l;
			}
		}
		
		return null;
	}
	
	private void loadLocations() {
		BufferedReader reader = null;
		try {
			File locationsFile = new File(contextPath + "/storage/locations.txt");
			reader = new BufferedReader(new FileReader(locationsFile));
			
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
					double latitude = 
							Double.parseDouble(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					double longitude = 
							Double.parseDouble(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					long addressId = 
							Long.parseLong(stringTokenizer.nextToken().trim());
					
					locations.put(id, new LocationDTO(id, logicallyDeleted, latitude, 
							longitude, addressId));
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
	
	public void saveLocations() {
		BufferedWriter writer = null;
		try {
			File locationsFile = new File(contextPath + "/storage/locations.txt");
			writer = new BufferedWriter(new FileWriter(locationsFile));
			
			StringBuilder stringBuilder = new StringBuilder();
			for (LocationDTO l: locations.values()) {
				stringBuilder.append(l).append("\n");
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
