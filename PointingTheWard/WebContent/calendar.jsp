<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/layout/calendar_style.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript">
	var calendar = new Calendar();
	calendar.setDay(1);
	
	$(document).ready(function() {
		setCalendar();

		$('input#prevMonthBtn').click(function() {
			calendar.decreamentMonth();
			clearCalendar();
			setCalendar();
		});

		$('input#prevYearBtn').click(function() {
			calendar.decreamentYear();
			clearCalendar();
			setCalendar();
		});

		$('input#nextMonthBtn').click(function() {
			calendar.increamentMonth();
			clearCalendar();
			setCalendar();
		});

		$('input#nextYearBtn').click(function() {
			calendar.increamentYear();
			setCalendar();
		});

		/* var userAgent = navigator.userAgent;
		alert(userAgent.match(new RegExp('Android')));
		$(window).on('orientationchange', function(){
			alert(window.orientation);
			//window.orientation값이 0이면 portrait, 90이나 -90이면 landscape
		}); */

		$('div#calendar_div').on('swipeleft', function(e) {
			$('input#nextMonthBtn').trigger('click');
		});
		$('div#calendar_div').on('swiperight', function(e) {
			$('input#prevMonthBtn').trigger('click');
		});
	});

	function setCalendar() {
		var dayBlocks = $('div.day_block');
		for (var i = calendar.getDayOfWeek(), j = 1; j < calendar.getSeveralMonthDays()[calendar.getMonth() - 1]; i++, j++) {
			$($(dayBlocks[i]).children()[0]).html(j);
		}

		$('label#currentYear').html(calendar.getYear());
		$('label#currentMonth').html(calendar.getMonth());
	}

	function clearCalendar() {
		$('div.day_block').each(function(index) {
			$($(this).children()[0]).html('');
		});
	}
</script>
</head>
<body>
	<div id="calendar_div">
		<table id="calendarTable">
			<thead>
				<tr>
					<td><label id="currentYear">2015</label></td>
					<td><label id="currentMonth">12</label></td>
					<td id="calendarControlBtns" colspan="5">
						<input type="button" class="calendarControlBtn" id="nextMonthBtn"/>
						<input type="button" class="calendarControlBtn" id="nextYearBtn"/> 
						<input type="button" class="calendarControlBtn" id="prevYearBtn"/> 
						<input type="button" class="calendarControlBtn" id="prevMonthBtn"/>
					</td> 
				</tr>
				<tr>
					<td>
						<label class="sunDaysLabel">일</label>
					</td>
					<td>
						<label class="daysLabel">월</label>
					</td>
					<td>
						<label class="daysLabel">화</label>
					</td>
					<td>
						<label class="daysLabel">수</label>
					</td>
					<td>
						<label class="daysLabel">목</label>
					</td>
					<td>
						<label class="daysLabel">금</label>
					</td>
					<td>
						<label class="satDaysLabel">토</label>
					</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" end="5">
					<tr>
						<c:forEach varStatus="j" begin="0" end="6">
							<td>
								<div class="day_block">
									<a class="dayBlocks" href="#">
										<c:choose>
											<c:when test="${j.index eq 0 }">
												<label class="sunDaysLabel"></label>
											</c:when>
											<c:when test="${j.index eq 6 }">
												<label class="satDaysLabel"></label>
											</c:when>
											<c:otherwise>
												<label class="daysLabel"></label>
											</c:otherwise>
										</c:choose>
									<br /> 
									</a>
									<!-- <div class="event_img"></div> -->
								</div>
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>