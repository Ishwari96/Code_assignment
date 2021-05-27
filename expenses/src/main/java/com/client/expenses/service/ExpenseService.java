package com.client.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.expenses.model.Expenses;
import com.client.expenses.repository.ExpensesRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpensesRepository expensesRepository;

	public Expenses addExpense(Expenses expense) {
		return expensesRepository.save(expense);
	}

	public List<Expenses> getExpenseByClientId(Integer clientId) {
		return expensesRepository.findByClientId(clientId);
	}

}
