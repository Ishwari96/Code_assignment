package com.client.expenses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.expenses.model.Expenses;
import com.client.expenses.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	/**
	 * Create difference expenses for given client using clientId
	 * @param expense
	 * @return
	 */
	@PostMapping("/expense")
    public ResponseEntity<Expenses> addClientExpense(@RequestBody final Expenses expense){
		Expenses expenses = expenseService.addExpense(expense);
        return new ResponseEntity<Expenses>(expenses, HttpStatus.OK);
    }
	
	/**
	 * Fetch expense details using client id
	 * @param clientId
	 * @return
	 */
	@GetMapping("/expense/client/{clientId}")
	public ResponseEntity <List<Expenses>> getClientDetailsById(@PathVariable int clientId) {
		List<Expenses> result = expenseService.getExpenseByClientId(clientId);
		return new ResponseEntity<List<Expenses>>(result, HttpStatus.OK);
	}

}
