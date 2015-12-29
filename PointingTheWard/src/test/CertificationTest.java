package test;

import org.junit.Test;

import model.certification.CertificationCodeCreator;
import model.mail.EmailSendable;
import model.mail.EmailSender;

public class CertificationTest {
	@Test
	public void createCertificationCode(){
		CertificationCodeCreator creator = new CertificationCodeCreator();
		String code = creator.createCertificationCode();
		
		System.out.println(code);
	}
	
	@Test
	public void sendCertificationCode(){
		CertificationCodeCreator creator = new CertificationCodeCreator();
		String code = creator.createCertificationCode();
		
		EmailSendable sendable = new EmailSender();
		sendable.sendEmail("janghaeye@gmail.com", "nj186@naver.com", "인증코드 발송 테스트", code);
	}
}
