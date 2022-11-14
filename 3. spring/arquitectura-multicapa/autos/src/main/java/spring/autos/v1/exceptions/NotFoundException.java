package spring.autos.v1.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }
}
