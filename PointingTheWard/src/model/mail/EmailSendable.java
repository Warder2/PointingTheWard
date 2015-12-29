package model.mail;

public interface EmailSendable {
	void sendEmail(String from, String to, String subject, String content);
}
