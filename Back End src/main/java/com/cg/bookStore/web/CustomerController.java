package com.cg.bookStore.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exceptions.CustomerEmailIdnotFound;
import com.cg.bookStore.exceptions.CustomerException;
import com.cg.bookStore.exceptions.CustomerIdNotFoundException;
import com.cg.bookStore.service.CustomerService;
@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	private CustomerService ser;

	@GetMapping("/viewcustomer/{customerId}")
	public CustomerInformation viewCustomer(HttpServletRequest req, @PathVariable("customerId") String customerId)
			throws CustomerException, CustomerIdNotFoundException {

		
		return ser.viewCustomer(customerId);

	}
   
	@GetMapping("/viewByEmail/{email}")
	public CustomerInformation viewCustomerByEmail(HttpServletRequest req, @PathVariable("email") String email)
			throws CustomerException, CustomerEmailIdnotFound {

		return ser.viewByEmailId(email);
		
	}

}

