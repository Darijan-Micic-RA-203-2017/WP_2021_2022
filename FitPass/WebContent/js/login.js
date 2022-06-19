$(document).ready(function() {
	$('#usernameInput').focus();
	
	$('#loginForm').submit(function(event) {
		event.preventDefault();
		
		$('#loginError').hide();
		
		let username = $('#usernameInput').val();
		let password = $('#passwordInput').val();
		
		$.ajax({
			type: 'POST',
			url: 'api/login',
			data: JSON.stringify({username: username, password: password}),
			contentType: 'application/json',
			success: function() {
				$('#loginSuccess').text('Korisnik je uspešno prijavljen!');
				$('#loginSuccess').show().delay(3000).fadeOut();

				window.location.href = 'http://localhost:8080/fit-pass/api/logged-user';
			},
			error: function(message) {
				$('#loginError').text(message.responseText);
				$('#loginError').show().delay(5000).fadeOut();
			}
		});
	});
});