package com.cg.bookStore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookStore.entity.CustomerInformation;

@Repository
public interface ICustomerDAO extends CrudRepository<CustomerInformation, Integer>{

}
