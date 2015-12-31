package test;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.beans.Event;
import service.Service;
import service.ServiceRequest;

@Controller
public class TestController {
	private AbstractXmlApplicationContext context;
	
	public void setContext(AbstractXmlApplicationContext context) {
		this.context = context;
	}
	@RequestMapping(value={"/eventRegist"})
	public ModelAndView registEvent(@RequestParam(value="rg") Event event){
		//폼데이터
		//유효성쳌,
		ServiceRequest serviceRequest = context.getBean("sr", ServiceRequest.class);
		serviceRequest.addObject("dd", event);
		context.getBean("serv", Service.class).execute(serviceRequest);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
	/*
	@RequestMapping(value={"/eventRdd"})
	public ModelAndView registsEvent(@RequestParam(value="rg") Event event){
		//폼데이터
		//유효성쳌,
		ServiceRequest serviceRequest = context.getBean("sr", ServiceRequest.class);
		serviceRequest.addObject("dd", event);
		context.getBean("serv", Service.class).execute(serviceRequest);
		
		ModelAndView view = new ModelAndView();
	}*/
}