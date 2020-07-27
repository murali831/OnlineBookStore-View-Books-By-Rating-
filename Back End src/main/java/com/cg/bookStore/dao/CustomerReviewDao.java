package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CustomerReview;

/********************************************************************************************
 *          @author          Sai Neel
 *          Description      It is a dao interface that contains method declarations
 *                                      which are implemented in CustomerReviewDaoImpl.java
 *          @version         1.0
 *          Created Date     17-07-2020
 ********************************************************************************************/


public interface CustomerReviewDao {
	
	public boolean addReview(CustomerReview review);
	

	public List<CustomerReview> viewReviewsByCustomerId(int customerId);

	public List<CustomerReview> viewReviewByCustIdAndBookId(int customerId, int bookId);

	public CustomerReview viewReviewByReviewId(int reviewId);

	public List<CustomerReview> viewReviewsByBookId(int bookId);
	
	
	public boolean removeReview(CustomerReview review);


	public BookInformation viewBookByBookId(int bookId);

}
