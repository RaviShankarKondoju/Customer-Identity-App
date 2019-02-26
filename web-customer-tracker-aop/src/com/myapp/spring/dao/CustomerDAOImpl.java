package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.entity.Customer;

// add @Repository for any DAOImpl that communicates with the data source eg.database

// allows spring to scan as it inherits @component

// translates jdbc related checked exceptions to unchecked

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// @Transactional manages hibernate begin and end transactions

	// no need to explicitly start and end transactions

	// ** UPDATE @Transactional is defined in the service layer

	// removed in DAO layer

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// get a list of customers from the query
		List<Customer> customers = theQuery.getResultList();

		// return the list of customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer ...finally LOL

		// currentSession.save(theCustomer);

		// *** UPDATE save the customer or update if exists

		// based on primary key/id
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key or id
		Customer theCustomer = currentSession.get(Customer.class, theId);

		// returning the customer
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the object with the primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		//execute query
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		//
		// only search by name if theSearchName is not empty
		//
		if(theSearchName !=null && theSearchName.trim().length() > 0) {
			
			// search for first Name or last Name ... case insensitive
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			// % wildcard allows to search for substrings
			// For example, if we have customers with last name of "Patel", "Patterson" ... then we can search for "Pat" and it will match on those names
			theQuery.setParameter("theName", "%" +
					theSearchName.toLowerCase() + "%");
		}
		else {
			//theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		}
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}
}
