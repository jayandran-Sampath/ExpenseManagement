package com.expense.management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Error : No Such Expense")
public class ExpenseNotFoundException extends RuntimeException {

    public ExpenseNotFoundException() {
        super("Expense not found");
    }
}
