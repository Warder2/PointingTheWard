<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
	<header>
	<c:import url="menu.jsp"/>
</header>
	<div class="container">
		<div class="component">

			<form method="post" action="index.html">
				<h1>User.Event</h1>
				<p>
					<input type="text" name="title" value="단대 신년회" class="form"
						disabled>
				</p>
				<p>
					<input type="datetime-local" name="sdate-time" value="" class="form"
						disabled>
				</p>
				<p>
					<input type="datetime-local" name="edate-time" value="" class="form" disabled>
				</p>
				<p>
					<input type="text" name="location" value="서울시 서초구 사당역" class="form"
						disabled><input type="submit" name="commit" value="ward">
				</p>

				<p class="contact-input">
					<label for="select" class="select"> <select
						name="participant" id="select" required class="form" disabled >
							<option>장성봉 : jangsb@asdf</option>
							<option>예장해 : janghae@asdf</option>

					</select>
					</label>
				</p>
				<p>
					<textarea rows="4" cols="50" place disabled>content
					</textarea>
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