package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.AccountStatus;
import com.bean.Customer;
import com.bean.CustomerStatus;
import com.bean.Transaction;
import com.bean.UserStore_h;
import com.dao.Dao;
import com.util.DatabaseUtil;

public class Service {
	Dao d = new Dao();

	public int addCustomer(Customer c) throws SQLException,
			ClassNotFoundException {
		return d.addCustomer(c);
	}

	public Customer search(int r) throws SQLException, ClassNotFoundException {
		return d.search(r);
	}

	public boolean update(Customer c, int r) throws SQLException,
			ClassNotFoundException {
		return d.update(c, r);
	}

	public boolean delete(int r) throws SQLException, ClassNotFoundException {
		return d.delete(r);
	}

	public UserStore_h validate(String uname, String pass) throws SQLException,
			ClassNotFoundException {
		return d.validate(uname, pass);
	}

	public int addAccount(Account a) {
		return d.addAccount(a);
	}

	public Account deposite(Double amount, int acc_id) {
		// TODO Auto-generated method stub
		return d.deposite(amount, acc_id);
	}

	public ArrayList<Account> searchacc(int id) {
		return d.searchacc(id);
	}

	public boolean deleteAccount(int accid) {
		// TODO Auto-generated method stub
		return d.deleteAccount(accid);
	}

	public Account withdraw(Double amount, int account_id) {
		return d.withdraw(amount, account_id);
	}

	public ArrayList<CustomerStatus> viewCustomerStatus() throws SQLException,
			ClassNotFoundException {
		return d.viewCustomerStatus();
	}

	public int viewCustId(int r) throws SQLException, ClassNotFoundException {
		return d.viewCustId(r);
	}

	public int viewSsnId(int r) throws SQLException, ClassNotFoundException {
		return d.viewSsnId(r);
	}

	public int viewAccid(int r) throws SQLException, ClassNotFoundException {
		return d.viewAccid(r);
	}

	public Account transfersourcewithdraw(double amount, int sourceaccid, int r) {
		// TODO Auto-generated method stub
		return d.transfersourcewithdraw(amount, sourceaccid, r);

	}

	public Account transfertargetdeposit(double amount, int targetaccid, int sourceaccid) {
		// TODO Auto-generated method stub
		return d.transfertargetdeposit(amount, targetaccid, sourceaccid);
	}

	public double gettagetprevbal(int targetaccid) {
		// TODO Auto-generated method stub
		return d.gettagetprevbal(targetaccid);
	}

	public ArrayList<AccountStatus> viewAllAccounts()
			throws ClassNotFoundException, SQLException {
		return d.viewAllAccountStatus();

	}

	public ArrayList<Transaction> accountStatement(int accid, int rows) {
		return d.accountStatement(accid, rows);
	}

	public Account searchacc1(int id) {
		return d.searchacc1(id);
	}

	public AccountStatus getAcc(int r) throws SQLException,
			ClassNotFoundException {
		return d.getAcc(r);
	}

	public CustomerStatus getCust(int r) throws SQLException,
			ClassNotFoundException {
		return d.getCust(r);
	}

	public Account getAccount(int account_id) {
		return d.getAccount(account_id);
	}

	public Account updateaccount(int id, double bal) {
		return d.updateaccount(id, bal);
	}

	public ArrayList<Transaction> getbydate(String s1, String s2, int id) {
		return d.getbydate(s1, s2, id);
	}
}
