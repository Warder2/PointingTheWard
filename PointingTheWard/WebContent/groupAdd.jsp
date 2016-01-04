<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<link rel="stylesheet" href="css/thema_style.css">
<link rel="stylesheet" href="css/list_style.css">

<script>
	$(document).ready(function() {

		$(".flip").each(function(i) {
			$(this).on("click", {
				x : i
			}, function(event) {

				$("#" + event.data.x).slideToggle("slow");
			});
		});
	});
</script>


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h2>Group Add</h2>
			
			<p>
				<input type="text" name="name" value=""
					placeholder="group name" required>
			</p>
			<div class="flip">친구 목록</div>
			<div class="panel" id="0">
				<c:forEach var="friend" items="${fList}">
					<fieldset>
						<legend>${friend.name}</legend>
						<input type="checkbox">${friend.email}
					</fieldset>
				</c:forEach>

				<fieldset>
					<legend>장해</legend>
					<input type="checkbox">yeyeyey@~
				</fieldset>
				<fieldset>
					<legend>봉봉이</legend>
					<input type="checkbox">bongobbobo@~bog
				</fieldset>
			</div>

			<p class="submit">
				<input type="submit" id="delete" name="commit" value="Add"><input
					type="submit" name="commit" value="Cancel">
			</p>
		</div>
	</div>
</body>
</html>