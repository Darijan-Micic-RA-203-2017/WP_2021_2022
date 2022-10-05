$(document).ready(function() {
    resolveAuthorizationButtons();
    
    $.ajax({
        async: true,
        type: 'GET',
        url: 'api/authorization/logged-user',
        dataType: 'json',
        success: function(retrievedLoggedUser) {
            $('.navbarContentForAuthenticatedUsers').show();
            $('.navbarContentForAuthenticatedUsers').prop('hidden', false);
            
            if (retrievedLoggedUser['role'] == 'ADMINISTRATOR') {
                $('.navbarContentForAdministrators').show();
                $('.navbarContentForAdministrators').prop('hidden', false);
            }
            
            fillOutUserDataForm();
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

function fillOutUserDataForm() {
    let clickedUserProfileURL = localStorage.getItem('clickedUserProfileURL');
    if (clickedUserProfileURL == null) {
        window.location.href = 'my-profile.html';

        return;
    }

    $.ajax({
        async: true,
        type: 'GET',
        url: clickedUserProfileURL,
        dataType: 'json',
        success: function(retrievedUser) {
            document.title = 'Profil korisnika "' + retrievedUser['username'] + '"';
            
            $('#usernameInput').val(retrievedUser['username']);
            $('#firstNameInput').val(retrievedUser['firstName']);
            $('#lastNameInput').val(retrievedUser['lastName']);
            $('input[name="genderInputRadioGroup"]').val([retrievedUser['gender']]);
            let dateOfBirthWithoutAddedTimeSegment = '';
            if (typeof retrievedUser['dateOfBirth'] === 'string') {
                dateOfBirthWithoutAddedTimeSegment = retrievedUser['dateOfBirth'].substring(0, 10);
            }
            $('#dateOfBirthInput').val(dateOfBirthWithoutAddedTimeSegment);
            $('#roleSelect').val(retrievedUser['role']);
        },
        error: function(message) {
            alert(message.responseText);
        }
    });
}
