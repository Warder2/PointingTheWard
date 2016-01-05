package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.el.lang.FunctionMapperImpl.Function;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import command.SignUpMemberRequest;
import model.beans.Member;
import model.certification.CertificationCodeCreator;
import model.mail.EmailSendable;
import service.Service;
import service.ServiceRequest;
import validation.ValdateAction;
import validation.exception.NonValidatedEmailFormEception;

@Controller
public class MemberController {
	
	@RequestMapping(value={"/signUp"})
	public String memberSignUp(@ModelAttribute("signUpMember") SignUpMemberRequest memberCommand){
		System.out.println("memberSignUp");
		
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletContext);
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
		
		return "";
	}
//	
//	@RequestMapping(value={"/memberSignIn"})
//	public ModelAndView memberSignIn(@RequestParam(value="SignIn") Member member){
//		System.out.println("memberSignIn");
//		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletContext);
//		Service service = context.getBean("memberSignIn",Service.class);
//		
//		
//		ModelAndView view = new ModelAndView();
//		view.setViewName("");//jsp명
//		return view;
//	}
//	
//	@RequestMapping(value={"/memberSearch"})
//	public ModelAndView memberSearch(@RequestParam(value="search") Member member){
//		System.out.println("memberSearch");
//		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletContext);
//		Service service = context.getBean("memberSearch",Service.class);
//		
//		
//		ModelAndView view = new ModelAndView();
//		view.setViewName("");//jsp명
//		return view;
//	}
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
	
	@RequestMapping(value={"/certification"}, method=RequestMethod.GET)
	public @ResponseBody Map<String, String> sendCertificationCode(HttpServletRequest servletRequest ,@RequestParam("email") String email, HttpSession session){
		System.out.println("sendCertificationCode");
		
		Map<String, String> result = new HashMap<String, String>();
		try{
			ValdateAction.checkEmailForm(email);
			
			WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletRequest.getServletContext());
			Service service = context.getBean("sendCertificationCodeService", Service.class);
			ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
			
			request.addObject("email", email);
			
			service.execute(request);
			
			synchronized (session) {
				session.setAttribute("certificationCode", request.getObject("code"));
			}
			
			result.put("result", "true");
			result.put("email", email);
		}catch(NullPointerException npe){
			result.put("result", "false");
			result.put("message", "not input email");
		}catch(NonValidatedEmailFormEception nvef){
			result.put("result", "false");
			result.put("message", "nonvalidated email form");
		}catch(ClassCastException cce){
			result.put("result", "false");
		}
		return result;
	}
	
	@RequestMapping(value={"/certification"}, method=RequestMethod.POST)
	public @ResponseBody Boolean confirmCertificationCode(@RequestParam("code") String code, HttpSession session){
		System.out.println("confirmCertificationCode");
		String certificationCode = "";
		synchronized (session) {
			certificationCode = (String) session.getAttribute("certificationCode");
		}
		if(certificationCode.equals(code)){
			synchronized (session) {
				session.removeAttribute("certificationCode");
			}
			return true;
		}
		return false;
	}
}
