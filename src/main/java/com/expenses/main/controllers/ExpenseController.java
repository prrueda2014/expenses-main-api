package com.expenses.main.controllers;

import com.expenses.main.exceptions.RecordNotFoundException;
import com.expenses.main.services.ExpenseService;
import com.expenses.main.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ReplicateScaleFilter;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<Page<Expense>> getAllExpenses(Pageable pageable) {
        return new ResponseEntity<>(expenseService.getAllExpenses(pageable), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable  Long id) throws RecordNotFoundException {
        return new ResponseEntity<>(expenseService.getExpenseById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense requestExpense) {
        return new ResponseEntity<>(expenseService.createExpense(requestExpense), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpenseById(@PathVariable Long id, @RequestBody Expense requestExpense) throws RecordNotFoundException {
        return new ResponseEntity<>(expenseService.updateExpense(id, requestExpense), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable Long id) throws RecordNotFoundException {
        return new ResponseEntity<>(expenseService.deleteExpenseById(id), new HttpHeaders(), HttpStatus.OK);
    }

}
