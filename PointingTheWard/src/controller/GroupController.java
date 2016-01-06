package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.Service;
import service.ServiceRequest;

@Controller
public class GroupController {
	@RequestMapping(value={"/searchGroup"}, method=RequestMethod.GET)
	public @ResponseBody <T> T searchGroup(HttpServletRequest servletRequest, HttpSession session){
		System.out.println("searchGroup");
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletRequest.getServletContext());
		
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		String gCodeParam = servletRequest.getParameter("gCode");
		if(gCodeParam != null){
			try{
				int gCode = Integer.valueOf(gCodeParam);
				
				request.addObject("gCode", gCode);
			}catch(NumberFormatException numberFormatException){
				System.out.println("NumberFormatException");
				numberFormatException.printStackTrace();
			}
		}
		String email = null;
		synchronized (session) {
			email = (String) session.getAttribute("email");
		}
		if(email != null){
			Service service = context.getBean("", Service.class);
			try{
				service.execute(request);
			}catch(NullPointerException nullPointerException){
				System.out.println(nullPointerException.getMessage());
				nullPointerException.printStackTrace();
			}catch(EmptyResultDataAccessException emptyResultDataAccessException){
				System.out.println(emptyResultDataAccessException.getMessage());
				emptyResultDataAccessException.printStackTrace();
			}
		}
		return null;
	}
	
}
