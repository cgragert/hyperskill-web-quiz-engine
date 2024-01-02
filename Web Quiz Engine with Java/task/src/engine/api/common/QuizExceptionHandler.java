package engine.api.common;

import engine.service.common.BadRequestException;
import engine.service.common.UnauthorizedOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class QuizExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Void> handleNoSuchQuiz() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({ConstraintViolationException.class, BadRequestException.class})
    public ResponseEntity<Void> handleConstraintViolations() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(UnauthorizedOperationException.class)
    public ResponseEntity<Void> handleUnauthorizedOperations() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}
