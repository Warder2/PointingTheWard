package controller;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import command.MemberCommand;
import model.beans.Member;
import persistance.dto.MemberDTO;
import service.Service;
import service.ServiceRequest;

@Controller
public class MemberController {
	private AbstractXmlApplicationContext context;

	@RequestMapping(value={"/memberSignUp"})
	public ModelAndView memberSignUp(@ModelAttribute("memberCommand") MemberCommand memberCommand){
		System.out.println("memberSignUp");
		Service service = context.getBean("memberSignUpService",Service.class);
		
		//1. 유효성 체크
		//2. Member type으로 casting
		//3. service execute
		Member member = new Member();
		//member.setEmail(memberCommand.getEmail());
		//여기서 set
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("memberInfo", member);
		try{
			service.execute(serviceRequest);
		}catch(DuplicateKeyException dke){
			//이미 있을때
		}catch(DataIntegrityViolationException dive){
			//무결성 걸렸을 때
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	
	@RequestMapping(value={"/memberSignIn"})
	public ModelAndView memberSignIn(@RequestParam(value="SignIn") Member member){
		System.out.println("memberSignIn");
		Service service = context.getBean("memberSignIn",Service.class);
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	
	@RequestMapping(value={"/memberSearch"})
	public ModelAndView memberSearch(@RequestParam(value="search") Member member){
		System.out.println("memberSearch");
		Service service = context.getBean("memberSearch",Service.class);
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	@RequestMapping(value={"/memberModify"})
	public ModelAndView memberModify(@RequestParam(value="modify") Member member){
		System.out.println("memberModify");
		Service service = context.getBean("memberModify",Service.class);
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("");//jsp명
		return view;
	}
	
	@RequestMapping(value={"/memberDropout"})
	public ModelAndView memberDropout(@RequestParam(value="dropout") Member member){
		System.out.println("memberDropout");
		Service service = context.getBean("memberDropout",Service.class);
		
		
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
