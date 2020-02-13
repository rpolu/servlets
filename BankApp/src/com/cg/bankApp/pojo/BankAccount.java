package com.cg.bankApp.pojo;

public class BankAccount {

	private Customer customer;
	private int accountNumber;
	static int accountId=100;
	private String accType;

//	static {
//		accountId = 100;
//	}
//	{
//		accountNumber = ++accountId;
//	}

	public BankAccount(Customer customer, String accType) {
		accountNumber = accountId + 1;
		accountId++;
		this.accType = accType;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public static int getAccountId() {
		return accountId;
	}

	public static void setAccountId(int accountId) {
		BankAccount.accountId = accountId;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
