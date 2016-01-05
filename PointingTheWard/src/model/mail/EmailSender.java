package model.mail;

import javax.mail.MessagingException;

public class EmailSender implements EmailSendable{
	/**
	  * @param args
	  */
	 public void sendEmail(String to, String subject, String content) {
//	  if(from.trim().equals("")) {
//		  System.out.println("보내는 사람을 입력하지 않았습니다.");
//	  }
	  if(to.trim().equals("")) {
		  System.out.println("받는 사람을 입력하지 않았습니다.");
	  }
	  else {
		  try {
			  EmailUtil mt = new EmailUtil();
			  // 메일보내기
			  //mt.sendEmail(from, to, cc, subject, content);
			  //mt.sendEmail(from, to, subject, content);
			  mt.sendEmail(to, subject, content);
			  System.out.println("메일 전송에 성공하였습니다.	");
		  }catch(MessagingException me) {
			  System.out.println("메일 전송에 실패하였습니다.	");
			  System.out.println("실패 이유 : " + me.getMessage());
			  me.printStackTrace();
		  }catch(Exception e) {
			  System.out.println("메일 전송에 실패하였습니다.	");
			  System.out.println("실패 이유 : " + e.getMessage());
			  e.printStackTrace();
		  }
	  }
	}
}
