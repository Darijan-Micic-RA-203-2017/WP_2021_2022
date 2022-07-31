$(document).ready(function() {
	resolveAuthorizationButtons();

	$('#usernameInput').focus();
	
	$('#registrationForm').submit(function(event) {
		event.preventDefault();
		
		let validationMessage = isDataValid();
		if (validationMessage === '') {
			let username = $('#usernameInput').val();
			let password = $('#passwordInput').val();
			let firstName = $('#firstNameInput').val();
			let lastName = $('#lastNameInput').val();
			let gender = $('input[name="genderInputRadioGroup"]').val();
			let dateOfBirth = $('#dateOfBirthInput').val();
			let dateOfBirthWithAddedTimeSegment = '';
			if (typeof dateOfBirth === 'string') {
				dateOfBirthWithAddedTimeSegment = dateOfBirth.concat('T00:00:00');
			}

			$.ajax({
				async: true,
				type: 'POST',
				url: 'api/authorization/register-as-a-buyer',
				data: JSON.stringify({id: 0, logicallyDeleted: false, username: username, 
					password: password, firstName: firstName, lastName: lastName, gender: gender, 
					dateOfBirth: dateOfBirthWithAddedTimeSegment, role: 'BUYER', 
					trainingRecordsIds: [], membershipId: '', ownedVenueId: -1, visitedVenuesIds: [], 
					earnedPoints: 0, buyerTypeId: 1}),
				contentType: 'application/json',
				success: function() {
					alert('Uspešno ste registrovani kao kupac!');
					
					window.location.href = 'login.html';
				},
				error: function(message) {
					alert(message.responseText);
				}
			});
		} else {
			alert(validationMessage);
		}
	});
});

function resolveAuthorizationButtons() {
    $.ajax({
		async: true,
        type: 'GET',
        url: 'api/authorization/logged-user',
        dataType: 'json',
        success: function() {
            $('#loginButton').hide();
            
            $('#logoutButton').show();
            $('#logoutButton').removeAttr('hidden');
			$('#logoutButton').click(function() {
				$.ajax({
					async: true,
					type: 'POST',
					url: 'api/authorization/logout',
					data: '',
					success: function() {
						alert('Korisnik je uspešno odjavljen!');
						
						window.location.href = 'index.html';
					},
					error: function(message) {
						alert(message.responseText);
					}
				});
			});
        },
        error: function() {
            $('#loginButton').show();
            $('#loginButton').removeAttr('hidden');
			$('#loginButton').click(function() {
				window.location.href = 'login.html';
			});

            $('#logoutButton').hide();
        }
    });
}

function isDataValid() {
	let validationMessage = '';

	let username = $('#usernameInput').val();
	if (!isUsernameValid(username)) {
		validationMessage = 'Korisničko ime mora početi slovom, ne sme sadržati razmake i ' + 
			'specijalne znakove (osim povlake, donje crte i tačke)!';
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
	if (typeof username !== 'string') {
		return false;
	}

	let usernameRegexp = /^[a-zA-Z][-_a-zA-Z0-9\.]+$/;
	if (usernameRegexp.test(username)) {
		return true;
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
	if (typeof name !== 'string') {
		return false;
	}

	let nameRegexp = /^[A-Z\p{L}][a-z\p{L}]+([ -][A-Z\p{L}][a-z\p{L}]+)*$/u;
	if (nameRegexp.test(name)) {
		return true;
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
	if (typeof dateOfBirth !== 'string') {
		return false;
	}

	let dateOfBirthRegexp = /^(19|20)[0-9]{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/;
	if (dateOfBirthRegexp.test(dateOfBirth)) {
		return true;
	}
	
	return false;
}
