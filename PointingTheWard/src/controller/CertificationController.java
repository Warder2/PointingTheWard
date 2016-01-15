package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.Service;
import service.ServiceRequest;
import validation.ValdateAction;
import validation.exception.NonValidatedEmailFormEception;

@Controller
public class CertificationController {
	@RequestMapping(value={"/certification"}, method=RequestMethod.GET)
	public @ResponseBody Map<String, String> sendCertificationCode(@RequestParam("email") String email, HttpSession session){
		System.out.println("sendCertificationCode");
		
		Map<String, String> result = new HashMap<String, String>();
		try{
			ValdateAction.checkEmailForm(email);
			
			WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(session.getServletContext());
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
