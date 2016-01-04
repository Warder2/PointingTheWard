<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

<link rel="stylesheet" href="css/thema_style.css">
<link rel="stylesheet" href="css/event_list_style.css">

<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<div class="component">
			<h1>1월 6일</h1>

			<fieldset>
				<legend>7:30 - 12:30</legend>
				대학 롤 정규 모임
			</fieldset>
			
			<fieldset>
				<legend>15:30 - 19:30</legend>
				데이트 >_< 
			</fieldset>

			<c:forEach var="event" items="${eList}">
				<fieldset>
					<legend>${event.sTime} - ${event.eTime}</legend>
					${event.title}
				</fieldset>
			</c:forEach>
		</div>
	</div>

</body>
</html>