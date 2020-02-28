package com.bean;

import java.util.Date;

public class Customer {
	public Customer() {
		super();
	}

	private int ssn, custId;
	private String customerName;
	private int age;
	private String addressLine1;
	private Date Last_Updated;

	public Customer(String customerName, int age, String addressLine1,
			String addressLine2, String city, String state) {
		this.customerName = customerName;
		this.age = age;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
	}

	private String addressLine2;
	private String city;
	private String state;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Date getLast_Updated() {
		return Last_Updated;
	}

	public void setLast_Updated(Date last_Updated) {
		Last_Updated = last_Updated;
	}
}
