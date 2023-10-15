package com.billing.finalproject.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.billing.finalproject.exception.CustomBadRequestError;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<CustomErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex,
            WebRequest request) {
        CustomErrorResponse errorDetails = new CustomErrorResponse("Resource not found", ex.getMessage(),
                HttpStatus.NOT_FOUND, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomBadRequestError.class)
    public final ResponseEntity<CustomErrorResponse> handleBadRequestException(CustomBadRequestError ex,
            WebRequest request) {
        CustomErrorResponse errorDetails = new CustomErrorResponse("\n" + //
                "Bad Request", ex.getMessage(),
                HttpStatus.BAD_REQUEST, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomErrorResponse> handleInternalServerError(Exception ex, WebRequest request) {
        CustomErrorResponse errorDetails = new CustomErrorResponse("Internal Server Error", ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
