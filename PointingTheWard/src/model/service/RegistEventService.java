package model.service;

import model.Abstract.AbstractCalendarService;
import model.beans.Event;

public class RegistEventService extends AbstractCalendarService{

	@Override
	public void execute(ServiceRequest request) {
		Event event = request.getObject("eventInfo");
		//event를 등록
	}
}
