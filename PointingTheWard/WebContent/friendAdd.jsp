<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/thema_style.css">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h1>Friend Add</h1>
			<form method="post" action="index.html">
			
				<fieldset>
					<legend>${friend.name}</legend>
					${friend.email}
				</fieldset>

				<fieldset>
					<legend>대진킴</legend>
					akjin47@naver.com
				</fieldset>

				<p class="submit">
					<input type="submit" name="commit" value="add">
					<input type="submit" name="commit" value="cancel">
				</p>
			</form>
		</div>
	</div>
</body>
</html>