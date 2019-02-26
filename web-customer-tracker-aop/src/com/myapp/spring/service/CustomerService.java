package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.entity.Customer;

public interface CustomerService {
	
	// this class talks to CustomerDAO
	
	// allows to integrate data from multiple sources
	
	// method to get customers
	
	public List<Customer> getCustomers();
	
	// method to save customers
	public void saveCustomer(Customer theCustomer);

	// method to get single customer
	public Customer getCustomer(int theId);

	// method to delete customer
	public void deleteCustomer(int theId);
	
	//search customer
	public List<Customer> searchCustomers(String theSearchName);

}
