package com.example.springhandelday2.advise;

import com.example.springhandelday2.exception.InvalidException;
import com.example.springhandelday2.model.Api;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControollerAdvise {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Api> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Api> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }

    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity InvalidException(InvalidException invalidIDException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidIDException.getMessage());
    }

}
