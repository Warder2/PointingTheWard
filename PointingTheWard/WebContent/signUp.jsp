<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<link rel="stylesheet" href="css/thema_style.css">


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="component">
			<h1>Sign Up</h1>
			<form method="post" action="index.html">
				<p>
					<input type="email" name="login" value="" placeholder="e-mail"><input
						type="submit" name="commit" value="check">

				</p>
				<p>
					<input type="password" name="password" value=""
						placeholder="Password" required>
				</p>
				<p>
					<input type="password" name="passwordCheck" value=""
						placeholder="Password Check" required>
				</p>

				<p>
					<input type="text" name="name" value="" placeholder="Name" required>
				</p>

				<p>
					<input type="text" name="location" value="" placeholder="location" required><input
						type="submit" name="commit" value="check" required>
				</p>

				<p class="contact-input">
					<label for="select" class="select"> <select name="subject"
						id="select" required>
							<option value="" selected>Choose Transportation…</option>
							<option value="1">My Car</option>
							<option value="1">Bus</option>
							<option value="1">Subway</option>
							<option value="1">축지법</option>
							<option value="1">낙타</option>
					</select>
					</label>
				</p>

				<p class="submit">
					<input type="submit" name="commit" value="Sign Up"> <input
						type="submit" name="commit" value="Cancel">
				</p>
			</form>
		</div>
	</div>
</body>
</html>