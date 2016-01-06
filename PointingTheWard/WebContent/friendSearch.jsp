<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/thema_style.css">

<title>Insert title here</title>
</head>
<body>
<header>
	<c:import url="menu.jsp"/>
</header>
	<div class="container">
		<div class="component">
			<h1>Search Friend</h1>
			<form method="post" action="index.html">
				<p>
					<input type="search" name="search" value="" placeholder="search..."
						required> <input type="submit" name="commit"
						value="Search">
						<input type="submit" name="commit"
						value="Cancel">
				</p>
			</form>
		</div>
	</div>
</body>
</html>