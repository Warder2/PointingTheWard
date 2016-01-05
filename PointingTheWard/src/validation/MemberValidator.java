package validation;

import command.SignUpMemberRequest;

public class MemberValidator implements Validator{

	@Override
	public <T> void validate(T target) {
		SignUpMemberRequest memberCommand = (SignUpMemberRequest)target;
		ValdateAction.checkEmailForm(memberCommand.getEmail());
		ValdateAction.checkTransportationForm(memberCommand.getTransportation());
	}

	@Override
	public <T> void validate(Object target, Class<T> type) {
		validate(type.cast(target));
	}
	
}
