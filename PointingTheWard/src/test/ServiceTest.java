package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import model.beans.Point;
import model.beans.Transportation;
import service.Service;
import service.ServiceRequest;

public class ServiceTest {
	private AbstractApplicationContext context;
	private Service service;
	
	@Before
	public void setup(){
		context = new GenericXmlApplicationContext("ServiceContext.xml");
		//쪼큼 수정
	}
	
	//1
	@Test
	public void memberSignUp(){
		System.out.println("memberSignUp");
		Service service = context.getBean("memberSignUpService",Service.class);
		//1. 유효성 체크
		//2. Member type으로 casting
		//3. service execute
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("memberInfo", new Member("김대진","이메일","비번","주소",Transportation.TRANSIT));
		service.execute(serviceRequest);	
	}
	//2
	public void memberSignIn(){
		System.out.println("memberSignIn");
		
		Service service = context.getBean("memberSignInService" , Service.class);
		
		// id,pw 유효성 체크
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("id", "admin");
		serviceRequest.addObject("pw", "admin");
		
		service.execute(serviceRequest);
		
	}
	//3
	public void memberSearch(){
		System.out.println("memberSearch");
		
		Service service = context.getBean("memberSearchService" , Service.class);
		
		
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("email", "admin");
		
		service.execute(serviceRequest);
		
	}
	//4
	
	public void memberModify(){
		System.out.println("memberModify");
		Service service = context.getBean("memberModifyService" , Service.class);
		
		
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("email", "admin");
		serviceRequest.addObject("memberinfo", new Member("김대진","이메일","비번","주소",Transportation.TRANSIT));
		service.execute(serviceRequest);
	}
	//5
	public void memberDropout(){
		System.out.println("memberDropout");
		Service service = context.getBean("memberDropoutMacro" , Service.class);
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("email", "admin");
		service.execute(serviceRequest);
	}
	//6
	public void eventRegist(){
		System.out.println("eventRegist");
		Service service = context.getBean("eventRegistService" , Service.class);
		
		
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("eventInfo", new Event());
		service.execute(serviceRequest);
	}
	//7
	public void eventSearch(){
		System.out.println("eventSearch");
		Service service = context.getBean("eventSearchService" , Service.class);
		
		
		
		ServiceRequest serviceRequest = context.getBean("serviceRequest", ServiceRequest.class);
		serviceRequest.addObject("sDate", "1/6");
		serviceRequest.addObject("eDate", "1/6");

		service.execute(serviceRequest);
	}
	//8
	public void eventModify(){
		System.out.println("eventModify");
		
		service = context.getBean("eventModifyService",Service.class);
		ServiceRequest serviceRequest = context.getBean("serviceRequest",ServiceRequest.class);
		
		serviceRequest.addObject("test", "success");
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
		
		service = context.getBean("friendAddtionService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//11
	public void friendSearch(){
		System.out.println("friendSearch");
		
		service = context.getBean("friendSearchService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//12
	public void friendModify(){
		System.out.println("friendModify");
		
		service = context.getBean("friendModifyService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//13
	public void friendDelete(){
		System.out.println("friendDelete");
		
		service = context.getBean("friendDeleteService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//14
	public void groupCreate(){
		System.out.println("groupCreate");
		
		service = context.getBean("groupCreateService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//15
	public void groupSearch(){
		System.out.println("groupSearch");
		
		service = context.getBean("groupSearchService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//16
	public void groupModify(){
		System.out.println("groupModify");
		
		service = context.getBean("groupModifyService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//17
	public void groupDelete(){
		System.out.println("groupDelete");
		
		service = context.getBean("groupDeleteService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("test", "success");
		
		service.execute(request);
	}
	//18
	
	public void placeRegist(){
		System.out.println("placeRegistService");
		
		service = context.getBean("placeRegistService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("placeInfo", new Place("장소이름",new Point("0.0","0.0")));
		
		service.execute(request);
	}
	//19
	
	public void placeSearch(){
		System.out.println("placeSearch");
		service = context.getBean("placeSearchService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("placeName","장소명");
		
		service.execute(request);
	}
	//20
	
	public void placeModify(){
		System.out.println("placeModify");
		service = context.getBean("placeModifyService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("placeInfo",new Place("장소이름",new Point("0","0")));
		request.addObject("newPlaceInfo", new Place("새장소이름",new Point("1.0","1.0")));
		
		service.execute(request);
	}
	//21

	public void placeDelete(){
		System.out.println("placeDelete");
		service = context.getBean("placeDeleteService", Service.class);
		ServiceRequest request = context.getBean("serviceRequest", ServiceRequest.class);
		
		request.addObject("placeInfo",new Place("장소이름",new Point("0.0","0.0")));
				
		service.execute(request);
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
