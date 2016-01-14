package controller;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 와드 추천 controller 클래스
 * @author SEONGBONG
 *
 */
@Controller
public class WardRecommendController {
	private AbstractXmlApplicationContext context;
	/**
	 * 와드 추천 받기
	 * @return
	 */
	@RequestMapping(value={"/wardRecommend"})
	public ModelAndView wardRecommend(){
		System.out.println("wardRecommend");
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp name
		return view;
	}
}
