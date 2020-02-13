package com.cg.bankApp.pojo;

public class SavingsAccount extends BankAccount {

	private int accBalance;
	private boolean isSalaried;

	public SavingsAccount(Customer customer, int accBalance, boolean isSalaried) {
		super(customer,"Savings Account");
		this.accBalance = accBalance;
		this.isSalaried = isSalaried;

	}

	public int getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(int accBalance) {
		this.accBalance = accBalance;
	}

	public boolean isSalaried() {
		return isSalaried;
	}

	public void setSalaried(boolean isSalaried) {
		this.isSalaried = isSalaried;
	}

}
