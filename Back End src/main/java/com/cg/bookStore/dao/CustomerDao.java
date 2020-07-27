package com.cg.bookStore.dao;

import com.cg.bookStore.entity.CustomerInformation;

public interface CustomerDao {
	
	public CustomerInformation viewCustomer(Integer customerId);
	
	public CustomerInformation viewCustomerByEmail(String email);

}
