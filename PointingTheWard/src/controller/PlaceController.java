package controller;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlaceController {
private AbstractXmlApplicationContext context;
@RequestMapping(value={"/placeRegist"})
public ModelAndView placeRegist(){
	System.out.println("placeRegist");
	ModelAndView view = new ModelAndView();
	view.setViewName("");//jsp name
	return view;
}
@RequestMapping(value={"/placeSearch"})
public ModelAndView placeSearch(){
	System.out.println("placeSearch");
	ModelAndView view = new ModelAndView();
	view.setViewName("");//jsp name
	return view;
}
@RequestMapping(value={"/placeModify"})
public ModelAndView placeModify(){
	System.out.println("placeModify");
	ModelAndView view = new ModelAndView();
	view.setViewName("");//jsp name
	return view;
}
@RequestMapping(value={"/placeDelete"})
public ModelAndView placeDelete(){
	System.out.println("placeDelete");
	ModelAndView view = new ModelAndView();
	view.setViewName("");//jsp name
	return view;
}
public AbstractXmlApplicationContext getContext() {
	return context;
}
public void setContext(AbstractXmlApplicationContext context) {
	this.context = context;
}

}
