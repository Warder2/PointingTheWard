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
	}
	
	//1
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
	//2
	public void memberSignIn(){
		System.out.println("memberSignIn");
	}
	//3
	public void memberSearch(){
		System.out.println("memberSearch");
	}
	//4
	public void memberModify(){
		System.out.println("memberModify");
	}
	//5
	public void memberDropout(){
		System.out.println("memberDropout");
	}
	//6
	public void eventRegist(){
		System.out.println("eventRegist");
	}
	//7
	public void eventSearch(){
		System.out.println("eventSearch");
	}
	//8
	public void eventModify(){
		System.out.println("eventModify");
		
		this.service = context.getBean("eventModifyService",Service.class);
		ServiceRequest serviceRequest = context.getBean("serviceRequest",ServiceRequest.class);
		
		serviceRequest.addObject("title", "newTitle");
		service.execute(serviceRequest);
	}
	//9
	public void eventDelete(){
		System.out.println("eventDelete");
		
		service = context.getBean("eventDeleteService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("eventTitle", "title");
		
		service.execute(request);
	}
	//10
	public void friendAddtion(){
		System.out.println("friendAddtion");
	}
	//11
	public void friendSearch(){
		System.out.println("friendSearch");
	}
	//12
	public void friendModify(){
		System.out.println("friendModify");
	}
	//13
	public void friendDelete(){
		System.out.println("friendDelete");
	}
	//14
	public void groupCreate(){
		System.out.println("groupCreate");
	}
	//15
	public void groupSearch(){
		System.out.println("groupSearch");
	}
	//16
	public void groupModify(){
		System.out.println("groupModify");
	}
	//17
	public void groupDelete(){
		System.out.println("groupDelete");
	}
	//18
	public void placeRegist(){
		System.out.println("placeRegist");
	}
	//19
	public void placeSearch(){
		System.out.println("placeSearch");
	}
	//20
	public void placeModify(){
		System.out.println("placeModify");
	}
	//21
	public void placeDelete(){
		System.out.println("placeDelete");
	}
	//22
	public void wardRecommendService(){
		System.out.println("wardRecommendService");
	}
	
	
	/*public void registEventAndDelete(){
		System.out.println("registEventAndDelete");
		service = context.getBean("registAndDeleteService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		Event event = new Event("title", "sDate", "eDate", "sTime", "eTime", "content", new Place("place name", new Point(0, 0)), null);
		request.addObject("eventInfo", event);
		request.addObject("eventTitle", event.getTitle());
		
		service.execute(request);
	}*/
	
	
	
}
