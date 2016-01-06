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
	
	function createFriendTagSet(name, email){
		var fieldsetTag = document.createElement("fieldset");
		var legendTag = document.createElement("legend");
		var inputTag = document.createElement("input");
		
		$(legendTag).html(name);
		$(inputTag).html(email).attr('type', 'checkbox');
		$(fieldsetTag).append(legendTag).append(inputTag);
		
		return fieldsetTag;
	}
	
	function createGroupTagSet(gCode, gName){
		var divTag = document.createElement("div");
		$(divTag).attr('class', 'flip');
		var inputTag = document.createElement("input");
		var inputTagGCode = document.createElement("input");
		$(inputTagGCode).val(gCode);
		$(inputTagGCode).prop('hidden', true);
		$(inputTag).attr('type', 'checkbox').html(gName);
		
		$(divTag).append(inputTag).append(inputTagGCode);
		return divTag;
	}
</script>


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h2>Friends List</h2>

			<c:forEach var="group" items="${gList}" varStatus="status">
				<div class="flip">
					<input type="checkbox">${group.name}</div>
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
					<input type="checkbox">${friend.email}
				</fieldset>
			</c:forEach>



			<div class="flip">
				<input type="checkbox">멀티방
			</div>
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

			<div class="flip">
				<input type="checkbox">고3방
			</div>
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
				<input type="submit" id="delete" name="commit" value="delete"><input
					type="submit" name="commit" value="Check"><input
					type="submit" name="commit" value="G-Add"> <input
					type="submit" name="commit" value="search">
			</p>
		</div>
	</div>
</body>
</html>