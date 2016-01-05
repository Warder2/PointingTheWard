package validation;

public interface Validator {
	<T> void validate(T target);
	<T> void validate(Object target, Class<T> type);
}
