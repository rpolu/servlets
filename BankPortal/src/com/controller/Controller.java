package com.controller;

import com.bean.UserStore_h;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Account;
import com.bean.AccountStatus;
import com.bean.Customer;
import com.bean.CustomerStatus;
import com.bean.Transaction;
import com.service.Service;
import com.util.CheckValidation;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
		String action = request.getParameter("action");
		HttpSession ses=request.getSession(false);
		if(!action.equals("login")&&!CheckValidation.isvalid(ses))
		{
			request.setAttribute("message","Session is Invalid.Please login again!");	
			RequestDispatcher rq = request
					.getRequestDispatcher("login.jsp");
			rq.forward(request, response);
		}
	 else if (action.equals("login")) {
			String Username = request.getParameter("username");
			String Password = request.getParameter("pwd1");
			try {
				UserStore_h uh = s.validate(Username, Password);
				if (uh == null) {
					request.setAttribute("message","*Please enter valid username and password");
					RequestDispatcher rq = request
							.getRequestDispatcher("login.jsp");
					rq.forward(request, response);
				} else {
					System.out.println("logedin");
					System.out.println(uh.getRole());
					HttpSession ses1 = request.getSession(true);
					ses1.setAttribute("user",Username);
					ses1.setAttribute("role",uh.getRole());
					if (uh.getRole().equalsIgnoreCase("executive")) {
						RequestDispatcher rq = request
								.getRequestDispatcher("index.jsp");
						rq.forward(request, response);
					} else if (uh.getRole().equalsIgnoreCase("cashier"))
					{
						RequestDispatcher rq = request
								.getRequestDispatcher("cashierOperation.jsp");
						rq.forward(request, response);
					}
					else
					{	request.setAttribute("message","*Please enter valid username and password");
						RequestDispatcher rq = request
								.getRequestDispatcher("login.jsp");
						rq.forward(request, response);
					}
				}
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	else if(request.getParameter("action").equals("logout"))
	{
		HttpSession ses1=request.getSession(false);
		ses1.invalidate();
		request.setAttribute("message","Logout Successfully");
		RequestDispatcher rq = request
		.getRequestDispatcher("login.jsp");
		rq.forward(request, response);}

		else if (action.equals("add")) {
			request.setAttribute("message","");
			request.setAttribute("message1","");
			RequestDispatcher rq = request.getRequestDispatcher("Add.jsp");
			rq.forward(request, response);
		} else if (action.equals("ad")) {
			Customer c = new Customer(request.getParameter("name"),
					Integer.parseInt(request.getParameter("age")),
					request.getParameter("address1"),
					request.getParameter("address2"),
					request.getParameter("city"), request.getParameter("state"));
			c.setSsn(Integer.parseInt(request.getParameter("ssn")));
			try {
				int r=s.viewSsnId(Integer.parseInt(request.getParameter("ssn")));
				if(r>0)
				{		request.setAttribute("message1","");
					request.setAttribute("message","*SSN ID already exist");
					RequestDispatcher rq = request.getRequestDispatcher("Add.jsp");
					rq.forward(request, response);
				}
				else{
				int b = s.addCustomer(c);
				request.setAttribute("custid",b);
				if (b>0) {
					RequestDispatcher rq = request.getRequestDispatcher("CustomerSuccess.jsp");
					rq.forward(request, response);
				} else {
					RequestDispatcher rq = request
							.getRequestDispatcher("Error.jsp");
					rq.forward(request, response);

				}}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ((action.equals("deletec"))||(action.equals("Cancel"))) {
			String msg = "";
			request.setAttribute("message", msg);
			RequestDispatcher rq = request.getRequestDispatcher("Search.jsp");
			rq.forward(request, response);

		} else if (action.equals("search")) {
			int r = Integer.parseInt(request.getParameter("id"));
			String str = request.getParameter("ide1");
			try {
				if (str.equalsIgnoreCase("CUSTOMERID")) {
				int i = s.viewCustId(r);
				System.out.println(i);
				if (i == 0) {
					String msg = "*Customer  id is not present please enter valid Customer id";
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("Search.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", "");
					Customer c = s.search(r);
					request.setAttribute("view", c);
					if (c != null) {
						RequestDispatcher rq = request
								.getRequestDispatcher("viewDetails.jsp");
						rq.forward(request, response);
					}
				}
				}
				else{
				int i = s.viewSsnId(r);
				System.out.println(i);
				if (i == 0) {
					String msg = "*SSN  id is not present please enter valid SSN id";
					request.setAttribute("message", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("Search.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", "");
					Customer c = s.search(r);
					request.setAttribute("view", c);
					if (c != null) {
						RequestDispatcher rq = request
								.getRequestDispatcher("viewDetails.jsp");
						rq.forward(request, response);
					}
				}}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (action.equals("update")) {
			String msg = "";
			request.setAttribute("message", msg);
			RequestDispatcher rq = request.getRequestDispatcher("Usearch.jsp");
			rq.forward(request, response);

		} else if (action.equals("usearch")) {
			int r = Integer.parseInt(request.getParameter("id"));
			String str = request.getParameter("ide");
			if (str.equalsIgnoreCase("SSNID")) {
				try {
					int i = s.viewSsnId(r);
					System.out.println(i);
					if (i == 0) {
						String msg = "*SSN  id is not present please enter valid SSN id";
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("Usearch.jsp");
						rd.forward(request, response);
					} else {
						Customer c = s.search(r);
						request.setAttribute("view", c);
						if (c != null) {
							RequestDispatcher rq = request
									.getRequestDispatcher("view.jsp");
							rq.forward(request, response);
						}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {

				try {
					int i = s.viewCustId(r);
					System.out.println(i);
					if (i == 0) {
						String msg = "*Customer  id is not present please enter valid customer id";
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("Usearch.jsp");
						rd.forward(request, response);
					} else {
						Customer c = s.search(r);
						request.setAttribute("view", c);
						if (c != null) {
							RequestDispatcher rq = request
									.getRequestDispatcher("view.jsp");
							rq.forward(request, response);
						}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} else if (action.equals("Delete")) {
			int r = Integer.parseInt(request.getParameter("id111"));
			try {
				boolean b = s.delete(r);
				System.out.println(b);
				if (b) {
					RequestDispatcher rq = request
							.getRequestDispatcher("Dsuccess.jsp");
					rq.forward(request, response);
				} else {
					Customer c = s.search(r);
					request.setAttribute("view", c);
					request.setAttribute("message","*Customer can't be deleted");
					RequestDispatcher rd = request
							.getRequestDispatcher("viewDetails.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if (action.equals("Update1")) {
			int r = Integer.parseInt(request.getParameter("id2"));
			Customer c = new Customer(request.getParameter("name"),
					Integer.parseInt(request.getParameter("age")),
					request.getParameter("address1"),
					request.getParameter("address2"),
					request.getParameter("city"), request.getParameter("state"));
			try {
				boolean b = s.update(c,r);
				if (b) {
					RequestDispatcher rq = request
							.getRequestDispatcher("Usuccess.jsp");
					rq.forward(request, response);
				} else {
					RequestDispatcher rq = request
							.getRequestDispatcher("Error.jsp");
					rq.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(action.equals("Reset"))
		{
			int r = Integer.parseInt(request.getParameter("id2"));
			Customer c;
			try {
				c = s.search(r);
				request.setAttribute("view", c);
				if (c != null) {
					RequestDispatcher rq = request
							.getRequestDispatcher("view.jsp");
					rq.forward(request, response);
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
						
		}
		else if (action.equals("backto")) {
			{
				System.out.println("in backto");
				Account acc= new Account();
				double balance= Double.parseDouble(request.getParameter("balance"));
				System.out.println(balance);
				int accid= Integer.parseInt(request.getParameter("id"));
				System.out.println(accid);
				acc=s.updateaccount(accid, balance);
				request.setAttribute("obj", acc);
				RequestDispatcher rd = request
						.getRequestDispatcher("view_info.jsp");
				rd.forward(request, response);
				

			}
		}
		else if (action.equals("addaccount")) {
			int custid = Integer.parseInt(request.getParameter("custid"));
			String type = request.getParameter("type");
			double bal = Double.parseDouble(request.getParameter("bal"));
            int j=0;
			try {
				j = s.viewCustId(custid);
				if(j==1)
	            {
	    			Account b = new Account(custid, type, bal);
	    			int i = s.addAccount(b);
	    			System.out.println(i);
	    			
	    				request.setAttribute("accid", i);
	    				RequestDispatcher rd = request
	    						.getRequestDispatcher("accaddsuccess.jsp");
	    				rd.forward(request, response);
	    				 }
	            else
	            {
	            	request.setAttribute("message", "*Customer id is not present please enter valid Customer id");
	    			RequestDispatcher rq = request.getRequestDispatcher("AddAccount.jsp");
	    			rq.forward(request, response);
	            }
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			

		else if (action.equals("searchfor")) {
			int r = Integer.parseInt(request.getParameter("id"));
			String str = request.getParameter("ide");
			
				try {
					if (str.equalsIgnoreCase("SSNID")) {
					int i = s.viewSsnId(r);
					System.out.println(i);
					if (i == 0) {
						String msg = "*SSN  ID is not present please enter valid SSN Id";
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("delete_acc.jsp");
						rd.forward(request, response);
					} else {
						ArrayList<Account> c = s.searchacc(r);
						request.setAttribute("array12", c);
						System.out.println(c.size());
						if (c.size()==0) {
							request.setAttribute("message", "*Selected SSN ID does not have any accounts");
							RequestDispatcher rd = request
									.getRequestDispatcher("delete_acc.jsp");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rq = request
									.getRequestDispatcher("DisplayAllAcc.jsp");
							rq.forward(request, response);
						}
					}
			}else if (str.equalsIgnoreCase("CustomerId")) {
					int i =s.viewCustId(r);
					System.out.println(i);
					if (i == 0) {
						String msg = "*Customer ID is not present please enter valid Customer ID";
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("delete_acc.jsp");
						rd.forward(request, response);
					} else {
						ArrayList<Account> c = s.searchacc(r);
						request.setAttribute("array12", c);
						System.out.println(c.size());
						if (c.size()==0) {
							request.setAttribute("message", "*Selected Customer ID does not have any accounts");
							RequestDispatcher rd = request
									.getRequestDispatcher("delete_acc.jsp");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rq = request
									.getRequestDispatcher("DisplayAllAcc.jsp");
							rq.forward(request, response);
						}
					}
			}
					else if (str.equalsIgnoreCase("AccountId")) {
						int i =s.viewAccid(r);
						System.out.println(i);
						if (i == 0) {
							String msg = "*Account ID is not present please enter valid Account ID";
							request.setAttribute("message", msg);
							RequestDispatcher rd = request
									.getRequestDispatcher("delete_acc.jsp");
							rd.forward(request, response);
						} else {
							ArrayList<Account> c = s.searchacc(r);
							request.setAttribute("array12", c);
							System.out.println(c.size());
								RequestDispatcher rq = request
										.getRequestDispatcher("DisplayAllAcc.jsp");
								rq.forward(request, response);
						}
			}
			}
				catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}

		else if (action.equals("Delete11"))

		{
			int accid = Integer.parseInt(request.getParameter("value"));
			System.out.println(accid);
			boolean b = s.deleteAccount(accid);
			if (b == true) {
				RequestDispatcher rd = request
						.getRequestDispatcher("acc_delete_success.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("acc_delete_fail.jsp");
				rd.forward(request, response);
			}

		}

		else if (action.equals("getaccount")) {
			System.out.println("in getaccount");
			int id = Integer.parseInt(request.getParameter("id"));
			String str1 = (String) request.getParameter("number");
			if (str1.equalsIgnoreCase("Account ID")) {
				try {
					int i = s.viewAccid(id);
					System.out.println(i);
					if (i == 0) {
						String msg = "*Account id is not present please enter valid account id";
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("Cashier1.jsp");
						rd.forward(request, response);
					} else {
						Account acc = s.searchacc1(id);
						request.setAttribute("obj", acc);
						RequestDispatcher rd = request
								.getRequestDispatcher("view_info.jsp");
						rd.forward(request, response);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (str1.equalsIgnoreCase("Customer ID")) {
				try {
					int i = s.viewCustId(id);
					System.out.println(i);
					if (i == 0) {
						String msg = "*Customer id is not present please enter valid customer id";
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("Cashier1.jsp");
						rd.forward(request, response);
					} else {

						ArrayList<Account> acc = s.searchacc(id);
						request.setAttribute("obj", acc);
						RequestDispatcher rd = request
								.getRequestDispatcher("getaccbeforeview.jsp");
						rd.forward(request, response);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (str1.equalsIgnoreCase("SSN ID")) {
				try {
					int i = s.viewSsnId(id);
					System.out.println(i);
					if (i == 0) {
						String msg = "*SSN ID is not present please enter valid SSN ID";
						request.setAttribute("message", msg);
						RequestDispatcher rd = request
								.getRequestDispatcher("Cashier1.jsp");
						rd.forward(request, response);
					} else {

						ArrayList<Account> acc = s.searchacc(id);
						request.setAttribute("obj", acc);
						RequestDispatcher rd = request
								.getRequestDispatcher("getaccbeforeview.jsp");
						rd.forward(request, response);
					}

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		else if (action.equals("deposite")) {
			System.out.println("in deposite");
			int acc_id = Integer.parseInt(request.getParameter("accid"));
			System.out.println(acc_id);
			double balance = Double
					.parseDouble(request.getParameter("balance"));
			System.out.println(balance);
			System.out.println("*************&&&&&&&&&&");
			request.setAttribute("accid", acc_id);
			request.setAttribute("bal", balance);
			RequestDispatcher rd = request
					.getRequestDispatcher("deposite1.jsp");
			rd.forward(request, response);

		}

		else if (action.equals("depositehere")) {
			System.out.println("in deposite here...");
			double balance = Double
					.parseDouble(request.getParameter("balance"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			int accid = Integer.parseInt(request.getParameter("accid"));
			System.out.println(accid);
			Account acc = s.deposite(amount, accid);
			if (acc != null) {
				request.setAttribute("beforeamt", balance);
				request.setAttribute("obj", acc);
				RequestDispatcher rd = request
						.getRequestDispatcher("afterdeposite.jsp");
				rd.forward(request, response);
			}
		} else if (action.equals("createAcc")) {
			request.setAttribute("message", "");
			RequestDispatcher rq = request
					.getRequestDispatcher("AddAccount.jsp");
			rq.forward(request, response);
		}

		else if (action.equals("delAcc")) {
			String message = "";
			request.setAttribute("message", message);
			RequestDispatcher rq = request
					.getRequestDispatcher("delete_acc.jsp");
			rq.forward(request, response);
		}
		else if (action.equals("withdraw")) {
			System.out.println("in withdraw");
			int acc_id = Integer.parseInt(request.getParameter("accid"));
			
			String type=request.getParameter("type");
			System.out.println(acc_id);
			double balance = Double
					.parseDouble(request.getParameter("balance"));
			System.out.println(balance);
			request.setAttribute("type", type);
			request.setAttribute("accid", acc_id);
			request.setAttribute("bal", balance);
			RequestDispatcher rd = request
					.getRequestDispatcher("withdraw1.jsp");
			rd.forward(request, response);

		}

		else if (action.equals("withdrawhere")) {
			System.out.println("in withdraw here...");
			double balance = Double
					.parseDouble(request.getParameter("balance"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			int accid = Integer.parseInt(request.getParameter("accid"));
			System.out.println(accid);
			Account acc = s.withdraw(amount, accid);
			System.out.println("value catched....");
			System.out.println(acc.getBalance());
			System.out.println(balance);
			
				request.setAttribute("beforeamt", balance);
				request.setAttribute("obj", acc);
				RequestDispatcher rd = request
						.getRequestDispatcher("afterwithdraw2.jsp");
				rd.forward(request, response);
			
		}

		else if (action.equals("transaction")) {
			System.out.println("in transfer");
			int acc_id = Integer.parseInt(request.getParameter("accid"));
			double balance = Double
					.parseDouble(request.getParameter("balance"));
			String type=request.getParameter("type");
			
			request.setAttribute("type", type);
			request.setAttribute("accid", acc_id);
			request.setAttribute("bal", balance);
			String msg = "";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("gettransferdata.jsp").forward(
					request, response);
		}

		else if (action.equals("nowtransfer")) {
			int sourceaccid = Integer.parseInt(request.getParameter("accid"));
			System.out.println(sourceaccid);
            String type=request.getParameter("type");
			double sourceprevbal = Double.parseDouble(request.getParameter("balance"));
			System.out.println(sourceprevbal);

			double amount = Double.parseDouble(request.getParameter("amount"));
			System.out.println(amount);
			int targetaccid = Integer.parseInt(request
					.getParameter("targetaccno"));
			System.out.println(targetaccid);
			System.out.println("tagget id got");
			
			try {
				int i = s.viewAccid(targetaccid);
				System.out.println(i);
				if (i == 0) {
					String msg = "*Account id is not present please enter valid account id";
					request.setAttribute("message", msg);
					request.setAttribute("type", type);
					request.setAttribute("accid", sourceaccid);
					request.setAttribute("bal", sourceprevbal);
					RequestDispatcher rd = request
							.getRequestDispatcher("gettransferdata.jsp");
					rd.forward(request, response);
				
				}
				else {
					
						double targetprevbal = s.gettagetprevbal(targetaccid);
						
						Account sourceacc = s.transfersourcewithdraw(amount,sourceaccid, targetaccid);
						Account targetacc = s.transfertargetdeposit(amount,targetaccid, sourceaccid);

						request.setAttribute("sourceacc", sourceacc);
						request.setAttribute("targetacc", targetacc);
						request.setAttribute("targetprevbal", targetprevbal);
						request.setAttribute("sourceprevbal", sourceprevbal);
						request.getRequestDispatcher("transfersuccess.jsp").forward(request, response);
					}
				}
			 catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}

		else if (action.equals("index")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if (action.equals("home")) {

			RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
			rd.forward(request, response);
		}  else if (action.equals("CustStatus")) {
			try {
				ArrayList<CustomerStatus> ac = s.viewCustomerStatus();
				request.setAttribute("cust", ac);
				HttpSession ses1 = request.getSession(false);
				ses1.setAttribute("cust", ac);
				if (ac != null) {
					String spageid=request.getParameter("page");  
			        int pageid=Integer.parseInt(spageid);  
			        request.setAttribute("page", pageid);
					RequestDispatcher rd = request
							.getRequestDispatcher("CustStatus.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rq = request
							.getRequestDispatcher("Error.jsp");
					rq.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}else if (action.equals("Refresh")) {
			HttpSession ses1 = request.getSession(false);
			ArrayList<CustomerStatus> ar = (ArrayList<CustomerStatus>) ses1
					.getAttribute("cust");

			int id1 = Integer.parseInt(request.getParameter("idd"));
			int i = 0;
			System.out.println(id1);
			for (CustomerStatus a1 : ar) {
				if (a1.getSsn() == id1) {

					break;
				} else
					i++;
			}
			CustomerStatus asta;
			try {
				asta = s.getCust(id1);
				ar.set(i, asta);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("CustStatus.jsp").forward(request,
					response);

		} else if (action.equals("Accstatus")) {
			ArrayList<AccountStatus> accountstatusList;
			try {
				accountstatusList = s.viewAllAccounts();
				request.setAttribute("accountstatusList", accountstatusList);
				HttpSession ses1 = request.getSession(false);
				ses1.setAttribute("accountstatusList", accountstatusList);
				if (accountstatusList != null || accountstatusList.size() > 0) {
					String spageid=request.getParameter("page");  
			        int pageid=Integer.parseInt(spageid);  
			        request.setAttribute("page", pageid);
					RequestDispatcher rd = request
							.getRequestDispatcher("viewAllAccountStatus.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}else if (action.equals("refresh")) {
			HttpSession ses1 = request.getSession(false);
			ArrayList<AccountStatus> ar = (ArrayList<AccountStatus>) ses1
					.getAttribute("accountstatusList");
			int id1 = Integer.parseInt(request.getParameter("accid"));
			int i = 0;
			System.out.println(id1);
			for (AccountStatus a : ar) {
				if (a.getAccount_id() == id1) {

					break;
				} else
					i++;
			}
			AccountStatus asta;
			try {
				asta = s.getAcc(id1);
				ar.set(i, asta);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("viewAllAccountStatus.jsp").forward(
					request, response);

		} else if (action.equals("goback") || action.equals("DWT")) {
			String msg = "";
			request.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("Cashier1.jsp");
			rd.forward(request, response);
		} else if (action.equals("statement1")) {
			String msg = "";
			request.setAttribute("message", msg);
			RequestDispatcher rd = request
					.getRequestDispatcher("Statementinput.jsp");
			rd.forward(request, response);


		} else if (action.equals("statement")) {
			int i = Integer.parseInt(request.getParameter("accid"));
		
			try {
				int r = s.viewAccid(i);
				System.out.println(r);
			
			if(r==0){
				request.setAttribute("message", "*Account id is not exist please enter valid Account ID");
				RequestDispatcher rd = request
						.getRequestDispatcher("Statementinput.jsp");
				rd.forward(request, response);
			}
			else{
			int r1 = Integer.parseInt(request.getParameter("rows"));
			ArrayList<Transaction> t = s.accountStatement(i, r1);
			request.setAttribute("state", t);
			if (t != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("statement.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}}} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		} else if (action.equals("index1")) {
			RequestDispatcher rd = request
					.getRequestDispatcher("cashierOperation.jsp");
			rd.forward(request, response);
		} else if (action.equals("fetchAccountList")) {
			int aNo = Integer.parseInt(request.getParameter("aNo"));
			Account acc = s.searchacc1(aNo);
			RequestDispatcher rd = request
					.getRequestDispatcher("view_info.jsp");
			request.setAttribute("obj", acc);
			System.out.println(acc.getAccount_id());
			rd.forward(request, response);
		}

		else if (action.equals("accDetail")) {
			request.setAttribute("message", "");
				RequestDispatcher rd = request
						.getRequestDispatcher("viewaccount1.jsp");
				rd.forward(request, response);
				
				
			}
			

			else if (action.equals("viewaccountdetails")) {
				int id= Integer.parseInt(request.getParameter("id"));
			int i=0;
				try {
					i = s.viewAccid(id);
					if(i==1)
					{		
					Account acc=s.getAccount(id);
					request.setAttribute("obj", acc);
					RequestDispatcher rd = request.getRequestDispatcher("viewAccountDetails.jsp");
					rd.forward(request, response);
					}
					else 
					{
						request.setAttribute("message", "*Account id is not present please enter valid Account id");
						RequestDispatcher rd = request
								.getRequestDispatcher("viewaccount1.jsp");
						rd.forward(request, response);
						
					}
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else if (action.equals("statement11")) {
				String s1=request.getParameter("startdate");
			String s2=request.getParameter("enddate");
			System.out.println("INIT"+s2);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(s2));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c.add(Calendar.DATE, 1);  // number of days to add
			s2 = sdf.format(c.getTime());  // dt is now the new date
		
				//
				System.out.println(s1);
				
				int id=Integer.parseInt(request.getParameter("accid"));
				int r=-1;
				
					try {
						r = s.viewAccid(id);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				if(r==0){
					request.setAttribute("message", "*Account id is not exist please enter valid Account ID");
					RequestDispatcher rd = request
							.getRequestDispatcher("Statementinput.jsp");
					rd.forward(request, response);
				}
				
					System.out.println("hi"+s1);
					System.out.println("bye"+s2);
				ArrayList<Transaction> tlist=s.getbydate(s1, s2, id);
			request.setAttribute("state", tlist);
			if(tlist!=null){
			RequestDispatcher rd = request
			.getRequestDispatcher("statement.jsp");
			rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request
						.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			} 
						
}
	}}

