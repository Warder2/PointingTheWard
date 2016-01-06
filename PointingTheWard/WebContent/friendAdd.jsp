<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/thema_style.css">
<style type="text/css">
	input#friendInput, input.addFriendBtn{
		float: right;
	}
	select#category{
		width: 26%;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('input#friendInput').keypress(function(e){
			var val = $(this).val();
			if(e.which == 13){
				var data;
				if($('select#category').val() == 'id'){
					data = {
						email: val
					}
				}else{
					data = {
						name: val
					}
				}
				$.ajax({
					url: 'memberSearch',
					type: 'GET',
					data: data,
					success: function(data){
						$('div#friendArea').empty();
						if(data instanceof Array){
							$(data).each(function(index){
								$('div#friendArea').append(createFriendTag(this.name, this.email));
							});
						}else{
							$('div#friendArea').append(createFriendTag(data.name, data.email));
						}
					}
				});
			}
		});
	});
	
	function createFriendTag(fName, fEmail){
		var fieldsetTag = document.createElement("fieldset");
		var legendTag = document.createElement("legend");
		$(legendTag).html(fName);
		var inputTag = document.createElement("input");
		$(inputTag).attr('type', 'button').attr('id', fEmail)
		.attr('name', 'commit').attr('class', 'addFriendBtn').val('add')
		.bind('click', addFriend);
		
		$(fieldsetTag).append(legendTag).append(fEmail).append(inputTag);
		return fieldsetTag;
	}
	
	function addFriend(){
		$.ajax({
			url: 'addFriend',
			type: 'POST',
			data: {
				fEmail: $(this).attr('id')
			},
			success: function(data){
				if(data == 'true'){
					confirm("success");
					/* console.log($(this).parents());
					$(this).parents().remove(); */
				}else{
					confirm("fail");
				}
			}
		});
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
			<h1>Friend Add</h1>
				<p>
				<select id="category" >
					<option value="id">ID</option>
					<option value="name">NAME</option>
				</select>
				<input id="friendInput" name="friendInput" type="text" /></p>
				<div id="friendArea">
				</div>
				<p class="submit">
					<a href="<c:url value='/mainPage'/>">
						<input type="button" id="addBackBtn" name="commit" value="back">
					</a>
				</p>
		</div>
	</div>
</body>
</html>