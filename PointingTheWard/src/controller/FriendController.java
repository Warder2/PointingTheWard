package controller;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendController {
	private AbstractXmlApplicationContext context;
	@RequestMapping(value={"/friendAddtion"})
	public ModelAndView friendAddtion(){
		System.out.println("friendAddtion");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	@RequestMapping(value={"/friendSearch"})
	public ModelAndView friendSearch(){
		System.out.println("friendSearch");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	@RequestMapping(value={"/friendModify"})
	public ModelAndView friendModify(){
		System.out.println("friendModify");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	@RequestMapping(value={"/friendDelete"})
	public ModelAndView friendDelete(){
		System.out.println("friendDelete");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	public AbstractXmlApplicationContext getContext() {
		return context;
	}
	public void setContext(AbstractXmlApplicationContext context) {
		this.context = context;
	}
}
