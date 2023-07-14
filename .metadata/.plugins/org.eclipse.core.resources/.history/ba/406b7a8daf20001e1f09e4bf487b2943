$(document).ready(function() {
	$('#check-button').click(function(e) {
		var cnp = $('#cnp').val();
		$.ajax ({
		type: 'post',
		url: 'validator',
		data: {
			cnp: cnp
		},
		success: function(resp) {
			$('#msg').html(resp);
		},
		error: function (jqXHR, exception) {
			console.log('Error occured!!');
			}
		});
		e.preventDefault();
	});
});