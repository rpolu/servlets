package com.cg.bankApp.services;

import java.util.Collection;

import com.cg.bankApp.dao.DaoBankAppImpl;
import com.cg.bankApp.pojo.BankAccount;

public class ServicesBankApp {

	DaoBankAppImpl dao = new DaoBankAppImpl();
	
	public void populateAccount() {
		dao.populateAccounts();
	}
	
	public Collection<BankAccount> viewAllAccounts() {
		return dao.viewAllAccounts();
	}
	
	public int deposit (int accNo, int amount) {
		System.out.println("running deposit service");
		//dao.deposit(accNo, amount);
		return dao.deposit(accNo, amount);
	}
	public int withdraw (int accNo, int amount) {
		System.out.println("running withdraw service");
		//dao.deposit(accNo, amount);
		return dao.withdraw(accNo, amount);
	}
}
