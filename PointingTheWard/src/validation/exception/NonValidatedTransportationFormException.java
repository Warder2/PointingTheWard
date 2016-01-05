package validation.exception;

public class NonValidatedTransportationFormException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1573106569371603201L;
	private String transportationForm;
	
	public NonValidatedTransportationFormException() {
	}
	public NonValidatedTransportationFormException(String transportationForm) {
	}
	public NonValidatedTransportationFormException(String message, String transportationForm) {
		super(message);
		this.transportationForm = transportationForm;
	}
	
	public String getTransportationForm() {
		return transportationForm;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + ", transportation form : " + getTransportationForm();
	}
}
