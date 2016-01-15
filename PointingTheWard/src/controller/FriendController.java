package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.beans.Friend;
import service.Service;
import service.ServiceRequest;
import validation.ValdateAction;
import validation.exception.NonValidatedEmailFormEception;

@Controller
public class FriendController {
	@RequestMapping(value={"/friend"}, method=RequestMethod.POST)
	public @ResponseBody String addFriend(@RequestParam("fEmail") String fEmail, HttpSession session){
		System.out.println("addFriend");
		
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(session.getServletContext());
		
		try{
			ValdateAction.checkEmailForm(fEmail);
			
			Service service = context.getBean("friendAddtionService", Service.class);
			ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
			
			request.addObject("fEmail", fEmail);
			String email = "";
			synchronized (session) {
				email = (String) session.getAttribute("email");
			}
			if(email != null){
				request.addObject("email", email);
				try{
					service.execute(request);
					
					return "true";
				}catch(NullPointerException nullPointerException){
					System.out.println(nullPointerException.getMessage());
					nullPointerException.printStackTrace();
				}catch(DuplicateKeyException duplicateKeyException){
					System.out.println(duplicateKeyException.getMessage());
					duplicateKeyException.printStackTrace();
				}
			}else{
			}
		}catch(NullPointerException nullPointerException){
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}catch(NonValidatedEmailFormEception emailFormEception){
			System.out.println(emailFormEception.getMessage());
			emailFormEception.printStackTrace();
		}
		return "false";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value={"/friend"}, method=RequestMethod.GET)
	public @ResponseBody <T> T searchFriend(HttpServletRequest servletRequest, HttpSession session){
		System.out.println("searchFriend");
		
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(servletRequest.getServletContext());
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		String fEmail = servletRequest.getParameter("fEmail");
		if(fEmail == null){
			String fName = servletRequest.getParameter("fName");
			if(fName != null){
				request.addObject("fEmail", fEmail);
			}
		}else{
			try{
				ValdateAction.checkEmailForm(fEmail);
				
				request.addObject("fEmail", fEmail);
			}catch(NullPointerException nullPointerException){
				System.out.println(nullPointerException.getMessage());
				nullPointerException.printStackTrace();
			}catch(NonValidatedEmailFormEception emailFormEception){
				System.out.println(emailFormEception.getMessage());
				emailFormEception.printStackTrace();
			}
		}
		Service service = context.getBean("friendSearchService", Service.class);
		
		try{
			String email = null;
			synchronized (session) {
				email = (String) session.getAttribute("email");
			}
			if(email != null){
				request.addObject("email", email);
			}else{
				///여기를 삭제
				request.addObject("email", "nj186@naver.com");
				//return null;
			}
			service.execute(request);
			
			Friend friend = request.getObject("friend");
			if(friend != null){
				return (T) friend;
			}else{
				List<Friend> friends = request.getObject("friends");
				
				if(friends != null){
					return (T) friends;
				}
			}
		}catch(NullPointerException nullPointerException){
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}catch(EmptyResultDataAccessException emptyResultDataAccessException){
			System.out.println(emptyResultDataAccessException.getMessage());
			emptyResultDataAccessException.printStackTrace();
			return (T) "empty";
		}
		return null;
	}
}
