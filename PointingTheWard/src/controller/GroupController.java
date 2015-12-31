package controller;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupController {
	private AbstractXmlApplicationContext context;
	@RequestMapping(value={"/groupCreate"})
	public ModelAndView groupCreate(){
		System.out.println("groupCreate");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//JSP NAME
		return view;
	}
	@RequestMapping(value={"/groupSearch"})
	public ModelAndView groupSearch(){
		System.out.println("groupSearch");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//JSP NAME
		return view;
	}
	@RequestMapping(value={"/groupModify"})
	public ModelAndView groupModify(){
		System.out.println("groupModify");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//JSP NAME
		return view;
	}
	@RequestMapping(value={"/groupDelete"})
	public ModelAndView groupDelete(){
		System.out.println("groupDelete");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//JSP NAME
		return view;
	}
	public AbstractXmlApplicationContext getContext() {
		return context;
	}
	public void setContext(AbstractXmlApplicationContext context) {
		this.context = context;
	}
	
}
