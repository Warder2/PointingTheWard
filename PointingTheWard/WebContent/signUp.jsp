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
			$(this).val('re send');
			$.ajax({
				url: 'certification',
				type: 'GET',
				data: {
					email: $('input#email').val()},
				success: function(data){
					if(data.result){
						$('p#certificationArea').prop('hidden', false);
						var domain = data.email.split('@')[1];
						window.open('http://www.' + domain, '', '', '');
					}else{
						alert(data.message);
					}
				}
			});
		});
		
		$('input#certificationConfirmBtn').click(function(){
			$.ajax({
				url: 'certification',
				type: 'POST',
				data: {code: $('input#certificationConfirm').val()},
				success: function(data){
					if(data == true){
						$('.memberInfoInputs').prop('readonly', false);
						$('select#transportation').prop('hidden', false);
						$('input#email').prop('readonly', true);
						$('p#certificationArea').prop('hidden', true);
						$('input#certificationBtn').prop('hidden', true);
					}else{
						alert('mismatched code');
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
			<form id="signUpMemberRequest" method="post" action="signUp">
				<p>
					<input type="email" id="email" name="email" value="" placeholder="e-mail">
					<input type="button" id="certificationBtn" value="send">
				</p>
				<p id="certificationArea" hidden>
					<input type="text" id="certificationConfirm" name="certificationConfirm" value="" placeholder="certification code">
					<input type="button" id="certificationConfirmBtn" value="confirm">
				</p>
				<p>
					<input type="password" name="pwd" value="" class="memberInfoInputs" placeholder="Password" required readonly>
				</p>
				<p>
					<input type="password" name="pwdCheck" class="memberInfoInputs" value="" placeholder="Password Check" required readonly>
				</p>

				<p>
					<input type="text" name="name" value="" class="memberInfoInputs" placeholder="Name" required readonly>
				</p>

				<p>
					<input type="text" name="location" value="" class="memberInfoInputs" placeholder="location" required readonly>
				</p>

				<p class="contact-input">
						<select name="transportation" id="transportation" required hidden>
								<option value="" selected>Choose Transportation…</option>
								<option value="transit">transit</option>
								<option value="driving">driving</option>
						</select>
					<!-- <label for="select" class="select"> 
					</label> -->
				</p>

				<p class="submit">
					<input type="submit" name="commit" value="Sign Up"> 
					<input type="submit" name="commit" value="Cancel">
				</p>
			</form>
		</div>
	</div>
</body>
</html>