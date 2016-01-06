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
		initFriend();
		$(".flip").each(function(i) {
			$(this).on("click", {
				x : i
			}, function(event) {

				$("#" + event.data.x).slideToggle("slow");
			});
		});
		
	});
	
	function initFriend(){
		$.ajax({
			url: 'searchFriend',
			type: 'GET',
			success: function(data){
				var friendsDiv = $('div#friendsDiv').empty();
				if(data != 'null' && data != 'empty'){
					$(data).each(function(index){
						$(friendsDiv).append(createFriendTagSet(this.name, this.email));
					});
				}
			}
		});
	}
	
	function initGroup(){
		$.ajax({
			url: 'searchGroup',
			type: 'GET',
			success: function(data){
				console.log(data);
			}
		});
	}
	
	function createFriendTagSet(name, email){
		var fieldsetTag = document.createElement("fieldset");
		var legendTag = document.createElement("legend");
		var inputTag = document.createElement("input");
		
		$(legendTag).html(name);
		$(inputTag).html(email).attr('type', 'checkbox').attr('class', 'friendChecks');
		$(fieldsetTag).append(legendTag).append(inputTag).append(email);
		
		return fieldsetTag;
	}
	
	function createGroupTagSet(gCode, gName){
		var divTag = document.createElement("div");
		$(divTag).attr('class', 'flip');
		var inputCheckTag = document.createElement("input");
		$(inputCheckTag).attr('type', 'checkbox');
		var friendsDivTag = document.createElement('div');
		$(friendsDivTag).attr('class', 'panel');
		$(divTag).append(inputCheckTag).append(friendsDivTag);
		
		return divTag;
	}
</script>


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h2>Friends List</h2>
			<div class="flip">
				<input type="checkbox">멀티방
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
			</div>
			<div id="friendsDiv">
			</div>

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