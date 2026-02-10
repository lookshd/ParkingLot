package exception;

public class NoParkingFloorFoundException extends RuntimeException {
    public NoParkingFloorFoundException(String message) {
        super(message);
    }
}

