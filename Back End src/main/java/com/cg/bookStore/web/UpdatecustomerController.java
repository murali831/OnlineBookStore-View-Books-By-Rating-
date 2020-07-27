package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exceptions.UpdatecustomerinformationException;
import com.cg.bookStore.service.IUpdatecustomerservice;

@Component
@RestController
@RequestMapping("/updateprofile")

public class UpdatecustomerController {
	@Autowired
	IUpdatecustomerservice service;
	@CrossOrigin
	@RequestMapping("/{customerid}")
	public CustomerInformation getbankdetails(@PathVariable int customerid) throws UpdatecustomerinformationException {
		return service.getcustomerdetailbycustomerId(customerid);
		
	}
	@CrossOrigin
	@PutMapping("/update/{customerid}/")
	public String updatecustomerinformation(@RequestBody CustomerInformation customer,@PathVariable Integer customerid) throws UpdatecustomerinformationException
	{
		service.updatecustomerinformation(customer,customerid);
		return "Updated";
	}
	
}
