package com.bean;

public class Account {
	private int account_id;
	private int customerid;
	private String acc_type;
	private double balance;
	private String cr;
	private String cr_last;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCr() {
		return cr;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public void setCr(String date) {
		this.cr = date;
	}

	public String getCr_last() {
		return cr_last;
	}

	public void setCr_last(String cr_last) {
		this.cr_last = cr_last;
	}
	public Account(int customerid, String acc_type, double balance, String cr,
			String cr_last) {
		super();
		this.customerid = customerid;
		this.acc_type = acc_type;
		this.balance = balance;
		this.cr = cr;
		this.cr_last = cr_last;
	}

	public Account() {
	}

	public Account(int customerid, String acc_type, double balance) {
		super();
		this.customerid = customerid;
		this.acc_type = acc_type;
		this.balance = balance;

	}

}