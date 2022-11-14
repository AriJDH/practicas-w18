package excepciones.exceptions;

public class NotFoudException extends RuntimeException{

    public NotFoudException(){
    }

    public NotFoudException(String message){
        super(message);
    }
}
