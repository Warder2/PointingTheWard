<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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
<header>
	<c:import url="menu.jsp"/>
</header>
	<div class="container">
		<div class="component">
			<h2>Friends List</h2>

			<c:forEach var="group" items="${gList}" varStatus="status">
				<div class="flip"><input type="checkbox">${group.name}</div>
				<div class="panel" id="${status.index}">
					<c:forEach var="friend" items="${group.fList}">
						<fieldset>
							<legend>${friend.name}</legend>
							<input type="checkbox">${friend.email}
						</fieldset>
					</c:forEach>
				</div>
			</c:forEach>

			<c:forEach var="friend" items="${fList}">
				<fieldset>
					<legend>${friend.name}</legend>
					<input type="checkbox" value="${friend.email}">${friend.email}
				</fieldset>
			</c:forEach>



			<div class="flip"><input type="checkbox">멀티방</div>
			<div class="panel" id="0">
				<fieldset>
					<legend>장해</legend>
					<input type="checkbox"> yeyeyey@~
				</fieldset>
				<fieldset>
					<legend>봉봉이</legend>
					<input type="checkbox">bongobbobo@~bog
				</fieldset>
			</div>

			<div class="flip"><input type="checkbox">고3방</div>
			<div class="panel" id="1">
				<fieldset>
					<legend>대지니</legend>
					<input type="checkbox">sivava@~
				</fieldset>
				<fieldset>
					<legend>피카츄</legend>
					<input type="checkbox">fuckfuck@~bog
				</fieldset>
			</div>

			<fieldset>
				<legend>장해</legend>
				<input type="checkbox">yeyeyey@~
			</fieldset>
			<fieldset>
				<legend>봉봉이</legend>
				<input type="checkbox">bongobbobo@~bog
			</fieldset>

			<p class="submit">
				<input type="submit" id="delete" name="commit" value="Check"><input
					type="submit" name="commit" value="Back">
			</p>
		</div>
	</div>
</body>
</html>