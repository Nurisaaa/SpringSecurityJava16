package peaksoft.springsecurityjava16.dto;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private String message;
    private HttpStatus httpStatus;

    public ExceptionResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
