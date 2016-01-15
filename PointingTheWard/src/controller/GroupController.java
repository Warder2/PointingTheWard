package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.beans.Group;
import service.Service;
import service.ServiceRequest;

@Controller
public class GroupController {
	@RequestMapping(value={"/group"}, method=RequestMethod.GET)
	public @ResponseBody <T> T searchGroup(HttpServletRequest servletRequest, HttpSession session){
		System.out.println("searchGroup");
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletRequest.getServletContext());
		
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		String gCodeParam = servletRequest.getParameter("gCode");
		String gName = servletRequest.getParameter("gName");
		if(gCodeParam != null){
			try{
				int gCode = Integer.valueOf(gCodeParam);
				
				request.addObject("gCode", gCode);
			}catch(NumberFormatException numberFormatException){
				System.out.println("NumberFormatException");
				numberFormatException.printStackTrace();
			}
		}else if(gName != null){
			request.addObject("gName", gName);
		}
		String email = null;
		synchronized (session) {
			email = (String) session.getAttribute("email");
		}
		if(email != null){
			request.addObject("owner", email);
		}else{
			//나중에 여기 삭제...
			request.addObject("owner", "nj186@naver.com");
		}
		Service service = context.getBean("groupSearchService", Service.class);
		try{
			service.execute(request);
			Group group = request.getObject("group");
			if(group != null){
				return (T) group;
			}
			List<Group> groups = request.getObject("groups");
			if(groups != null){
				return (T) groups;
			}
			return null;
		}catch(NullPointerException nullPointerException){
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}catch(EmptyResultDataAccessException emptyResultDataAccessException){
			System.out.println(emptyResultDataAccessException.getMessage());
			emptyResultDataAccessException.printStackTrace();
		}
		return null;
	}
	
}
