package model.beans;

public class Time {
	private String hour;
	private String min;

	public Time() {
		this("0", "0");
	}

	public Time(String hour, String min) {
		this.hour = hour;
		this.min = min;
		checkTime();
	}
	public Time(Time time){
		this.hour = time.getHour();
		this.min = time.getMin();
		checkTime();
	}
	public Time(int hour,int min){
		this.hour = String.valueOf(hour);
		this.min = String.valueOf(min);
		checkTime();
	}
	public String increaseTime(String time){
		this.hour = String.valueOf(Integer.parseInt(this.hour) + Integer.parseInt(time.substring(0,2)));
		this.min = String.valueOf(Integer.parseInt(this.min) + Integer.parseInt(time.substring(3,5)));
		checkTime();
		return hour +":"+min;
	}
	public String increaseTime(int hour,int min){
		this.hour = String.valueOf(getHourInt() + hour);
		this.min = String.valueOf(getMinInt() + min);
		checkTime();
		return getTime();
	}
	public String increaseHalfTime() {
		this.min = String.valueOf(Integer.parseInt(min)+30);
		checkTime();
		return this.hour + ":" + this.min;
	}
	public String decreaseHalfTime() {
		this.min = String.valueOf(Integer.parseInt(min)-30);
		checkTime();
		return this.hour + ":" + this.min;
	}
	public void checkTime(){
		int h = Integer.parseInt(this.hour);
		int m = Integer.parseInt(this.min);
		if(m >= 60){
			h+=1;
			m-=60;
			if(h > 24){
				h = 1;
			}
		}else if(m < 0){
			m = 60 - (-m);//이렇게 계산하면 안됨!
			h -= 1;
		}
		this.hour = String.valueOf(h);
		this.min = String.valueOf(m);
	}
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}
	public void setTime(Time time){
		this.hour = time.getHour();
		this.min = time.getMin();
	}
	public void setTime(String time){
		this.hour = time.substring(0,2);
		this.min = time.substring(3,5);
		checkTime();
	}
	public int getHourInt() {
		return Integer.parseInt(hour);
	}

	public int getMinInt() {
		return Integer.parseInt(min);
	}

	public String getTime() {
		return this.hour + ":" + this.min;
	}
	public int compare(String time){
		int hour = getHourInt();
		int min = getMinInt();
		int timeHour = Integer.parseInt(time.substring(0, 2));
		int timeMin = Integer.parseInt(time.substring(3, 5));
		
		if(hour < timeHour){
			//이전
			return -1;
		}else if(hour == timeHour){
			if(min < timeMin){
				//이전
				return -1;
			}else if(min == timeMin){
				//같다
				return 0;
			}else{
				//이후
				return 1;
			}
		}
		return 1;
	}

	@Override
	public String toString() {
		return hour +":"+min;
	}
	
}
