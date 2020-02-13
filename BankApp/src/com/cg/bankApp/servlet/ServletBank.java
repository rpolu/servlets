package com.cg.bankApp.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bankApp.pojo.BankAccount;
import com.cg.bankApp.pojo.CurrentAccount;
import com.cg.bankApp.pojo.Customer;
import com.cg.bankApp.pojo.SavingsAccount;
import com.cg.bankApp.services.ServicesBankApp;

@WebServlet("*.bankApp")
public class ServletBank extends HttpServlet {

	Customer customer;
	SavingsAccount savingsAccount;
	CurrentAccount currentAccount;
	BankAccount bankAccount;
	ServicesBankApp service = new ServicesBankApp();

	public ServletBank() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		String action = request.getServletPath();

		System.out.println(action);
		
		switch (action) {
		case "/addNewAccount.bankApp":
			response.sendRedirect("addNewAccount.jsp");

			break;
		case "/viewAllAccounts.bankApp":
			String accountType;
			Collection<BankAccount> bankAccounts = service.viewAllAccounts();
			System.out.println(bankAccounts);

			request.setAttribute("bankAccounts", bankAccounts);
			rd = request.getRequestDispatcher("viewAll.jsp");
			rd.forward(request, response);
			break;
		case "/search.bankApp":
			break;
		case "/fundTransfer.bankApp":
			rd = request.getRequestDispatcher("fundTransfer.jsp");
			rd.forward(request, response);
			break;
		case "/saveFundTransfer.bankApp":
			int fromAccNum = Integer.parseInt(request.getParameter("fromAccNo"));
			int toAccNum = Integer.parseInt(request.getParameter("toAccNo"));
			int balTransfer = Integer.parseInt(request.getParameter("amount"));
			System.out.println(fromAccNum + " " + toAccNum + " " + balTransfer);
			int retrievedBalance = service.withdraw(fromAccNum, balTransfer);
			System.out.println("ret bal"+retrievedBalance);
			if (retrievedBalance >= 0) {
				int accBal = service.deposit(toAccNum, balTransfer);
				if (accBal != 0) {
					request.setAttribute("retrievedBalance", retrievedBalance);
					request.setAttribute("accBal", accBal);
					request.setAttribute("fromAccNum", fromAccNum);
					request.setAttribute("toAccNum", toAccNum);
					request.setAttribute("balTransfer", balTransfer);
					 rd = request.getRequestDispatcher("successFundTransfer.jsp");
					 rd.forward(request, response);
				} else {
					response.sendRedirect("errorAccNotFound.jsp");
				}
			} else if (retrievedBalance == -2)
				response.sendRedirect("errorAccNotFound.jsp");
			else if (retrievedBalance == -1)
				response.sendRedirect("insufficientBal.jsp");

			break;
		case "/withdraw.bankApp":
			request.setAttribute("operation", "Withdraw Funds");
			rd = request.getRequestDispatcher("withdraw.jsp");
			rd.forward(request, response);
			break;
		case "/deposit.bankApp":
			request.setAttribute("operation", "Deposit Funds");
			rd = request.getRequestDispatcher("deposit.jsp");
			rd.forward(request, response);

			break;
		case "/saveDeposit.bankApp":
			int accNum = Integer.parseInt(request.getParameter("accNo"));
			int bal = Integer.parseInt(request.getParameter("amount"));
			System.out.println(request.getParameter("transactionType"));
			System.out.println(accNum + " " + bal);
			int accBal = service.deposit(accNum, bal);
			if (accBal != 0) {
				request.setAttribute("accNum", accNum);
				request.setAttribute("accBal", accBal);
				rd = request.getRequestDispatcher("successDepWith.jsp");
				rd.forward(request, response);
			} else
				response.sendRedirect("errorAccNotFound.jsp");
			break;
		case "/saveWithdraw.bankApp":
			int accNumb = Integer.parseInt(request.getParameter("accNo"));
			int balance1 = Integer.parseInt(request.getParameter("amount"));

			System.out.println(accNumb + " " + balance1);
			int accBalance = service.withdraw(accNumb, balance1);
			System.out.println(accBalance);
			if (accBalance >= 0) {
				request.setAttribute("accNum", accNumb);
				request.setAttribute("accBal", accBalance);
				rd = request.getRequestDispatcher("successDepWith.jsp");
				rd.forward(request, response);
			} else if (accBalance == -2)
				response.sendRedirect("errorAccNotFound.jsp");
			else if (accBalance == -1)
				response.sendRedirect("insufficientBal.jsp");
			break;

		case "/newAccount.bankApp":
			int accNo = 0;
			String name = request.getParameter("customerName");
			String emailId = request.getParameter("emailId");
			String dob = request.getParameter("dob");
			String phNum = request.getParameter("telephone");
			String accType = request.getParameter("accType");
			boolean isSalaried = Boolean.parseBoolean(request.getParameter("salaried"));
			String balance = request.getParameter("balance");
			String odLimit = request.getParameter("odLimit");
			customer = new Customer(name, emailId, dob, phNum);
			if (accType == "savingsAccount") {

				savingsAccount = new SavingsAccount(customer, Integer.parseInt(balance), isSalaried);
				accNo = bankAccount.getAccountNumber();
			} else if (accType == "currentAccount") {
				currentAccount = new CurrentAccount(customer, Integer.parseInt(balance), Integer.parseInt(odLimit));
				accNo = bankAccount.getAccountNumber();
			}
			System.out.println(name + " " + emailId + " " + dob + " " + phNum + " " + accType + " " + isSalaried);
			System.out.println(balance + " " + odLimit);
			System.out.println(accNo);
			System.out.println(bankAccount.getAccountId());
			request.setAttribute("name", name);
			request.setAttribute("accNo", accNo);
			rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);

			break;
		case "/populate.bankApp":
			service.populateAccount();
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
