$(document).ready(function() {
	$('#usernameInput').focus();
	
	$('#registrationForm').submit(function(event) {
		event.preventDefault();
		
		$('#registrationError').hide();
		
		let validationMessage = isDataValid();
		if (validationMessage === '') {
			let username = $('#usernameInput').val();
			let password = $('#passwordInput').val();
			let firstName = $('#firstNameInput').val();
			let lastName = $('#lastNameInput').val();
			let gender = $('input[name="genderInputRadioGroup"]').val();
			let dateOfBirth = $('#dateOfBirthInput').val();

			$.ajax({
				type: 'POST',
				url: 'api/register-as-a-buyer',
				data: JSON.stringify({id: 0, logicallyDeleted: false, username: username, 
					password: password, firstName: firstName, lastName: lastName, gender: gender, 
					dateOfBirth: dateOfBirth, role: 'BUYER', trainingRecordsIds: [], membershipId: '', 
					ownedVenueId: -1, visitedVenuesIds: [], earnedPoints: 0, buyerTypeId: 1}),
				contentType: 'application/json',
				success: function() {
					$('#registrationSuccess').text('Uspešno ste registrovani kao kupac!');
					$('#registrationSuccess').show().delay(3000).fadeOut();
					
					window.location.href = 'http://localhost:8080/fit-pass/login.html';
				},
				error: function(message) {
					$('#registrationError').text(message.responseText);
					$('#registrationError').show().delay(5000).fadeOut();
				}
			});
		} else {
			alert(validationMessage);
		}
	});
});

function isDataValid() {
	let validationMessage = '';

	let username = $('#usernameInput').val();
	if (!isUsernameValid(username)) {
		validationMessage = 'Korisničko ime mora započeti velikim slovom!';
		return validationMessage;
	}

	let password = $('#passwordInput').val();
	if (!isPasswordValid(password)) {
		validationMessage = 'Lozinka mora sadržati između 5 i 15 znakova!';
		return validationMessage;
	}

	let firstName = $('#firstNameInput').val();
	if (!isNameValid(firstName)) {
		validationMessage = 'Ime mora započeti velikim slovom i ne sme sadržati brojeve!';
		return validationMessage;
	}

	let lastName = $('#lastNameInput').val();
	if (!isNameValid(lastName)) {
		validationMessage = 'Prezime mora započeti velikim slovom i ne sme sadržati brojeve!';
		return validationMessage;
	}

	let gender = $('input[name="genderInputRadioGroup"]').val();
	if (!isGenderValid(gender)) {
		validationMessage = 'Pol mora biti odabran!';
		return validationMessage;
	}

	let dateOfBirth = $('#dateOfBirthInput').val();
	if (!isDateOfBirthValid(dateOfBirth)) {
		validationMessage = 'Datum rođenja mora biti unet u formatu "yyyy-MM-dd"!';
		return validationMessage;
	}

	return validationMessage;
}

function isUsernameValid(username) {
	let usernameRegexp = '/[a-zA-Z][-_a-zA-Z0-9\.]+/g';
	let usernameMatches = username.match(usernameRegexp);

	if (usernameMatches != null) {
		if (typeof usernameMatches === Array) {
			if (usernameMatches === [username]) {
				return true;
			}
		}
	}

	return false;
}

function isPasswordValid(password) {
	if (password != null) {
		if (typeof password === 'string') {
			if (password.length >= 5 && password.length <= 15) {
				return true;
			}
		}
	}

	return false;
}

function isNameValid(name) {
	let nameRegexp = '/[A-Z\p{L}][a-z\p{L}]+([ -][A-Z\p{L}][a-z\p{L}]+)*/g';
	let nameMatches = name.match(nameRegexp);

	if (nameMatches != null) {
		if (typeof nameMatches === Array) {
			if (nameMatches === [name]) {
				return true;
			}
		}
	}

	return false;
}

function isGenderValid(gender) {
	if (gender != null) {
		if (typeof gender === 'string') {
			if (gender === 'MALE' || gender === 'FEMALE') {
				return true;
			}
		}
	}

	return false;
}

function isDateOfBirthValid(dateOfBirth) {
	let dateOfBirthRegexp = '/(19|20)[0-9]{2}-(0[1-9]|1[012])-^(0[1-9]|[12][0-9]|3[01])/g';
	let dateOfBirthMatches = dateOfBirth.match(dateOfBirthRegexp);

	if (dateOfBirthMatches != null) {
		if (typeof dateOfBirthMatches === Array) {
			if (dateOfBirthMatches === [dateOfBirth]) {
				return true;
			}
		}
	}

	return false;
}
