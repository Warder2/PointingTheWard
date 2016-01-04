<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form method="post" action="index.html">
				<p>
					<input type="email" name="login" value=""
						placeholder="e-mail" required>
				</p>
				<p>
					<input type="password" name="password" value=""
						placeholder="Password" required>
				</p>
				<p class="remember_me">
					<label> <input type="checkbox" name="remember_me"
						id="remember_me"> Remember me on this computer
					</label>
				</p>
				<p class="submit">
					<input type="submit" name="commit" value="Sign In">
					<input type="submit" name="commit" value="Sign Up">
				</p>
			</form>
		</div>
	</div>
	
</body>
</html>