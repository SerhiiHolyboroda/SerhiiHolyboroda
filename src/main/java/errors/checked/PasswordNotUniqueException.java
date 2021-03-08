package errors.checked;

public class PasswordNotUniqueException extends Exception {

    public PasswordNotUniqueException(String message) {
        super(message);
    }
}