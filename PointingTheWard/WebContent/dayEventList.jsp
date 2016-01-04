<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DayEventList</title>
</head>
<style>
body {
	font: 13px/20px 'Lucida Grande', Tahoma, Verdana, sans-serif;
	color: #404040;
	background: #adff2f;
}
.dayEvent_table {
	margin: 80px auto;
	width: 640px;
	position: relative;
	margin: 0 auto;
	padding: 20px 20px 20px;
	width: 310px;
	background: white;
	border-radius: 3px; 
	@include box-shadow(0 0 200px rgba(white, .5), 0 1px 2px rgba(black, .3));
}

</style>
<body>
	<!-- 일일 이벤트 정보  -->
	<div class="dayInfo">
		<!-- 이벤트 목록을 표시 할 테이블 -->
		<table class="dayEvent_table">
			<!-- 이벤트 날짜 표시-->
			<tr class="event_day_into_tr">
				<td colspan="2">${dayEvent.sDate}</td>
			</tr>
			<!-- 이벤트 테이블의 속성 표시 -->
			<tr class="evnetList_title_tr">
				<td>시간</td>
				<td>제목</td>
			</tr>
			<!-- 이벤트목록 표시-->
			<c:forEach var="Member" items="${dayEventList}">
				<tr class="Evnetlist_tr" id="event.code">
					<td class="event_time_info">${dayEvent.sTime}~
						${dayEvent.eTime} |</td>
					<td class="event_title_info">${dayEvent.title}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>