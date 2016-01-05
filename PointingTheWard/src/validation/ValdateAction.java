package validation;

import java.util.regex.Pattern;

import model.beans.Transportation;
import validation.exception.NonValidatedEmailFormEception;
import validation.exception.NonValidatedTransportationFormException;

public class ValdateAction {
	public static void checkEmailForm(String emailForm){
		if (emailForm == null){
			throw new NullPointerException("email form is null");
		}else if(!Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",emailForm.trim())){
			throw new NonValidatedEmailFormEception(emailForm);
		}
	}
	
	public static void checkTransportationForm(String transportationForm){
		if(transportationForm == null){
			throw new NullPointerException("transportation form is null");
		}else if(Transportation.valueOfByStr(transportationForm) == null){
			throw new NonValidatedTransportationFormException(transportationForm);
		}
	}
}
