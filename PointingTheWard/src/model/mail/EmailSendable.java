package model.mail;

public interface EmailSendable {
	void sendEmail(String to, String subject, String content);
}
