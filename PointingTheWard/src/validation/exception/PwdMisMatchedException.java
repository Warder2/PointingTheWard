package validation.exception;

public class PwdMisMatchedException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2673729833551814485L;
	private String pwd;
	
	public PwdMisMatchedException() {
	}
	public PwdMisMatchedException(String pwd) {
		this(pwd, "mismatched pwd");
	}
	public PwdMisMatchedException(String pwd, String message){
		super(message);
		this.pwd = pwd;
	}
	@Override
	public String getMessage() {
		return super.getMessage() + ", pwd : " + pwd;
	}
}
