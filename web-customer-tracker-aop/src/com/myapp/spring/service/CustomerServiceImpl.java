package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.dao.CustomerDAO;
import com.myapp.spring.entity.Customer;

//add @Service for any ServiceImpl that communicates with the DAO

//allows spring to scan as it inherits @component

@Service
public class CustomerServiceImpl implements CustomerService {

	// inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;

	// @Transactional manages hibernate begin and end transactions

	// no need to explicitly start and end transactions

	// add in the Service layer and remove in DAO layer

	// basically no need to add @Transactional in the DAO as we want the transaction
	// to run in the context of service layer

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// delegate the call to DAO simple :-)
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);

	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {

		return customerDAO.searchCustomers(theSearchName);

	}

}
