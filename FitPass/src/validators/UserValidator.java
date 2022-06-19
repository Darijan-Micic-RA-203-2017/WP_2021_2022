package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.user.Gender;
import beans.user.UserRole;
import dto.user.UserDTO;

public class UserValidator {
	public UserValidator() {}
	
	public static boolean isNewlyRegisteredBuyerDTOValid(UserDTO userDTO) {
		boolean newlyRegisteredBuyerDTOValidity = true;
		
		if (!isUsernameValid(userDTO.getUsername())) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (!isPasswordValid(userDTO.getPassword())) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (!isNameValid(userDTO.getFirstName())) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (!isNameValid(userDTO.getLastName())) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (!isGenderValid(userDTO.getGender())) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (!isDateOfBirthValid(userDTO.getDateOfBirth())) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (userDTO.getRole() != null) {
			if (!userDTO.getRole().equals(UserRole.BUYER.toString())) {
				newlyRegisteredBuyerDTOValidity = false;
			}
		} else {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (userDTO.getTrainingRecordsIds() != null) {
			if (!userDTO.getTrainingRecordsIds().isEmpty()) {
				newlyRegisteredBuyerDTOValidity = false;
			}
		} else {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (userDTO.getMembershipId() != null) {
			if (!userDTO.getMembershipId().equals("")) {
				newlyRegisteredBuyerDTOValidity = false;
			}
		} else {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (userDTO.getOwnedVenueId() != -1) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (userDTO.getVisitedVenuesIds() != null) {
			if (!userDTO.getVisitedVenuesIds().isEmpty()) {
				newlyRegisteredBuyerDTOValidity = false;
			}
		} else {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (userDTO.getEarnedPoints() != 0) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		if (userDTO.getBuyerTypeId() != 1) {
			newlyRegisteredBuyerDTOValidity = false;
		}
		
		return newlyRegisteredBuyerDTOValidity;
	}
	
	public static boolean isUserDTOValid(UserDTO userDTO) {
		boolean userDTOValidity = true;
		
		if (!isUsernameValid(userDTO.getUsername())) {
			userDTOValidity = false;
		}
		
		if (!isPasswordValid(userDTO.getPassword())) {
			userDTOValidity = false;
		}
		
		if (!isNameValid(userDTO.getFirstName())) {
			userDTOValidity = false;
		}
		
		if (!isNameValid(userDTO.getLastName())) {
			userDTOValidity = false;
		}
		
		if (!isGenderValid(userDTO.getGender())) {
			userDTOValidity = false;
		}
		
		if (!isDateOfBirthValid(userDTO.getDateOfBirth())) {
			userDTOValidity = false;
		}
		
		if (!isRoleValid(userDTO.getRole())) {
			userDTOValidity = false;
		}
		
		if (userDTO.getTrainingRecordsIds() == null) {
			userDTOValidity = false;
		}
		
		if (!isMembershipIdValid(userDTO.getMembershipId())) {
			userDTOValidity = false;
		}
		
		if (userDTO.getOwnedVenueId() == 0) {
			userDTOValidity = false;
		}
		
		if (userDTO.getVisitedVenuesIds() == null) {
			userDTOValidity = false;
		}
		
		if (userDTO.getEarnedPoints() < 0) {
			userDTOValidity = false;
		}
		
		if (userDTO.getBuyerTypeId() == 0) {
			userDTOValidity = false;
		}
		
		return userDTOValidity;
	}
	
	private static boolean isUsernameValid(String username) {
		if (username == null) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("[a-zA-Z][-_a-zA-Z0-9\\.]+");
		Matcher matcher = pattern.matcher(username);
		if (!matcher.matches()) {
			return false;
		}
		
		return true;
	}
	
	private static boolean isPasswordValid(String password) {
		if (password == null) {
			return false;
		}
		
		if (password.length() < 5 || password.length() > 15) {
			return false;
		}
		
		return true;
	}
	
	private static boolean isNameValid(String name) {
		if (name == null) {
			return false;
		}
		
		Pattern pattern = Pattern
				.compile("[A-Z\\p{L}][a-z\\p{L}]+([ -][A-Z\\p{L}][a-z\\p{L}]+)*");
		Matcher matcher = pattern.matcher(name);
		if (!matcher.matches()) {
			return false;
		}
		
		return true;
	}
	
	private static boolean isGenderValid(String gender) {
		if (gender == null) {
			return false;
		}
		
		if (gender.equals(Gender.MALE.toString()) || 
				gender.equals(Gender.FEMALE.toString())) {
			return true;
		}
		
		return false;
	}
	
	private static boolean isDateOfBirthValid(String dateOfBirth) {
		if (dateOfBirth == null) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("(19|20)[0-9]{2}-" + 
				"(0[1-9]|1[012])-^(0[1-9]|[12][0-9]|3[01])T" + 
				"(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");
		Matcher matcher = pattern.matcher(dateOfBirth);
		if (!matcher.matches()) {
			return false;
		}
		
		return true;
	}
	
	private static boolean isRoleValid(String role) {
		if (role == null) {
			return false;
		}
		
		if (role.equals(UserRole.ADMINISTRATOR.toString()) || 
				role.equals(UserRole.VENUE_MANAGER.toString()) || 
				role.equals(UserRole.TRAINER.toString()) || 
				role.equals(UserRole.BUYER.toString())) {
			return true;
		}
		
		return false;
	}
	
	private static boolean isMembershipIdValid(String membershipId) {
		if (membershipId == null) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("[A-Za-z0-9]{10}");
		Matcher matcher = pattern.matcher(membershipId);
		if (!matcher.matches()) {
			return false;
		}
		
		return true;
	}
}
