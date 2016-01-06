<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<link rel="stylesheet" href="css/thema_style.css">
<link rel="stylesheet" href="css/list_style.css">

<script>
	$(document).ready(function() {
		initFriend();
		initGroup();
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
				$('div#groupDiv').empty();
				if(data instanceof Array){
					$(data).each(function(index){
						var groupTag = createGroupTagSet(this.gCode, this.name, index);
						var gDiv = $(groupTag).children('div');
						$(this.participants).each(function(index){
							$(gDiv).append(createFriendTagSet(this.name, this.email));
						});
						$('div#groupDiv').append(groupTag);
						
						console.log(groupTag);
					});
				}
			}
		});
	}
	
	function createFriendTagSet(name, email){
		var fieldsetTag = document.createElement("fieldset");
		var legendTag = document.createElement("legend");
		var inputTag = document.createElement("input");
		
		$(legendTag).html(name);
		$(inputTag).attr('type', 'checkbox').attr('class', 'friendChecks');
		$(fieldsetTag).append(legendTag).append(inputTag).append(email);
		
		return fieldsetTag;
	}
	
	function createGroupTagSet(gCode, gName, index){
		var inputCheckTag = document.createElement("input");
		$(inputCheckTag).attr('type', 'checkbox');
		var friendsDivTag = document.createElement('div');
		$(friendsDivTag).attr('class', 'panel').click(function(){
			$(this).slideToggle("slow");
		});
		var divTag = document.createElement("div");
		$(divTag).attr('class', 'flip').append(inputCheckTag)
		.append(gName).append(friendsDivTag).click(function(){
			$(this).children('div.panel')[0].click();
		});
		
		return divTag;
	}
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
			<div id="groupDiv"></div>
			<div id="friendsDiv"></div>
			<p class="submit">
				<input type="submit" id="delete" name="commit" value="delete">
				<a href='<c:url value="/friendAdd"/>'><input type="submit" name="commit" value="F-Add"></a>
				<input type="submit" name="commit" value="G-Add"> 
				<input type="submit" name="commit" value="search">
			</p>
		</div>
	</div>
</body>
</html>