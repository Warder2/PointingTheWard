package validation.exception;

public class NonValidatedEmailFormEception extends RuntimeException{
	private String emailForm;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8277448767828262649L;
	
	public NonValidatedEmailFormEception() {
	}
	public NonValidatedEmailFormEception(String emailForm) {
		this("nonvalidated email form", emailForm);
	}
	public NonValidatedEmailFormEception(String message, String emailForm) {
		super(message);
		this.emailForm = emailForm;
	}
	
	public String getEmailForm() {
		return emailForm;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + ", email form : " + getEmailForm();
	}
}
