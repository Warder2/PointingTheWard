package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {
	
	@RequestMapping(value={"/searchEvent"}, method=RequestMethod.GET)
	public String searchEvent(HttpServletRequest servletRequest){
		System.out.println("searchEvent");
		String day = servletRequest.getParameter("day");
		String year = servletRequest.getParameter("year");
		String month = servletRequest.getParameter("month");
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
		return "eventList";
	}
}
