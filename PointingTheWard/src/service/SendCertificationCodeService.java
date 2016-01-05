package service;

import model.certification.CertificationCodeCreator;
import model.mail.EmailSendable;

public class SendCertificationCodeService implements Service{
	private EmailSendable sender;
	private CertificationCodeCreator creator;
	
	public void setCreator(CertificationCodeCreator creator) {
		this.creator = creator;
	}
	
	public void setSender(EmailSendable sender) {
		this.sender = sender;
	}
	
	@Override
	public void execute(ServiceRequest request) {
		String email = request.getObject("email");
		String code = creator.createCertificationCode(); 
		sender.sendEmail(email, "PointingTheWard 인증번호 발송", code);
		
		request.addObject("code", code);
	}

}
