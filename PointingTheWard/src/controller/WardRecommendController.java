package controller;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WardRecommendController {
	private AbstractXmlApplicationContext context;
	@RequestMapping(value={"/wardRecommend"})
	public ModelAndView wardRecommend(){
		System.out.println("wardRecommend");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp name
		return view;
	}
}
