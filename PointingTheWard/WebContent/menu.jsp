<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
	charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/menu/menu_style.css" />
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('img#sideMenuBtn').click(function() {
			$('div#sideMenuDiv').toggle();
		});
	});
</script>
</head>
<body>
	<div id="mainHeader">
		<img id="sideMenuBtn" src="img/menu/menu_btn_img.png" /> 
		<a id="logo" href="#">
			<img alt="" src="img/menu/logo.png">
		</a>
	</div>
	<div id="sideMenuDiv">
		<ul id="sideMenus">
			<li>
				<a href="<c:url value='/memberInfoPage'/>">회원정보</a>
			</li>
			<li><a href="#">친구목록</a></li>
			<li><a href="#">일정정보</a></li>
		</ul>
	</div>
</body>
</html>