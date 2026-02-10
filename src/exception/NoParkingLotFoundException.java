package exception;

public class NoParkingLotFoundException extends RuntimeException {
    public NoParkingLotFoundException(String message) {
        super(message);
    }
}

