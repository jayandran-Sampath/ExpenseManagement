package com.expense.management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpenseControllerErrorAdvice {
    @ExceptionHandler({ExpenseNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(ExpenseNotFoundException e) {
        return error(HttpStatus.NOT_FOUND, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
