package exception;

public class NoBillFoundException extends RuntimeException {
    public NoBillFoundException(String message) {
        super(message);
    }
}
