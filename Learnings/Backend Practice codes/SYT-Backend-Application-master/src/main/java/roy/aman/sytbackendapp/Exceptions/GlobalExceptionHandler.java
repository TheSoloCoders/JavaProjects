package roy.aman.sytbackendapp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> exceptionHandlerMethod(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse exRes = new ApiResponse(message, false);
        return new ResponseEntity<>(exRes, HttpStatus.NOT_FOUND);
    }

    // Handling MethodArgumentNotValidException of validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validationExpHandler(MethodArgumentNotValidException exp) {
        Map<String, String> response = new HashMap<>();

        exp.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String message = err.getDefaultMessage();

            response.put(fieldName, message);
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
