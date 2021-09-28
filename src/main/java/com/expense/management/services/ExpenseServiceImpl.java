package com.expense.management.services;

import com.expense.management.entity.Expense;
import com.expense.management.exceptions.ExpenseNotFoundException;
import com.expense.management.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense getByID(Integer id) {
        Expense expense = repository.findById(id).orElse(null);
        return expense;
    }

    @Override
    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public Expense updateExpense(Integer id, Expense expense) {
        Expense expenseById = repository.findById(id).orElse(null);
        if (expenseById == null) {
            throw new ExpenseNotFoundException();
        }
        expense.setId(id);
        repository.save(expense);
        return expense;
    }
}
