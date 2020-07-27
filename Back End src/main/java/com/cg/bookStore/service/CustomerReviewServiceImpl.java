package com.cg.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.CustomerReviewDao;
import com.cg.bookStore.dto.CustomerReviewForm;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CustomerReview;
import com.cg.bookStore.exceptions.CustomerReviewException;
import com.cg.bookStore.util.BookStoreConstants;


/************************************************************************************
 *          @author           Sai Neel
 *          Description       It is a service class that provides the services for
 *                                     Customer Review.
 *          @version          1.0
 *          Created Date      17-07-2020
************************************************************************************/

@Service("customerreviewservice")
@Transactional
public class CustomerReviewServiceImpl implements CustomerReviewService{

	@Autowired
	private CustomerReviewDao customerReviewDao;
	
	/*******************************************************************************************************************
	 ******								 Add Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	/***********************************************************************************************
	 * Method              				:addReview
     * Description         				:To add the Customer Review
	 * @param review       				:review(CustomerReview)
	 * @throws CustomerReviewException  :CUSTOMER_REVIEW_REMOVING_FAILED
	 * @returns String     				:Review successfully added  
     * Created By          				:Sai Neel
     * Created Date        				:17-07-2020                          
    ************************************************************************************************/
	
	@Override
	public String addReview(CustomerReviewForm reviewForm) throws CustomerReviewException{
		
		
		CustomerReview review=new CustomerReview();
		review.setCustomerId(reviewForm.getCustomerId());
		review.setBookRating(reviewForm.getBookRating());
		review.setReviewComment(reviewForm.getReviewComment());
		review.setReviewHeadline(reviewForm.getReviewHeadline());
		BookInformation getBook=customerReviewDao.viewBookByBookId(reviewForm.getBookId());
		review.setBook(getBook);
		
		int customerId=review.getCustomerId();
		int bookId=review.getBook().getBookId();
		List<CustomerReview> viewReview=customerReviewDao.viewReviewByCustIdAndBookId(customerId, bookId);
		if(viewReview.isEmpty()) {
			if(customerReviewDao.addReview(review))
				return BookStoreConstants.CUSTOMER_REVIEW_ADDED_SUCCESSFULLY;
			throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_ADDING_FAILED);
		}
		throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_ALREADY_EXIST);
		
	}
	
	
	/*******************************************************************************************************************
	 ******								 View Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	/***********************************************************************************************
	 * Method              				:viewReviewsByBookId
     * Description         				:To view the Customer Reviews
	 * @param bookId       				:bookId(int)
	 * @throws CustomerReviewException  :CUSTOMER_REVIEW_NOT_FOUND
	 * @returns review     				:List of Customer Review  
     * Created By          				:Sai Neel
     * Created Date        				:17-07-2020                          
    ************************************************************************************************/
	
	@Override
	public List<CustomerReview> viewReviewsByBookId(int bookId) throws CustomerReviewException{
		List<CustomerReview> reviewList=customerReviewDao.viewReviewsByBookId(bookId);
		if(reviewList.isEmpty())
			throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_NOT_FOUND);
		return reviewList;
	}
	
	
	
	/***********************************************************************************************
	 * Method              				:viewReviewsByCustomerId
     * Description         				:To view the Customer Reviews made by customer
	 * @param customerId   				:customerId(int)
	 * @throws CustomerReviewException  :CUSTOMER_REVIEW_NOT_FOUND
	 * @returns reviewList 				:List of CustomerReview  
     * Created By          				:Sai Neel
     * Created Date        				:17-07-2020                          
    ************************************************************************************************/
	
	@Override
	public List<CustomerReview> viewReviewsByCustomerId(int customerId)  throws CustomerReviewException{
		List<CustomerReview> reviewList=customerReviewDao.viewReviewsByCustomerId(customerId);
		if(reviewList.isEmpty())
			throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_NOT_FOUND);
		return reviewList;
	}
	
	
	/***********************************************************************************************
	 * Method              				:viewReviewsByCustIdAndBookId
     * Description         				:To get the reviews using customer Id and Book Id
	 * @param customerId				:customerId(int)
	 * @param bookId    				:bookId(int)
	 * @throws CustomerReviewException  :CUSTOMER_REVIEW_NOT_FOUND
	 * @returns review			    	:instance of CustomerReview  
     * Created By          				:Sai Neel
     * Created Date        				:17-07-2020                          
    ************************************************************************************************/
	@Override
	public CustomerReview viewReviewByCustIdAndBookId(int customerId,int bookId)  throws CustomerReviewException{
		List<CustomerReview> review=customerReviewDao.viewReviewByCustIdAndBookId(customerId, bookId);
		if(review.isEmpty())	
			throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_NOT_FOUND);
		return review.get(0);
	}
	
	
	
	/***********************************************************************************************
	 * Method              				:viewReviewByReviewId
     * Description         				:To get the reviews using customer Id and Book Id
	 * @param reviewId			    	:reviewId(int)
	 * @throws CustomerReviewException  :CUSTOMER_REVIEW_NOT_FOUND
	 * @returns review			    	:instance of CustomerReview  
     * Created By          				:Sai Neel
     * Created Date        				:17-07-2020                          
    ************************************************************************************************/
	
	@Override
	public CustomerReview viewReviewByReviewId(int reviewId) throws CustomerReviewException {
		CustomerReview review=customerReviewDao.viewReviewByReviewId(reviewId);
		if(review.getReviewId()==reviewId)
			return review;
		throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_NOT_FOUND);
	}
	
	
	/*******************************************************************************************************************
	 ******								 Delete Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	/***********************************************************************************************
	 * Method              				:removeReviewByCustomerIdAndBookId
     * Description         				:To remove the review using customer Id and Book Id
	 * @param customerId				:customerID(int)
	 * @param bookId					:bookId(int)
	 * @throws CustomerReviewException  :CUSTOMER_REVIEW_REMOVING_FAILED
	 * @returns string			    	:review deleted successfully  
     * Created By          				:Sai Neel
     * Created Date        				:17-07-2020                          
    ************************************************************************************************/
	@Override
	public String removeReviewByCustIdAndBookId(int customerId,int bookId) throws CustomerReviewException {
		List<CustomerReview> review=customerReviewDao.viewReviewByCustIdAndBookId(customerId, bookId);
		if(!review.isEmpty())
			if(customerReviewDao.removeReview(review.get(0)))
				return BookStoreConstants.CUSTOMER_REVIEW_REMOVED_SUCCESSFULLY;
		throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_REMOVING_FAILED);
	}
	
	/***********************************************************************************************
	 * Method              				:removeReviewByCustomerIdAndBookId
     * Description         				:To remove the review using customer Id and Book Id
	 * @param reviewId					:reviewID(int)
	 * @throws 	CustomerReviewException :CUSTOMER_REVIEW_REMOVING_FAILED
	 * @returns string			    	:review deleted successfully  
     * Created By          				:Sai Neel
     * Created Date        				:17-07-2020                          
    ************************************************************************************************/
	
	@Override
	public String removeReviewByReviewId(int reviewId) throws CustomerReviewException {
		CustomerReview review=customerReviewDao.viewReviewByReviewId(reviewId);
		if(review==null)
			throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_NOT_FOUND);
		if(customerReviewDao.removeReview(review))
			return BookStoreConstants.CUSTOMER_REVIEW_REMOVED_SUCCESSFULLY;
		throw new CustomerReviewException(BookStoreConstants.CUSTOMER_REVIEW_REMOVING_FAILED);
	}


	
}
