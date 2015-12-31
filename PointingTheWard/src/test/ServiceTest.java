package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import model.beans.Point;
import service.Service;
import service.ServiceRequest;

public class ServiceTest {
	private AbstractApplicationContext context;
	private Service service;
	
	@Before
	public void setup(){
		context = new GenericXmlApplicationContext("ServiceContext.xml");
		System.out.println(1);
	}
	
	@Test
	public void deletEvent(){
		System.out.println("deletEvent");
		service = context.getBean("deleteEventService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		request.addObject("eventTitle", "title");
		service.execute(request);
	}
	
	@Test
	public void registEventAndDelete(){
		System.out.println("registEventAndDelete");
		service = context.getBean("registAndDeleteService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		Event event = new Event("title", "sDate", "eDate", "sTime", "eTime", "content", new Place("place name", new Point(0, 0)), null);
		request.addObject("eventInfo", event);
		request.addObject("eventTitle", event.getTitle());
		
		service.execute(request);
	}
	
	@Test
	public void memberSignUp(){
		System.out.println("memberSignUp");
		Service service = context.getBean("memberSignUpService",Service.class);
		//1. 유효성 체크
		//2. Member type으로 casting
		//3. service execute
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("memberInfo", new Member("김대진","이메일","비번","주소","교통"));
		service.execute(serviceRequest);
		
	}
}
