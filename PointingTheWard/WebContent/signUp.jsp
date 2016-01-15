<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<link rel="stylesheet" href="css/signUp/signUp.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/validation/validation.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('input#certificationBtn').click(function(){
			var email = $('input#email').val();
			if(email != '' && emailValidation(email) == true){
				$('div#emailFormGroup').attr('class', 'form-group has-success has-feedback');
				$($('input#email').next()[0]).attr('class', 'glyphicon glyphicon-ok form-control-feedback');
				$(this).val('re send');
				
				$.ajax({
					url: 'certification',
					type: 'GET',
					data: {
						email: email},
					success: function(data){
						if(data.result == 'true'){
							$('div#certificationArea').prop('hidden', false);
							var domain = data.email.split('@')[1];
							window.open('http://www.' + domain, '', '', '');
						}else{
							$('div#emailFormGroup').attr('class', 'form-group has-warning has-feedback');
							$($('input#email').val('').attr('placeholder', data.message).next()[0]).attr('class', 'glyphicon glyphicon-warning-sign form-control-feedback');
						}
					}
				});
			}else{
				$('div#emailFormGroup').attr('class', 'form-group has-warning has-feedback');
				$($('input#email').val('').attr('placeholder', 'please enter email').next()[0]).attr('class', 'glyphicon glyphicon-warning-sign form-control-feedback');
			}
		});
		
		$('input#certificationConfirmBtn').click(function(){
			$.ajax({
				url: 'certification',
				type: 'POST',
				data: {code: $('input#certificationConfirm').val()},
				success: function(data){
					if(data == true){
						$('.form-control').prop('disabled', false);
						$('input#email').prop('readonly', true);
						$('div#certificationArea').prop('hidden', true);
						$('input#certificationBtn').css('display', 'none');
						$('input#signUpBtn').prop('disabled', false);
					}else{
						$('div#certificationArea').attr('class', 'form-group has-warning has-feedback');
						$($('input#certificationConfirm').val('').attr('placeholder', 'nonvalidated certification code').next()[0]).attr('class', 'glyphicon glyphicon-warning-sign form-control-feedback');
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
	  <div class="panel panel-default">
	  	<div class="panel-body">
	  		<form class="form-horizontal" role="form" id="signUpMemberRequest" method="post" action="member">
			    <div id="emailFormGroup" class="form-group">
			      <label class="control-label col-sm-2" for="email">Email:</label>
			      <div class="col-sm-10">
			        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
			        <span></span>
			        <input type="button" id="certificationBtn" class="btn btn-default" value="send">
			      </div>
			    </div>
			    <div class="form-group" hidden="hidden" id="certificationArea">
			      <label class="control-label col-sm-2" for="email">Certification Code:</label>
			      <div class="col-sm-10">
			        <input type="text" id="certificationConfirm" name="certificationConfirm" class="form-control" value="" placeholder="certification code">
			        <span></span>
					<input type="button" id="certificationConfirmBtn" class="btn btn-default" value="confirm">
			      </div>
			    </div>
		    	<div class="form-group">
			      <label class="control-label col-sm-2" for="pwd">Password:</label>
			      <div class="col-sm-10">          
			        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password" required disabled>
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="pwd">Confirm:</label>
			      <div class="col-sm-10">          
			        <input type="password" class="form-control" id="pwdCheck" name="pwdCheck" placeholder="Enter password" required disabled>
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="text">Name:</label>
			      <div class="col-sm-10">          
			        <input type="text" class="form-control" name="name" placeholder="Enter name" required disabled>
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="text">Location:</label>
			      <div class="col-sm-10">          
			        <input type="text" class="form-control" name="location" placeholder="Enter location" required disabled>
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="select">Transportation:</label>
			      <div class="col-sm-10">          
			        <select name="transportation" id="transportation" class="form-control" required disabled>
							<option value="" selected>Choose Transportation…</option>
							<option value="transit">transit</option>
							<option value="driving">driving</option>
					</select>
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <input type="submit" class="btn btn-default" id="signUpBtn" value="SignUp" disabled>
			        <a href='<c:url value="/signInPage"/>'>
			        	<input type="button" class="btn btn-default" value="Cancel"/>
			        </a>
			      </div>
			    </div>
		  </form>
	  	</div>
	  </div>
	</div>
</body>
</html>