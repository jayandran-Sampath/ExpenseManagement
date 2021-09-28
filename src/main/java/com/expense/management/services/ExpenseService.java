package com.expense.management.services;

import com.expense.management.entity.Expense;

import java.util.List;

public interface ExpenseService {
    public List<Expense> getAllExpenses();

    public Expense getByID(Integer id);

    public Expense addExpense(Expense expense);

    public Expense updateExpense(Integer id, Expense expense);
}
