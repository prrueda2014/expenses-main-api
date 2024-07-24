package com.expenses.main.services;

import com.expenses.main.dao.ExpenseRepository;
import com.expenses.main.exceptions.RecordNotFoundException;
import com.expenses.main.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() { return expenseRepository.findAll(); }

    public Expense getExpenseById(Long id) throws RecordNotFoundException {
        return expenseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Expense not found!"));
    }
    public Expense createExpense(Expense expense) { return expenseRepository.save(expense); }

    public Expense updateExpense(Long id, Expense requestExpense) throws RecordNotFoundException {
        return expenseRepository.findById(id).map(expense -> {
            expense.setAmount(requestExpense.getAmount());
            expense.setName(requestExpense.getName());
            expense.setDescription((requestExpense.getDescription()));
            expense.setDetails(requestExpense.getDetails());
            return expenseRepository.save(expense);
        }).orElseThrow(() -> new RecordNotFoundException("Expense not found!"));
    }

    public String deleteExpenseById(Long id) throws RecordNotFoundException {
        return expenseRepository.findById(id).map(expense -> {
            expenseRepository.delete(expense);
            return String.format("Expense %s has been deleted!", expense.getName());
        }).orElseThrow(() -> new RecordNotFoundException("Expense not found!"));
    }

}
