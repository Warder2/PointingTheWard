package model.mail;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	private String username; // gmail 사용자;
	private String password;  // 패스워드;
	
	public SMTPAuthenticator() {
		username = "yjhmailtest@gmail.com";
		password = "dpwkdgo90test";
	}
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
