package ExceptionConfig;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class UniqueException extends RuntimeException{

    public UniqueException(String message){
        super(message);
    }

}
