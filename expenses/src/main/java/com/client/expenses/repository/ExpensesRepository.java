package com.client.expenses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.expenses.model.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer>{
	
	public abstract List<Expenses> findByClientId(Integer clientId);

}
