$(document).ready(function() {
	resolveAuthorizationButtons();

	$('#usernameInput').focus();
	
	$('#loginForm').submit(function(event) {
		event.preventDefault();
		
		let username = $('#usernameInput').val();
		let password = $('#passwordInput').val();
		
		$.ajax({
			async: true,
			type: 'POST',
			url: 'api/authorization/login',
			data: JSON.stringify({username: username, password: password}),
			contentType: 'application/json',
			success: function() {
				alert('Uspešno ste se prijavili!');
				
				window.location.href = 'user-profile.html';
			},
			error: function(message) {
				alert(message.responseText);
			}
		});
	});
});

function resolveAuthorizationButtons() {
	$('#registrationAsABuyerButton').click(function() {
		window.location.href = 'registration.html';
	});
}
