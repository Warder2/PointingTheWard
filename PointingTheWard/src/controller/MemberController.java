package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import command.SignInRequest;
import command.SignUpMemberRequest;
import model.beans.Member;
import model.beans.SignInInfo;
import model.beans.Transportation;
import service.Service;
import service.ServiceRequest;
import validation.ValdateAction;
import validation.Validator;
import validation.exception.NonValidatedEmailFormEception;
import validation.exception.NonValidatedTransportationFormException;
import validation.exception.PwdMisMatchedException;

@Controller
public class MemberController {
	
	@RequestMapping(value={"/member"}, method=RequestMethod.POST)
	public ModelAndView memberSignUp(@ModelAttribute("signUpMemberRequest") SignUpMemberRequest signUpMemberRequest, HttpSession session){
		System.out.println("memberSignUp");
		ModelAndView modelAndView = new ModelAndView();
		
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(session.getServletContext());
		
		Validator validator = context.getBean("memberValidator", Validator.class);
		try{
			validator.validate(signUpMemberRequest, SignUpMemberRequest.class);
	
			Member member = context.getBean("member", Member.class);
			member.setEmail(signUpMemberRequest.getEmail());
			member.setName(signUpMemberRequest.getName());
			member.setPwd(signUpMemberRequest.getPwd());
			member.setLocation(signUpMemberRequest.getLocation());
			member.setTransportation(Transportation.valueOfByStr(signUpMemberRequest.getTransportation()));
			
			Service service = context.getBean("memberSignUpService",Service.class);
			ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
			serviceRequest.addObject("memberInfo", member);
			try{
				service.execute(serviceRequest);
				
				synchronized (session) {
					session.setAttribute("email", member.getEmail());
				}
				modelAndView.setViewName("main");
			}catch(DuplicateKeyException dke){
				//이미 있을때
			}catch(DataIntegrityViolationException dive){
				//무결성 걸렸을 때
			}
		}catch(NullPointerException nullPointerException){
			System.out.println("NullPointerException");
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}catch(NonValidatedEmailFormEception emailFormEception){
			System.out.println("NonValidatedEmailFormEception");
			System.out.println(emailFormEception.getMessage());
			emailFormEception.printStackTrace();
		}catch(NonValidatedTransportationFormException transportationFormException){
			System.out.println("NonValidatedEmailFormEception");
			System.out.println(transportationFormException.getMessage());
			transportationFormException.printStackTrace();
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/signIn"}, method=RequestMethod.POST)
	public ModelAndView signIn(@ModelAttribute("signInRequest") SignInRequest signInRequest, HttpSession session){
		System.out.println("signIn");
		ModelAndView modelAndView = new ModelAndView();
		try{
			ValdateAction.checkEmailForm(signInRequest.getEmail());
			
			WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(session.getServletContext());
			
			SignInInfo signInInfo = context.getBean("signInInfo", SignInInfo.class);
			signInInfo.setEmail(signInRequest.getEmail());
			signInInfo.setPwd(signInRequest.getPwd());
			
			Service service = context.getBean("memberSignInService",Service.class);
			
			ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
			
			request.addObject("signInInfo", signInInfo);
			
			try{
				service.execute(request);
				
				synchronized (session) {
					session.setAttribute("email", signInInfo.getEmail());
				}
				modelAndView.setViewName("main");
			}catch(NullPointerException nullPointerException){
				System.out.println("NullPointerException");
				System.out.println(nullPointerException.getMessage());
				nullPointerException.printStackTrace();
			}catch(EmptyResultDataAccessException emptyResultDataAccessException){
				System.out.println("EmptyResultDataAccessException");
				System.out.println(emptyResultDataAccessException.getMessage());
				emptyResultDataAccessException.printStackTrace();
			}catch(PwdMisMatchedException pwdMisMatchedException){
				System.out.println("PwdMisMatchedException");
				System.out.println(pwdMisMatchedException.getMessage());
				pwdMisMatchedException.printStackTrace();
			}
		}catch(NullPointerException nullPointerException){
			System.out.println("NullPointerException");
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}catch(NonValidatedEmailFormEception emailFormEception){
			System.out.println("NonValidatedEmailFormEception");
			System.out.println(emailFormEception.getMessage());
			emailFormEception.printStackTrace();
		}
		return modelAndView;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value={"/member"}, method=RequestMethod.GET)
	public @ResponseBody <T> T memberSearch(HttpServletRequest servletRequest, HttpSession session){
		System.out.println("memberSearch");
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(session.getServletContext());
		
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		String name = servletRequest.getParameter("name");
		if(name != null){
			request.addObject("name", name);
		}else{
			String email = servletRequest.getParameter("email");
			if(email == null){
				synchronized (session) {
					email = (String) session.getAttribute("email");
				}
			}
			request.addObject("email", email);
		}
		Service service = context.getBean("memberSearchService",Service.class);
		T result = null;
		try{
			service.execute(request);
			Member member = request.getObject("member");
			List<Member> members = request.getObject("members");
			if(member != null){
				result = (T) member;
			}else if(members != null){
				result = (T) members;
			}
		}catch(NullPointerException nullPointerException){
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}catch(EmptyResultDataAccessException emptyResultDataAccessException){
			System.out.println(emptyResultDataAccessException.getMessage());
			emptyResultDataAccessException.printStackTrace();
		}
		return result;
	}
	
//	@RequestMapping(value={"/memberModify"})
//	public ModelAndView memberModify(@RequestParam(value="modify") Member member){
//		System.out.println("memberModify");
//		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletContext);
//		Service service = context.getBean("memberModify",Service.class);
//		
//		
//		ModelAndView view = new ModelAndView();
//		view.setViewName("");//jsp명
//		return view;
//	}
//	
//	@RequestMapping(value={"/memberDropout"})
//	public ModelAndView memberDropout(@RequestParam(value="dropout") Member member){
//		System.out.println("memberDropout");
//		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletContext);
//		Service service = context.getBean("memberDropout",Service.class);
//		
//		
//		ModelAndView view = new ModelAndView();
//		view.setViewName("");//jsp명
//		return view;
//	}
}
