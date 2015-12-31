package controller;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
	private AbstractXmlApplicationContext context;
	
	@RequestMapping(value={"/eventRegist"})
	public ModelAndView eventRegist(){
		System.out.println("eventRegist");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jspname
		return view;
	}
	@RequestMapping(value={"/eventSearch"})
	public ModelAndView eventSearch(){
		System.out.println("eventSearch");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jspname
		return view;
	}
	@RequestMapping(value={"/eventModify"})
	public ModelAndView eventModify(){
		System.out.println("eventModify");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jspname
		return view;
	}
	@RequestMapping(value={"/eventDelete"})
	public ModelAndView eventDelete(){
		System.out.println("eventDelete");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jspname
		return view;
	}
	public AbstractXmlApplicationContext getContext() {
		return context;
	}
	public void setContext(AbstractXmlApplicationContext context) {
		this.context = context;
	}
}
