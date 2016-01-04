<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<link rel="stylesheet" href="css/thema_style.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#modify").click(function() {
			alert("asdf");
			if($(".form").prop('disabled') == true){
				alert("폼입력 오픈 ");
				$(".form").prop('disabled', false);
			}
			else{
				alert("폼입력 닫음 ");
				$(".form").prop('disabled', true);
				//수정값 전달 
			}
		});

	});
</script>

<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="component">


			<form method="post" action="index.html">
				<h1>User.name</h1>
				<p>
					<input type="email" name="login" value="devj@gmail.com"
						placeholder="e-mail" class="form" disabled>
				</p>
				<p>
					<input type="text" name="name" value="김대진" placeholder="Name"
						class="form" disabled>
				</p>
				<p>
					<input type="text" name="location" value="우리집"
						placeholder="location" class="form" disabled>
				</p>

				<p class="contact-input">
					<label for="select" class="select"> <select name="subject"
						id="select" required class="form" disabled>
							<option value="" >Choose Transportation…</option>
							<option value="1">My Car</option>
							<option value="1">Bus</option>
							<option value="1">Subway</option>
							<option value="1">etc.</option>
							<option value="1" selected>축지법</option>
							<option value="1">낙타</option>
					</select>
					</label>
				</p>

			</form>
			<p class="submit">
				<input type="submit" id="modify" name="commit" value="Modify"><input
					type="submit" name="commit" value="Check">
			</p>
		</div>
	</div>
</body>
</html>