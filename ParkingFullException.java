package exception;

//inheritance
public class ParkingFullException extends RuntimeException {
    //exception handling
    public ParkingFullException(String message) {
        super(message);
    }
}