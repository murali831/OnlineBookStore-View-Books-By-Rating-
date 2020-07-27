package com.cg.bookStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CustomerReview;


/****************************************************************************************
 *          @author          Sai Neel
 *          Description      It is a DAO implementation class that interacts with
 *                                      Oracle DataBase for customer reviews
 *          @version         1.0
 *          Created Date     17-07-2020
*****************************************************************************************/



@Repository
public class CustomerReviewDaoImpl implements CustomerReviewDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/*******************************************************************************************************************
	 ******								 Add Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	/************************************************************************************
	 * Method              :addReview
     * Description         :To add review in the Oracle Data base
	 * @param review       :CustomerReview
	 * @returns boolean    :true, review added to the data base.
     * Created By          :Sai Neel
     * Created Date        :17-07-2020                           
    **************************************************************************************/

	@Override
	public boolean addReview(CustomerReview review) {
		entityManager.persist(review);
		return true;
	}
	
	
	
	/*******************************************************************************************************************
	 ******								 View Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	/************************************************************************************
	 * Method              :viewReviewsByBookId
     * Description         :To view review using bookId in the Oracle Data base
	 * @param bookId       :bookId(int)
	 * @returns List       :List of Customer Review
     * Created By          :Sai Neel
     * Created Date        :17-07-2020                           
    **************************************************************************************/

	@Override
	public List<CustomerReview> viewReviewsByBookId(int bookId) {
		String jpql = "from CustomerReview customer_review inner join fetch customer_review.book books where books.bookId=:bookid";
		TypedQuery<CustomerReview> query = entityManager.createQuery(jpql, CustomerReview.class);
		query.setParameter("bookid", bookId);
		return query.getResultList();
	}
	
	
	
	
	/************************************************************************************
	 * Method              :viewReviewsByCustomerId
     * Description         :To view review using customerId in the Oracle Data base
	 * @param customerId   :customerId(int)
	 * @returns List       :List of Customer Review
     * Created By          :Sai Neel
     * Created Date        :17-07-2020                           
    **************************************************************************************/
	
	@Override
	public List<CustomerReview> viewReviewsByCustomerId(int customerId) {
		String jpql = "from CustomerReview where customerId=:customerid";
		TypedQuery<CustomerReview> query = entityManager.createQuery(jpql, CustomerReview.class);
		query.setParameter("customerid", customerId);
		return query.getResultList();
	}
	
	

	/************************************************************************************
	 * Method              			:viewReviewsByCustIdAndBookId
     * Description         			:To view review using customerId and bookId in the Oracle Data base
	 * @param customerId     		:customerId(int)
	 * @param bookId				:bookId(int)
	 * @returns CustomerReview      :review of Customer
     * Created By          			:Sai Neel
     * Created Date        			:17-07-2020                           
    **************************************************************************************/
	
	@Override
	public List<CustomerReview> viewReviewByCustIdAndBookId(int customerId,int bookId) {
		String jpql = "from CustomerReview customer_review inner join fetch customer_review.book books where customer_review.customerId=:custid and books.bookId=:bookid";
		TypedQuery<CustomerReview> query = entityManager.createQuery(jpql, CustomerReview.class);
		query.setParameter("custid", customerId);
		query.setParameter("bookid",bookId);
		return query.getResultList();
	}
	
	
	
	/************************************************************************************
	 * Method              :viewReviewByReviewId
     * Description         :To view review using reviewId in the Oracle Data base
	 * @param reviewId     :reviewId(int)
	 * @returns review     :returns the Customer Review
     * Created By          :Sai Neel
     * Created Date        :17-07-2020                           
    **************************************************************************************/
	
	@Override
	public CustomerReview viewReviewByReviewId(int reviewId) {
		return entityManager.find(CustomerReview.class, reviewId);
	}
	
	
	
	/*******************************************************************************************************************
	 ******								 Delete Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	

	/************************************************************************************
	 * Method              :removeReview
     * Description         :To remove review in the Oracle Data base
	 * @param review       :CustomerReview
	 * @returns boolean    :true, Customer Review is removed
     * Created By          :Sai Neel
     * Created Date        :17-07-2020                           
    **************************************************************************************/
	
	@Override
	public boolean removeReview(CustomerReview review) {
		entityManager.remove(review);
		return true;
	}
	
	
	
	/*******************************************************************************************************************
	 ******								 Supporting Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	@Override
	public BookInformation viewBookByBookId(int bookId) {
		return entityManager.find(BookInformation.class, bookId);
	}
}
