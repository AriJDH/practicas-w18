package meli.bootcamp.blog.exception;

import meli.bootcamp.blog.dto.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(Exception e)
    {
        ExceptionDto excDto = new ExceptionDto(e.getMessage(), 404);
        return new ResponseEntity<>(excDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistBlogException.class)
    public ResponseEntity<ExceptionDto> existBlogException(Exception e)
    {
        ExceptionDto excDto = new ExceptionDto(e.getMessage(), 409);
        return new ResponseEntity<>(excDto, HttpStatus.CONFLICT);
    }
}
