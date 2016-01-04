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

<link rel="stylesheet" href="css/thema_style.css">
<link rel="stylesheet" href="css/list_style.css">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h2>Recommanded Wards</h2>

			<c:forEach var="ward" items="${wList}" varStatus="status">
				<div class="flip">
					${ward.sDate} + ${ward.sTime} ~ ${ward.eDate} + ${ward.eTime} <br>
					${ward.place}
				</div>
				<div class="panel" id="${status.index}">${movingTime}

					${movingCost}</div>

				<br>
			</c:forEach>


			<div class="flip">
				1월6일 18:00 ~ 1월6일 22:00 <br> 인하대 후문
			</div>
			<div class="panel" id="0">
				비용:4700원<br> 시간:1시간13분<br> <img src="inha.PNG">
			</div>
			<br>
			<div class="flip">
				1월7일 12:00 ~ 1월7일 22:00 <br> 구월동 로데오
			</div>
			<div class="panel" id="1">
				비용:4700원<br> 시간:1시간13분<br> <img src="inha.PNG">
			</div>
			
			
		</div>
	</div>


</body>
</html>