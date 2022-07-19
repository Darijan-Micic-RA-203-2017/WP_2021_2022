package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.location.Address;

public class AddressDAO {
	private HashMap<Long, Address> addresses = new HashMap<Long, Address>();
	private String contextPath;
	
	public AddressDAO() {}
	
	public AddressDAO(String contextPath) {
		this.contextPath = contextPath;
		
		loadAddresses();
	}
	
	public HashMap<Long, Address> getAllAddresses() {
		return addresses;
	}
	
	public Address findById(long id) {
		for (Address a: addresses.values()) {
			if (a.getId() == id) {
				return a;
			}
		}
		
		return null;
	}
	
	private void loadAddresses() {
		BufferedReader reader = null;
		try {
			File addressesFile = new File(contextPath + "/storage/addresses.txt");
			reader = new BufferedReader(new FileReader(addressesFile));
			
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
					String street = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String number = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String populatedPlace = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String postalCode = stringTokenizer.nextToken().trim();
					
					addresses.put(id, new Address(id, logicallyDeleted, street, 
							number, populatedPlace, postalCode));
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
	
	public void saveAddresses() {
		BufferedWriter writer = null;
		try {
			File addressesFile = new File(contextPath + "/storage/addresses.txt");
			writer = new BufferedWriter(new FileWriter(addressesFile));
			
			StringBuilder stringBuilder = new StringBuilder();
			for (Address a: addresses.values()) {
				stringBuilder.append(a).append("\n");
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
