package com.cg.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.ICustomerDAO;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exceptions.UpdatecustomerinformationException;

@Service
public class Updatecustomerserive implements IUpdatecustomerservice{
	@Autowired
	ICustomerDAO customerdao;

	@Override
	public CustomerInformation getcustomerdetailbycustomerId(Integer customerid) throws UpdatecustomerinformationException {
		int customer_id=customerid;
		CustomerInformation customer = customerdao.findById(customer_id).orElseThrow(()-> new UpdatecustomerinformationException("No Customer"));
		return customer;
	}

	@Override
	public void updatecustomerinformation(CustomerInformation customer,Integer id) throws UpdatecustomerinformationException {
		if(checkemailifchanged(customer.getEmailAddress(), id))
			if(checkediteduserinformationifnull(customer));
				if(checkphonenumerlength(customer.getPhoneNumber()) && checkzipcodelength(customer.getZipCode()))
				{
					customerdao.save(customer);
					
				}
				else
					throw new UpdatecustomerinformationException("Update Fail");
				
				
			
		
	}

	@Override
	public boolean checkediteduserinformationifnull(CustomerInformation customer) throws UpdatecustomerinformationException {
		if(customer.getFullName().isEmpty())
			throw new UpdatecustomerinformationException("Please provide Your Full Name");
		else if(customer.getCountry().isEmpty())
			throw new UpdatecustomerinformationException("Please provide Country");
		else if(customer.getCity().isEmpty())
			throw new UpdatecustomerinformationException("Please provide City");
		else if(customer.getPassword().isEmpty())
			throw new UpdatecustomerinformationException("Please provide password");
		else if(customer.getPhoneNumber().isEmpty())
			throw new UpdatecustomerinformationException("Please provide Phone number");
		else if(customer.getZipCode()==null)
			throw new UpdatecustomerinformationException("Please provide Zipcode");
		else if(customer.getAddress()==null)
			throw new UpdatecustomerinformationException("Please provide Address");
		
			return true;
			
	}

	@Override
	public boolean checkemailifchanged(String changedemail,Integer id) throws UpdatecustomerinformationException {
		int customer_id=id;
		CustomerInformation customer1=customerdao.findById(customer_id).orElseThrow(()->new UpdatecustomerinformationException("Customer Id "+id+" Not Found "));
		if(!(customer1.getEmailAddress().equals(changedemail)))
		{
			throw new UpdatecustomerinformationException("Email Cannot be changed");
		}
		return true; 
	}

	@Override
	public boolean checkphonenumerlength(String phonenumber) throws UpdatecustomerinformationException {
		if(phonenumber.length()!=10)
			throw new UpdatecustomerinformationException("Phone Number must have 10 digit");
		return true;
	}

	@Override
	public boolean checkzipcodelength(int zipcode) throws UpdatecustomerinformationException {
		if(zipcode>100000 && zipcode<999999)
		return true;
		else
			throw new UpdatecustomerinformationException("Zipcode must have 6 digit");
	}


}
