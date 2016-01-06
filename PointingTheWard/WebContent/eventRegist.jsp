<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<title>Insert title here</title>

<link rel="stylesheet" href="css/thema_style.css">

</head>
<body>
<header>
	<c:import url="menu.jsp"/>
</header>
	<div class="container">
		<div class="component">
			<h1>Event Regist</h1>
			<form method="post" action="index.html">
			
				<p>
					<input type="text" name="title" value="" placeholder="title">
				</p>
				<p>
					<textarea rows="4" cols="50" place>content
					</textarea>
				</p>
				<p>
					<input type=datetime-local name="" value=""
						placeholder="sDate" >
				</p>

				<p>
					<input type="datetime-local" name="eDate" value="" placeholder="eDate" >
				</p>
				
				<p>
					<input type="text" name="location" value="" placeholder="location" > 
				</p>
				<p class="submit">
					<a href='<c:url value="/mainPage"/>'><input type="button" name="commit" value="regist"></a>
					<a href='<c:url value="/wardRequest"/>'><input type="button" value="recommand"/></a>
					<a href='<c:url value="/mainPage"/>'> 
						<input type="button" name="commit" value="Cancel">
					</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>