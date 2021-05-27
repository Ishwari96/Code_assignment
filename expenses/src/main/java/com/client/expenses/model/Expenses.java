package com.client.expenses.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseId;
	
	private String date;
	
	private int amountSpent;
	
	private int clientId;
	
	public Expenses() {
	}

	public Expenses(String date, int amountSpent, int expenseId, int clientId) {
		super();
		this.date = date;
		this.amountSpent = amountSpent;
		this.expenseId = expenseId;
		this.clientId = clientId;
	}
	
	public String getDate() {
		return date;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}
	
	@Override
	public String toString() {
		return "Expenses [expenseId=" + expenseId + ", date=" + date + ", amountSpent=" + amountSpent + ", clientId="
				+ clientId + "]";
	}

}
