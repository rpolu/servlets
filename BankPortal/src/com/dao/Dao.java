package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.AccountStatus;
import com.bean.Customer;
import com.bean.CustomerStatus;
import com.bean.Transaction;
import com.bean.UserStore_h;
import com.util.DatabaseUtil;

public class Dao {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	Statement s = null;
	PreparedStatement p1 = null;

	public int addCustomer(Customer c) throws SQLException,
			ClassNotFoundException {
		int i=0;
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("insert into Customer_h1 values(?,seq_id.nextval,?,?,?,?,?,?)");
		ps.setInt(1,c.getSsn());
		ps.setString(2, c.getCustomerName());
		ps.setInt(3, c.getAge());
		ps.setString(4, c.getAddressLine1());
		ps.setString(5, c.getAddressLine2());
		ps.setString(6, c.getCity());
		ps.setString(7, c.getState());
		int r = ps.executeUpdate();
		if (r > 0) {
			ps = con.prepareStatement("select max(customerID) from Customer_h1");
			rs = ps.executeQuery();
			while (rs.next()) {
				i=rs.getInt(1);
				c.setCustId(rs.getInt(1));
			}
			ps = con.prepareStatement("insert into CustomerStatus_h values(?,?,?,?,current_timestamp)");
			ps.setInt(1, c.getSsn());
			ps.setInt(2, c.getCustId());
			ps.setString(3, "Active");
			ps.setString(4, "Created");
			ps.executeUpdate();
		} 
		return i;
	}

	public Customer search(int r) throws SQLException, ClassNotFoundException {
		Customer c = new Customer();
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("select * from Customer_h1 where customerID=? or ssnid=?");
		ps.setInt(1, r);
		ps.setInt(2, r);
		rs = ps.executeQuery();
		while (rs.next()) {
			c.setCustId(rs.getInt("customerID"));
			c.setSsn(rs.getInt("ssnID"));
			c.setCustomerName(rs.getString("customerName"));
			c.setAge(rs.getInt("age"));
			c.setAddressLine1(rs.getString("addressLine1"));
			c.setAddressLine2(rs.getString("addressLine2"));
			c.setCity(rs.getString("city"));
			c.setState(rs.getString("state"));
		}
		return c;
	}

	public boolean update(Customer c, int p) throws SQLException,
			ClassNotFoundException {
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("update Customer_h1 set customerName=?,age=?,addressLine1=?,addressLine2=?,city=?,state=? where customerID=?");
		ps.setString(1, c.getCustomerName());
		ps.setInt(2, c.getAge());
		ps.setString(3, c.getAddressLine1());
		ps.setString(4, c.getAddressLine2());
		ps.setString(5, c.getCity());
		ps.setString(6, c.getState());
		ps.setInt(7, p);
		int r = ps.executeUpdate();
		if (r > 0) {
			ps = con.prepareStatement("update CustomerStatus_h set message=? where customerID=? and status=?");
			ps.setString(1, "Updated");
			ps.setInt(2, p);
			ps.setString(3, "Active");
			int p1 = ps.executeUpdate();
			if (p1 > 0)
				return true;
		}
		return false;
	}
	public Account updateaccount(int id,double bal)
	{
		Account acc=new Account();
		 con=DatabaseUtil.getConnection();
		 try {
			ps=con.prepareStatement("update Account_h11 set balance=? where account_id=?");
			ps.setInt(1, id);
			ps.setDouble(2, bal);
			ps.executeUpdate();
			acc=getAccount(id);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return acc;
		 
	}

	public boolean delete(int r) throws SQLException, ClassNotFoundException {
		con = DatabaseUtil.getConnection();
		int i=0; boolean b=false; String s="Active";
		ps=con.prepareStatement("select status from AccountStatus_h where customerid=? ");
		ps.setInt(1,r);
		rs=ps.executeQuery();
		while(rs.next()){
			if(s.equalsIgnoreCase(rs.getString("status"))){
				b=true;
				System.out.println(b);
				break;
			}}
		if(b==false){
		ps = con.prepareStatement("update CustomerStatus_h set status=?, message=? where customerID=?");
		ps.setString(1, "Inactive");
		ps.setString(2, "Deleted");
		ps.setInt(3, r);
		i = ps.executeUpdate();
		if (i > 0)
			return true;
		else
			return false;}
		else
			return false;
	}
	public UserStore_h validate(String uname, String pass) throws SQLException {
		con = DatabaseUtil.getConnection();
		UserStore_h uh = null;
		ps = con.prepareStatement("select * from userstore_h where login=? and password=?");
		ps.setString(1, uname);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("User found");
			uh = new UserStore_h(rs.getString(1), rs.getString(2),
					rs.getString(3));
			return uh;
		} else {
			return uh;
		}
	}

	public int addAccount(Account a) {


		int ad = 0;
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("insert into Account_h11 values(?, seq_acc.nextval,?, ?,current_DATE ,current_DATE)");
			ps.setInt(1, a.getCustomerid());
			ps.setString(2, a.getAcc_type());
			ps.setDouble(3, a.getBalance());
			// ps.setString(4,a.getCr());
			// ps.setString(5,a.getCr_last());
			//ps.setInt(4, a.getDuration());
			int r = ps.executeUpdate();
System.out.println("value of r="+r);
			if (r > 0) {
				String sql1 = "select max(account_id)from Account_h11";
				java.sql.Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql1);
				while (rs.next()) {
					ad = rs.getInt(1);
					System.out.println(ad);
				}
				ps = con.prepareStatement("select Customerid from Account_h11 where account_id=?");
				ps.setInt(1, ad);
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println(ad);
					a.setCustomerid(rs.getInt(1));
					ps = con.prepareStatement("insert into AccountStatus_h values(?,?,?,?,?,current_timestamp)");
					ps.setInt(1, a.getCustomerid());
					ps.setInt(2, ad);
					ps.setString(3, a.getAcc_type());
					ps.setString(4, "Active");
					ps.setString(5, "Created");
					ps.executeUpdate();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ad;
	}
	public boolean deleteAccount(int acccid) {
		boolean result = false;
		String q = "delete from Account_h11 where account_id=?";
		String q2 = "update AccountStatus_h set message='Deleted',status='Inactive', lastUpdated = CURRENT_TIMESTAMP where account_id=?";

		con = DatabaseUtil.getConnection();
		try {
			ps = con.prepareStatement(q);
			ps.setInt(1, acccid);
			int i = ps.executeUpdate();
			if (i > 0)
				result = true;
			ps = con.prepareStatement(q2);
			ps.setInt(1, acccid);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Account> searchacc(int id) {
		ArrayList<Account> aList = new ArrayList<Account>();
		String q = "select *  from Account_h11 a inner  join Customer_h1 b on a.customerid = b.customerid where  b.customerid=? or  b.ssnid=? or a.account_id=? ";
		con = DatabaseUtil.getConnection();

		try {
			ps = con.prepareStatement(q);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.setInt(3, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account a = new Account();
				a.setCustomerid(rs.getInt(1));
				a.setAccount_id(rs.getInt(2));
				a.setAcc_type(rs.getString(3));
				a.setBalance(rs.getDouble(4));
				a.setCr(rs.getString(5));
				a.setCr_last(rs.getString(6));
				aList.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Account a1 : aList) {
			System.out.println(a1.getAccount_id());
		}
		return aList;
	}

	public Account deposite(Double amount, int account_id) {
		con = DatabaseUtil.getConnection();
		Account acc = new Account();
		String q = "update Account_h11 set  balance=balance+?,cr_last=CURRENT_DATE where account_id=?";
		try {
			ps = con.prepareStatement(q);
			ps.setDouble(1, amount);
			ps.setInt(2, account_id);

			int i = ps.executeUpdate();
			System.out.println(i);

			if (i > 0) {
                acc=getAccount(account_id);
               
				p1 = con.prepareStatement("update AccountStatus_h set message='deposited', lastUpdated = CURRENT_TIMESTAMP where account_id=?");
				System.out.println("in if..........");

				p1.setInt(1, account_id);
				p1.executeUpdate();
				System.out.println(p1.executeUpdate());
				ps = con.prepareStatement("insert into Transactions_h11 values(?,CURRENT_DATE,?,?,?,?)");
				ps.setInt(1, account_id);
				ps.setString(2, "Credit");
				ps.setInt(3, account_id);
				ps.setDouble(4, amount);
				ps.setDouble(5, acc.getBalance());
				ps.executeUpdate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		  finally{
			  //DatabaseUtil.closeStatement(ps);
			  DatabaseUtil.closeConnection(con);
		  }
		return acc;
	}

public Account withdraw(Double amount, int account_id) {
		
		con = DatabaseUtil.getConnection();
		
			Account acc= new Account();
			    String q = "update Account_h11 set balance=balance-?,cr_last=CURRENT_DATE where account_id=?";

			try {
				ps = con.prepareStatement(q);
				ps.setDouble(1, amount);
				ps.setInt(2, account_id);
				int i = ps.executeUpdate();

				if (i > 0)
				{	
					System.out.println("value of ui=" +i);
					acc=getAccount(account_id);

					p1 = con.prepareStatement("update AccountStatus_h set message='withdraw', lastUpdated = CURRENT_TIMESTAMP where account_id=?");
					p1.setInt(1, account_id);
					p1.executeUpdate();
					ps = con.prepareStatement("insert into Transactions_h11 values(?,CURRENT_DATE,?,?,?,?)");
					ps.setInt(1, account_id);
					ps.setString(2, "Debit");
					ps.setInt(3, account_id);
					ps.setDouble(4, amount);
					ps.setDouble(5, acc.getBalance());
					ps.executeUpdate();
					}
				}
			 catch (SQLException e) {

				e.printStackTrace();
			} 
			  finally{
				  DatabaseUtil.closeStatement(ps);
				  DatabaseUtil.closeConnection(con);
			  }
			      
		return acc;
	     
	}
public Account getAccount(int account_id)
{	con = DatabaseUtil.getConnection();
Account acc=new Account();
String q2 = "select * from Account_h11 where account_id=?";
try {
	p1 = con.prepareStatement(q2);
	p1.setInt(1, account_id);
	rs = p1.executeQuery();
	while (rs.next()) {
		acc.setCustomerid(rs.getInt(1));
		acc.setAccount_id(rs.getInt(2));
		acc.setAcc_type(rs.getString(3));
		acc.setBalance(rs.getDouble(4));
		acc.setCr(rs.getString(5));
		acc.setCr_last(rs.getString(6));
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return acc;
}
	public ArrayList<CustomerStatus> viewCustomerStatus() throws SQLException,
			ClassNotFoundException {
		con = DatabaseUtil.getConnection();
		ArrayList<CustomerStatus> ar = new ArrayList<CustomerStatus>();
		String sql = "select * from CustomerStatus_h order by customerid";
		s = con.createStatement();
		rs = s.executeQuery(sql);
		while (rs.next()) {
			CustomerStatus cs = new CustomerStatus();
			cs.setSsn(rs.getInt("ssnid"));
			cs.setCustId(rs.getInt("customerid"));
			cs.setStatus(rs.getString("status"));
			cs.setMessage(rs.getString("message"));
			cs.setLast_Updated(rs.getDate("last_updated"));
			ar.add(cs);
		}
		return ar;
	}

	public CustomerStatus getCust(int r) throws SQLException,
			ClassNotFoundException {
		CustomerStatus cs = new CustomerStatus();
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("select * from CustomerStatus_h where ssnid=? order by customerid");
		ps.setInt(1, r);
		rs = ps.executeQuery();
		while (rs.next()) {
			cs.setSsn(rs.getInt("ssnid"));
			cs.setCustId(rs.getInt("customerid"));
			cs.setStatus(rs.getString("status"));
			cs.setMessage(rs.getString("message"));
			cs.setLast_Updated(rs.getDate("last_updated"));

		}
		return cs;
	}

	public int viewCustId(int r) throws SQLException, ClassNotFoundException {
		con = DatabaseUtil.getConnection();
		int i = 0;
		String sql = "select count(*) from CustomerStatus_h  where customerid=? and status=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, r);
		ps.setString(2,"Active");
		rs = ps.executeQuery();
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}

	public int viewSsnId(int r) throws SQLException, ClassNotFoundException {
		con = DatabaseUtil.getConnection();
		int i = 0;
		String sql = "select count(*) from CustomerStatus_h where ssnid=? and status=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, r);
		ps.setString(2,"Active");
		rs = ps.executeQuery();
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}

	public int viewAccid(int r) throws SQLException, ClassNotFoundException {
		con = DatabaseUtil.getConnection();
		int i = 0;
		String sql = "select count(*) from Account_h11 where account_id=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, r);
		rs = ps.executeQuery();
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}

	public Account transfersourcewithdraw(double amount, int sourceaccid, int r) {
		Account acc = new Account();
		String query = "update Account_h11 set  balance=balance-?,cr_last=CURRENT_DATE where account_id=?";
		con = DatabaseUtil.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setInt(2, sourceaccid);

			int i = ps.executeUpdate();

			if (i > 0) {
				String query1 = "select * from Account_h11 where account_id=?";
				p1 = con.prepareStatement(query1);
				p1.setInt(1, sourceaccid);
				rs = p1.executeQuery();
				while (rs.next()) {
					acc.setCustomerid(rs.getInt(1));
					acc.setAccount_id(rs.getInt(2));
					acc.setAcc_type(rs.getString(3));
					acc.setBalance(rs.getDouble(4));
					acc.setCr(rs.getString(5));
					acc.setCr_last(rs.getString(6));
				}
				ps1 = con.prepareStatement("insert into Transactions_h11 values(?,CURRENT_DATE,?,?,?,?)");
				ps1.setString(2, "TransferDebit");
				ps1.setInt(1, sourceaccid);
				ps1.setInt(3, r);
				ps1.setDouble(4, amount);
				ps1.setDouble(5, acc.getBalance());
				ps1.executeUpdate();
				ps1 = con.prepareStatement("update AccountStatus_h set message='Transfer successfully', lastUpdated = CURRENT_TIMESTAMP where account_id=?");
				ps1.setInt(1, sourceaccid);
				ps1.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeStatement(ps1);
		}
		return acc;
	}

	public Account transfertargetdeposit(double amount, int targetaccid, int sourceaccid) {
		Account acc = new Account();
		String query = "update Account_h11 set  balance=balance+? ,cr_last=CURRENT_DATE where account_id=?";
		con = DatabaseUtil.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setInt(2, targetaccid);

			int i = ps.executeUpdate();

			if (i > 0) {
				String query1 = "select * from Account_h11 where account_id=?";
				p1 = con.prepareStatement(query1);
				p1.setInt(1, targetaccid);
				rs = p1.executeQuery();
				while (rs.next()) {
					acc.setCustomerid(rs.getInt(1));
					acc.setAccount_id(rs.getInt(2));
					acc.setAcc_type(rs.getString(3));
					acc.setBalance(rs.getDouble(4));
					acc.setCr(rs.getString(5));
					acc.setCr_last(rs.getString(6));
				}
				ps = con.prepareStatement("insert into Transactions_h11 values(?,CURRENT_DATE,?,?,?,?)");
				ps.setString(2, "TransferCredit");
				ps.setInt(1, targetaccid);
				ps.setInt(3, sourceaccid);
				ps.setDouble(4, amount);
				ps.setDouble(5, acc.getBalance());
				 ps.executeUpdate();
				p1 = con.prepareStatement("update AccountStatus_h set message='Transfer successfully', lastUpdated = CURRENT_TIMESTAMP where account_id=?");
				p1.setInt(1, targetaccid);
				p1.executeUpdate();

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return acc;
	}

	public double gettagetprevbal(int targetaccid) {
		double gettagetprevbal = 0;
		String query = "select * from Account_h11 where account_id=?";
		con = DatabaseUtil.getConnection();

		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, targetaccid);

			rs = ps.executeQuery();

			while(rs.next())
			{
				gettagetprevbal = rs.getInt(4);
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return gettagetprevbal;
	}

	public ArrayList<AccountStatus> viewAllAccountStatus() throws SQLException,
			ClassNotFoundException {
		ArrayList<AccountStatus> accountstatusList = new ArrayList<AccountStatus>();
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("select * from AccountStatus_h order by account_id");
		rs = ps.executeQuery();
		while (rs.next()) {
			AccountStatus a = new AccountStatus();
			a.setCustomerid(rs.getInt(1));
			a.setAccount_id(rs.getInt(2));
			a.setAcc_type(rs.getString(3));
			a.setStatus(rs.getString(4));
			a.setMessage(rs.getString(5));
			a.setLastupdated(rs.getDate(6));
			accountstatusList.add(a);

		}
		return accountstatusList;
	}

	public AccountStatus getAcc(int r) throws SQLException,
			ClassNotFoundException {
		AccountStatus a = new AccountStatus();
		con = DatabaseUtil.getConnection();
		ps = con.prepareStatement("select * from AccountStatus_h where account_id=? order by account_id");
		ps.setInt(1, r);
		rs = ps.executeQuery();
		while (rs.next()) {
			a.setCustomerid(rs.getInt(1));
			a.setAccount_id(rs.getInt(2));
			a.setAcc_type(rs.getString(3));
			a.setStatus(rs.getString(4));
			a.setMessage(rs.getString(5));
			a.setLastupdated(rs.getDate(6));

		}
		return a;
	}

	public ArrayList<Transaction> accountStatement(int accid, int rows) {
		ArrayList<Transaction> trList = new ArrayList<Transaction>();
		con = DatabaseUtil.getConnection();
		String query = "SELECT * FROM (select * from TRANSACTIONS_H11 where (accountid=?) order by Tran_date desc ) WHERE rownum <=?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, accid);
			ps.setInt(2, rows);
			rs = ps.executeQuery();
			while (rs.next()) {
				Transaction t1 = new Transaction();
				t1.setTranDate(rs.getDate("Tran_date"));
				t1.setDescription(rs.getString("description"));
				t1.setId(rs.getInt("Target_id"));
				t1.setAmount(rs.getDouble("Amount"));
				t1.setBalance(rs.getDouble("Balance"));
				trList.add(t1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeStatement(ps);
			DatabaseUtil.closeConnection(con);
		}
		return trList;
	}

	public Account searchacc1(int id) {
		Account a = new Account();
		String q = "select * from Account_h11 where account_id=? ";
		con = DatabaseUtil.getConnection();

		try {
			ps = con.prepareStatement(q);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				a.setCustomerid(rs.getInt(1));
				a.setAccount_id(rs.getInt(2));
				a.setAcc_type(rs.getString(3));
				a.setBalance(rs.getDouble(4));
				a.setCr(rs.getString(5));
				a.setCr_last(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}
public ArrayList<Transaction> getbydate(String s1,String s2,int id)
	
	{
		ArrayList<Transaction> tlist= new ArrayList<Transaction>();
	con=DatabaseUtil.getConnection();
	String q=" select * from TRANSACTIONS_H11 where tran_date between to_date(?,'YYYY-MM-DD') AND to_date(?,'YYYY-MM-DD') and accountid=? order by Tran_date desc";

try {
	ps=con.prepareStatement(q);
	ps.setString(1, s1); ps.setString(2, s2);ps.setInt(3, id);
	
	rs=ps.executeQuery();
	while(rs.next())
	{
		Transaction t=new Transaction();
		t.setTranDate(rs.getDate(2));
		t.setDescription(rs.getString(3));
		t.setId(rs.getInt(4));
		t.setAmount(rs.getDouble(5));
		t.setBalance(rs.getDouble(6));
		tlist.add(t);
	}
} catch (SQLException e) {
	e.printStackTrace();
}	return tlist;
	}
}
