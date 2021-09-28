package com.expense.management.controller;

import com.expense.management.entity.Expense;
import com.expense.management.exceptions.ExpenseNotFoundException;
import com.expense.management.services.ExpenseService;
import com.expense.management.services.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Integer id) {
        Expense expense = service.getByID(id);
        if (expense == null) {
            throw new ExpenseNotFoundException();
        }
        return expense;
    }

    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseById(@PathVariable("id") Integer id, @RequestBody Expense expense) {
        return service.updateExpense(id, expense);
    }
}
