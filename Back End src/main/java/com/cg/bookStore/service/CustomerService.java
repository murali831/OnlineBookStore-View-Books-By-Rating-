package com.cg.bookStore.service;

import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exceptions.CustomerEmailIdnotFound;
import com.cg.bookStore.exceptions.CustomerException;
import com.cg.bookStore.exceptions.CustomerIdNotFoundException;

public interface CustomerService {
	
	public CustomerInformation viewCustomer(String customerId) throws CustomerException, CustomerIdNotFoundException;
	
	public CustomerInformation viewByEmailId(String email) throws CustomerException, CustomerEmailIdnotFound;

}
