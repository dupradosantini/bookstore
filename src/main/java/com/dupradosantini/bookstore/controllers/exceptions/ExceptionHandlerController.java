package com.dupradosantini.bookstore.controllers.exceptions;

import com.dupradosantini.bookstore.services.exceptions.DataIntegrityViolationException;
import com.dupradosantini.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
      StandardError error =  new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),e.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
        StandardError error =  new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> ValidationError(MethodArgumentNotValidException e, ServletRequest request){
        ValidationError error = new ValidationError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "Campos inválidos.");
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addErrors(x.getField(),x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

