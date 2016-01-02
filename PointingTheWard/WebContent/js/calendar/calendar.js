function MonthError(month, message) {
	this.base = Error;
	this.base(message);
	var month;

	this.getMonth = function() {
		return month;
	}
	this.setMonth = function(newMonth) {
		month = newMonth;
	}
	this.toString = function() {
		return this.base.toString() + ', month = [' + month + ']';
	}
	MonthError.prototype = Error.prototype;
	MonthError.constructor = MonthError;
}

function Calendar() {
	var severalMonthDays = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];// 각 달의
	var year = new Date().getFullYear();
	var month = new Date().getMonth() + 1;
	var day = new Date().getDay();

	this.getSeveralMonthDays = function() {
		return severalMonthDays;
	}
	this.getYear = function() {
		return year;
	}
	this.getMonth = function() {
		return month;
	}
	this.setYear = function(newYear) {
		if (newYear >= 1) {
			year = newYear;
		} else {
			throw 'not validate year';
		}
	}
	this.setMonth = function(newMonth) {
		if (1 <= newMonth && newMonth <= 12) {
			month = newMonth;
		} else {
			throw new MonthError(newMonth, 'not validate month');
		}
	}
	this.getDay = function() {
		return day;
	}
	this.setDay = function(newDay) {
		if (1 <= newDay && newDay <= severalMonthDays[month - 1]) {
			day = newDay;
		} else {
			throw 'not validate day';
		}
	}
	this.increamentYear = function() {
		year++;
	}
	this.decreamentYear = function() {
		try {
			this.setYear(year - 1);
		} catch (e) {
			throw 'year is zero' + '\n' + e.message;
		}
	}
	this.increamentMonth = function() {
		try {
			this.setMonth(month + 1);
		} catch (e) {
			if (e.getMonth() > 12) {
				this.setMonth(1);
				this.increamentYear();
			}
		}
	}
	this.decreamentMonth = function() {
		try {
			this.setMonth(month - 1);
		} catch (e) {
			if (e.getMonth() < 1) {
				this.setMonth(12);
				this.decreamentYear();
			}
		}
	}
	Calendar.prototype.isLeapYear = function() {
		return this.isLeapYear(year);
	}
	/* 윤년 평년 확인 함수 */
	Calendar.prototype.isLeapYear = function(y) {
		if (y % 4 == 0 && (y % 400 == 0 || y % 100 != 0)) {
			return true;
		} else {
			return false;
		}
	}
	/* 총 날수를 구하는 함수 정의부 */
	Calendar.prototype.getTotalDay = function() {
		var res, totalday, tot = 0, mon = 0; // 윤년 평년 제어변수, 총날수 저장변수,전년도,전월까지
												// 누적일수 저장 변수 선언 및 초기화
		/* 1~입력년도까지의 총날수 */
		for (var i = 1; i <= year - 1; i++) // 1년부터 입력한 년도의 전년도 까지 윤년 + 평년 일수의 합
											// 누적
		{
			// 윤년체크 함수 호출 및 리턴값 저장
			if (this.isLeapYear(i)) // 윤년(리턴값 1)일 경우
			{
				tot += 366; // 366일을 누적 하고
			} else // 평년인 경우
			{
				tot += 365; // 365일을 누적
			}
		}
		/* 1~입력월까지의 총날수 */
		for (var i = 0; i < month - 1; i++) // 0번방(1월) 부터 입력한 달의 전번방(전 월)까지 반복
											// 누적달까지 반복 누적
		{
			mon += severalMonthDays[i]; // 캘린더의 그달의 일수를 누적해서 합<윤년일 경우 이미 2월 값은
										// 29일로 바껴있음>
		}
		totalday = tot + mon + day; // 총 일수 계산<입력한 달 1일까지으므로 1추가>
		if (this.isLeapYear(year) && month >= 2) {
			totalday++;
		}
		return totalday; // 총 일수 리턴과 함께 함수 종료
	}
	Calendar.prototype.getDayOfWeek = function() {
		var total = this.getTotalDay();
		return total % 7;
	}
	this.toString = function() {
		return 'Calendar[year=' + year + ', month=' + month + ', day=' + day
				+ ']';
	}
}