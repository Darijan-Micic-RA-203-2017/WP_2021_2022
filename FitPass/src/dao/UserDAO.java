package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import dto.user.UserDTO;

public class UserDAO {
	private HashMap<Long, UserDTO> users = new HashMap<Long, UserDTO>();
	private String contextPath;
	
	public UserDAO() {}
	
	public UserDAO(String contextPath) {
		this.contextPath = contextPath;
		
		loadUsers();
	}
	
	public HashMap<Long, UserDTO> getAllUsers() {
		return users;
	}
	
	public UserDTO findById(long id) {
		return users.get(id);
	}
	
	public UserDTO findByUsername(String username) {
		for (UserDTO u: users.values()) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}
		
		return null;
	}
	
	public UserDTO findByUsernameAndPassword(String username, String password) {
		for (UserDTO u: users.values()) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		
		return null;
	}
	
	public void registerANewBuyer(UserDTO newBuyer) {
		long idOfNewBuyer = generateNewId();
		users.put(idOfNewBuyer, newBuyer);
		
		saveUsers();
	}
	
	private long generateNewId() {
		long maxId = 0;
		for (long id: users.keySet()) {
			if (id > maxId) {
				maxId = id;
			}
		}
		
		long newId = maxId + 1;
		
		return newId;
	}
	
	public UserDTO updateUser(long id, UserDTO modifiedUser) {
		users.put(id, modifiedUser);
		
		return modifiedUser;
	}
	
	private void loadUsers() {
		BufferedReader reader = null;
		try {
			File usersFile = new File(contextPath + "/storage/users.txt");
			reader = new BufferedReader(new FileReader(usersFile));
			
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
					String username = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String password = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String firstName = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String lastName = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String gender = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String dateOfBirth = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String role = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					String trainingRecordsIdsListAsString = 
							stringTokenizer.nextToken().trim();
					ArrayList<Long> trainingRecordsIds = StringToListConverter
							.convertToLongArrayList(trainingRecordsIdsListAsString);
					stringTokenizer.nextToken();
					String possibleMembershipId = stringTokenizer.nextToken().trim();
					String membershipId = "";
					if (!possibleMembershipId.equals(";")) {
						membershipId = possibleMembershipId;
						stringTokenizer.nextToken();
					}
					long ownedVenueId = 
							Long.parseLong(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					String visitedVenuesIdsListAsString = 
							stringTokenizer.nextToken().trim();
					ArrayList<Long> visitedVenuesIds = StringToListConverter
							.convertToLongArrayList(visitedVenuesIdsListAsString);
					stringTokenizer.nextToken();
					int earnedPoints = 
							Integer.parseInt(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					long buyerTypeId = 
							Long.parseLong(stringTokenizer.nextToken().trim());
					
					users.put(id, new UserDTO(id, logicallyDeleted, username, password, 
							firstName, lastName, gender, dateOfBirth, role, 
							trainingRecordsIds, membershipId, ownedVenueId, 
							visitedVenuesIds, earnedPoints, buyerTypeId));
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
	
	public void saveUsers() {
		BufferedWriter writer = null;
		try {
			File usersFile = new File(contextPath + "/storage/users.txt");
			writer = new BufferedWriter(new FileWriter(usersFile));
			
			StringBuilder stringBuilder = new StringBuilder();
			for (UserDTO u: users.values()) {
				stringBuilder.append(u).append("\n");
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
