package com.lowcontext.restapijava.exceptions.handler;

import com.lowcontext.restapijava.exceptions.ResourceNotFoundException;
import com.lowcontext.restapijava.models.dto.JSendResponse;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<JSendResponse<Void>> handlerAllExceptions(
        Exception exception,
        WebRequest request
    ) {
        JSendResponse<Void> response = JSendResponse.error(
            exception.getMessage() != null
                ? exception.getMessage()
                : "An unexpected error occurred"
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<
        JSendResponse<Map<String, String>>
    > handlerNotFoundExceptions(
        ResourceNotFoundException exception,
        WebRequest request
    ) {
        Map<String, String> errorDetails = Map.of(
            "title",
            "Resource Not Found",
            "detail",
            exception.getMessage(),
            "path",
            request.getDescription(false)
        );

        JSendResponse<Map<String, String>> response = JSendResponse.fail(
            errorDetails
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
