package com.socialnetwork.userservice.handler;

import com.socialnetwork.userservice.exceptions.NonexistingUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = NonexistingUserException.class)
    public ResponseEntity<ErrorResponse> nonexistingUserHandler(NonexistingUserException exception, WebRequest request) {
        List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("USER_NOT_FOUND", details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
