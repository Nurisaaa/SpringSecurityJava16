package peaksoft.springsecurityjava16.exceptions.handler;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.springsecurityjava16.dto.ExceptionResponse;
import peaksoft.springsecurityjava16.exceptions.AlreadyExistsException;
import peaksoft.springsecurityjava16.exceptions.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleException(NotFoundException notFoundException) {
       return new ExceptionResponse(
               notFoundException.getMessage(),
               HttpStatus.NOT_FOUND
       );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleException(AlreadyExistsException e) {
        return new ExceptionResponse(
                e.getMessage(), HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleException(BadRequestException e) {
        return new ExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }
}
