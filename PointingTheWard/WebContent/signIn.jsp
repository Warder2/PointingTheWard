<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<link rel="stylesheet" href="css/thema_style.css">
  
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h1>Sign In  </h1>
			<form id="signInRequest" method="post" action="signIn">
				<p>
					<input type="email" name="email" value="" placeholder="e-mail" required>
				</p>
				<p>
					<input type="password" name="pwd" value="" placeholder="Password" required>
				</p>
				<p class="remember_me">
					<label> 
						<input type="checkbox" name="remember" id="remember"> Remember me on this computer
					</label>
				</p>
				<p class="submit">
					<input type="submit" name="commit" value="Sign In">
					<a href="<c:url value='/signUpPage'/>">
						<input type="button" name="commit" value="Sign Up">
					</a>
				</p>
			</form>
		</div>
	</div>
	
</body>
</html>