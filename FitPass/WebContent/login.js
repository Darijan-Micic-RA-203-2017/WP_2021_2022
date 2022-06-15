$(document).ready(function() {
	$('#loginForm').submit(function(event) {
		event.preventDefault();
		
		$('#loginError').hide();
		
		let username = $('input[name="username"]').val();
		let password = $('input[name="password"]').val();
		
		$.ajax({
			type: 'POST',
			url: 'api/login',
			data: JSON.stringify({username: username, password: password}),
			contentType: 'application/json',
			success: function() {
				$('#loginSuccess').text('Korisnik je uspešno prijavljen!');
				$('#loginSuccess').show();
				//$('#loginSuccess').show().delay(3000).fadeOut();
			},
			error: function(message) {
				$('#loginError').text(message.responseText);
				$('#loginError').show();
				//$('#loginError').show().delay(5000).fadeOut();
			}
		});
	});
});
