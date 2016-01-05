<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<link rel="stylesheet" href="css/thema_style.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url: 'memberSearch',
			type: 'GET',
			success: function(data){
				if(data != null){
					$('input#email').val(data.email);
					$('input#name').val(data.name);
					$('input#location').val(data.location);
					$('select#transportation > option').each(function(index){
						if($(this).val() == data.transportation.toLowerCase()){
							$(this).prop('selected', true);
						}
					});
				}
			}
		});

		$("#modify").click(function() {
			if($(".form").prop('disabled') == true){
				$(".form").prop('disabled', false);
				$(this).val('submit');
			}
			else{
				$(".form").prop('disabled', true);
				$(this).val('Modify');
			}
		});

	});
</script>

<title>Insert title here</title>
</head>
<body>
<header>
	<c:import url="menu.jsp"/>
</header>
<div class="container">
		<div class="component">
			<form id="modifyMemberRequest" method="post" action="modifyMember">
				<h1>User.name</h1>
				<p>
					<input type="email" name="email" id="email" disabled>
				</p>
				<p>
					<input type="text" name="name" class="form" id="name" disabled>
				</p>
				<p>
					<input type="text" name="location" class="form" id="location" disabled>
				</p>

				<p class="contact-input">
					<label for="select" class="select"> 
					<select name="transportation" id="transportation" required class="form" disabled>
							<option value="transit">transit</option>
							<option value="driving">driving</option>
					</select>
					</label>
				</p>
			</form>
			<p class="submit">
				<input type="submit" id="modify" name="commit" value="Modify">
				<a href="<c:url value='/mainPage'/>">
					<input type="button" name="commit" value="cancle">
				</a>
			</p>
		</div>
	</div>
</body>
</html>