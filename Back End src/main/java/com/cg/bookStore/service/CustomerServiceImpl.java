package com.cg.bookStore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.CustomerDao;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exceptions.CustomerEmailIdnotFound;
import com.cg.bookStore.exceptions.CustomerException;
import com.cg.bookStore.exceptions.CustomerIdNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	public CustomerInformation viewCustomer(String customerId) throws CustomerException, CustomerIdNotFoundException {

		if (!customerId.matches("^[0-9]{3}$"))
			throw new CustomerException("Id must be a number and only three digit");
		else if (dao.viewCustomer(Integer.parseInt(customerId)) == null)
			throw new CustomerIdNotFoundException("Customer Id not Found");
		else
			return dao.viewCustomer(Integer.parseInt(customerId));

	}

	@Override
	public CustomerInformation viewByEmailId(String email) throws CustomerException, CustomerEmailIdnotFound {

		if (!email.matches("^(.+)@(.+)$"))
			throw new CustomerException("Email ID must be Unique");
		else if (dao.viewCustomerByEmail(email) == null)
			throw new CustomerEmailIdnotFound("Customer Email ID not found");
		else
			return dao.viewCustomerByEmail(email);
	}

}
