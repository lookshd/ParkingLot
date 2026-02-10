package exception;

public class NoParkingSpotAvailableException extends RuntimeException {
    public NoParkingSpotAvailableException() {
    }

    public NoParkingSpotAvailableException(String message) {
        super(message);
    }


}
