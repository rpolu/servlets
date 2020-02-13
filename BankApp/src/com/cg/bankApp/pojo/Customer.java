package com.cg.bankApp.pojo;

public class Customer {

	private String customerName;
	private String emailId;
	private String dob;
	private String phoneNo;

	public Customer(String customerName, String emailId, String dob, String phoneNo) {
		super();
		this.customerName = customerName;
		this.emailId = emailId;
		this.dob = dob;
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", emailId=" + emailId + ", dob=" + dob + ", phoneNo="
				+ phoneNo + "]";
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getDob() {
		return dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

}
