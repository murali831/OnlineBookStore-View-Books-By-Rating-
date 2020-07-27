package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.dto.CustomerReviewForm;
import com.cg.bookStore.entity.CustomerReview;
import com.cg.bookStore.exceptions.CustomerReviewException;


/********************************************************************************************
 *          @author          Sai Neel
 *          Description      It is a service interface that contains method declarations
 *                                      which are implemented in CustomerReviewServiceImpl.java
 *          @version         1.0
 *          Created Date     17-07-2020
 ********************************************************************************************/

public interface CustomerReviewService {
	
	
	
	public List<CustomerReview> viewReviewsByBookId(int bookId) throws CustomerReviewException;
	
	public List<CustomerReview> viewReviewsByCustomerId(int customerId) throws CustomerReviewException;

	public CustomerReview viewReviewByCustIdAndBookId(int customerId, int bookId) throws CustomerReviewException;
	
	public CustomerReview viewReviewByReviewId(int reviewId) throws CustomerReviewException;
	

	public String removeReviewByCustIdAndBookId(int customerId, int bookId) throws CustomerReviewException;

	public String removeReviewByReviewId(int reviewId) throws CustomerReviewException;


	String addReview(CustomerReviewForm reviewForm) throws CustomerReviewException;

}
