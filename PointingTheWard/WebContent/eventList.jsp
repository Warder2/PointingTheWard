<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

<link rel="stylesheet" href="css/thema_style.css">
<link rel="stylesheet" href="css/event_list_style.css">

<title>Insert title here</title>

</head>
<body>
<header>
	<c:import url="menu.jsp"/>
</header>
	<div class="container">
		<div class="component">
			<h1>1월 6일</h1>

			<fieldset>
				<a href='<c:url value="/detailEventPage"/>'>
					<legend>7:30 - 12:30</legend>
					대학 롤 정규 모임
				</a>
			</fieldset>
			
			<fieldset>
				<a href='<c:url value="/detailEventPage"/>'>
					<legend>15:30 - 19:30</legend>
					데이트 >_<
				</a> 
			</fieldset>

			<c:forEach var="event" items="${eList}">
				<fieldset>
					<a>
						<legend>${event.sTime} - ${event.eTime}</legend>
						${event.title}
					</a>
				</fieldset>
			</c:forEach>
		</div>
	</div>

</body>
</html>