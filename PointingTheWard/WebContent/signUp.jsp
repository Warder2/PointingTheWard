<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<link rel="stylesheet" href="css/thema_style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('input#certificationBtn').click(function(){
			$.ajax({
				url: 'sendCertificationCode',
				type: 'GET',
				data: {
					email: $('input#email').val()},
				success: function(data){
					if(data != 'false'){
						var domain = data.split('@')[1];
						window.open('http://www.' + domain, '', '', '');
					}
				}
			});
		});
	});
</script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h1>Sign Up</h1>
			<form id="signUpMember" method="post" action="signUp">
				<p>
					<input type="email" id="email" name="email" value="" placeholder="e-mail">
					<input type="button" id="certificationBtn" value="send">
				</p>
				<p>
					<input type="password" name="pwd" value=""
						placeholder="Password" required>
				</p>
				<p>
					<input type="password" name="pwdCheck" value=""
						placeholder="Password Check" required>
				</p>

				<p>
					<input type="text" name="name" value="" placeholder="Name" required>
				</p>

				<p>
					<input type="text" name="location" value="" placeholder="location" required><input
						type="submit" name="commit" value="check" required>
				</p>

				<p class="contact-input">
					<label for="select" class="select"> <select name="subject"
						id="select" required>
							<option value="" selected>Choose Transportation…</option>
							<option value="1">My Car</option>
							<option value="1">Bus</option>
							<option value="1">Subway</option>
							<option value="1">축지법</option>
							<option value="1">낙타</option>
					</select>
					</label>
				</p>

				<p class="submit">
					<input type="submit" name="commit" value="Sign Up"> <input
						type="submit" name="commit" value="Cancel">
				</p>
			</form>
		</div>
	</div>
</body>
</html>