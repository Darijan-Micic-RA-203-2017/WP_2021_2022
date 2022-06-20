$(document).ready(function() {
	$('#usernameInput').focus();
	
	$('#loginForm').submit(function(event) {
		event.preventDefault();
		
		let username = $('#usernameInput').val();
		let password = $('#passwordInput').val();
		
		$.ajax({
			type: 'POST',
			url: 'api/login',
			data: JSON.stringify({username: username, password: password}),
			contentType: 'application/json',
			success: function() {
				alert('Korisnik je uspešno prijavljen!');
				
				window.location.href = 'http://localhost:8080/fit-pass/api/logged-user';
			},
			error: function(message) {
				alert(message.responseText);
			}
		});
	});
});
