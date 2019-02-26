package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.entity.Customer;

public interface CustomerDAO {
	
	// getting customers
	
	public List<Customer> getCustomers();

	// saving the customer
	public void saveCustomer(Customer theCustomer);

	// getting single customer
	public Customer getCustomer(int theId);
	
	// deleting the customer
	public void deleteCustomer(int theId);

	// search customer
	public List<Customer> searchCustomers(String theSearchName);

}
