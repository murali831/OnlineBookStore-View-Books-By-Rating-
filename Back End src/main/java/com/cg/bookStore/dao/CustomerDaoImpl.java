package com.cg.bookStore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entity.CustomerInformation;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public CustomerInformation viewCustomer(Integer customerId) {

		return em.find(CustomerInformation.class, customerId);
	}

	@Override
	public CustomerInformation viewCustomerByEmail(String email) {
		
		String jpql = "from CustomerInformation c where c.emailAddress=:email";
		TypedQuery<CustomerInformation> query = em.createQuery(jpql, CustomerInformation.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
