var originalLoggedUser;

$(document).ready(function() {
    resolveAuthorizationButtons();
    
    $.ajax({
        async: true,
        type: 'GET',
        url: 'api/authorization/logged-user',
        dataType: 'json',
        success: function(retrievedLoggedUser) {
            originalLoggedUser = retrievedLoggedUser;

            $('#usernameInput').val(originalLoggedUser['username']);
            $('#passwordInput').val(originalLoggedUser['password']);
            $('#firstNameInput').val(originalLoggedUser['firstName']);
            $('#lastNameInput').val(originalLoggedUser['lastName']);
            $('input[name="genderInputRadioGroup"]').val([originalLoggedUser['gender']]);
            let dateOfBirthWithoutAddedTimeSegment = '';
            if (typeof originalLoggedUser['dateOfBirth'] === 'string') {
                dateOfBirthWithoutAddedTimeSegment = originalLoggedUser['dateOfBirth'].substring(0, 10);
            }
            $('#dateOfBirthInput').val(dateOfBirthWithoutAddedTimeSegment);
            $('#roleInput').val(originalLoggedUser['role']);
            
            resolveFormButtons();
        },
        error: function() {
            alert('Niste prijavljeni!');

            window.location.href = 'index.html';
        }
    });
});

function resolveAuthorizationButtons() {
    $('#registrationAsABuyerButton').click(function() {
        window.location.href = 'registration.html';
    });
    
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
}

function resolveFormButtons() {}

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
