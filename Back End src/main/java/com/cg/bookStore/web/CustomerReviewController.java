package com.cg.bookStore.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.CustomerReviewForm;
import com.cg.bookStore.entity.CustomerReview;
import com.cg.bookStore.exceptions.CustomerReviewException;
import com.cg.bookStore.service.CustomerReviewService;

/**************************************************************************************
 *          @author           Sai Neel
 *          Description       It is a Rest Controller class that provides the suitable
 *                                       Customer Review methods for the given 
 *                                       matching URL and returns response in different
 *                                       types of data objects.
 *          @version          1.0
 *          Created Date      17-07-2020
***************************************************************************************/

@RestController
public class CustomerReviewController {
	
	
	@Autowired
	public CustomerReviewService customerReviewService;
	
	
	
	/*******************************************************************************************************************
	 ******								 Add Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	/******************************************************************************************************
	 * Method                 :addReview
     * Description            :To provide the service of adding review for the "/addreview" URL.
	 * @param review          :review(CustomerReview)
	 * @param request         :HttpServletRequest instance
	 * @throws CustomerReviewException 
	 * @returns String        :Review Added Successfully
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    *****************************************************************************************************/
	
	@CrossOrigin
	@PostMapping("/addreview")
	public String addReview(@RequestBody CustomerReviewForm reviewForm, HttpServletRequest request ) throws CustomerReviewException {
		String message=customerReviewService.addReview(reviewForm);
		System.out.println(message);
		return message;
	}
	
	
	/*******************************************************************************************************************
	 ******								 View Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	/******************************************************************************************************
	 * Method                 :viewReviewsByBookId
     * Description            :To provide the service of getting Customer Review for the "/viewcustomerreviewsbybookid/{bookid}" URL.
	 * @param bookId          :bookId(int)
	 * @param request         :HttpServletRequest instance
	 * @throws CustomerReviewException 
	 * @returns reviews       :List of Customer Review instance
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    *****************************************************************************************************/
	
	@CrossOrigin
	@GetMapping("/viewreviewsbybookid/{bookid}")
	public List<CustomerReview> viewReviewsByBookId(@PathVariable("bookid") int bookId,
			HttpServletRequest request) throws CustomerReviewException {
			return customerReviewService.viewReviewsByBookId(bookId);
	}
	
	
	
	/******************************************************************************************************
	 * Method                 :viewReviewsByCustomerId
     * Description            :To provide the service of getting Customer Review for the "/viewreviewbycustomerid/{custid}" URL.
	 * @param customerId      :custId(int)
	 * @param request         :HttpServletRequest instance
	 * @throws CustomerReviewException 
	 * @returns reviews       :List of Customer Review instance
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    *****************************************************************************************************/
	
	@CrossOrigin
	@GetMapping("/viewreviewbycustomerid/{custid}")
	public List<CustomerReview> viewReviewsByCustomerId(@PathVariable("custid") int customerId,
			HttpServletRequest request) throws CustomerReviewException {
		return customerReviewService.viewReviewsByCustomerId(customerId);
	}
	
	
	
	/******************************************************************************************************
	 * Method                 :viewReviewsByCustIdAndBookId
     * Description            :To provide the service of getting Customer Review for the "/viewreviewbycustidandbookid/{custid}/{bookid}" URL.
	 * @param customerId      :custId(int)
	 * @param bookId          :bookId(int)
	 * @param request         :HttpServletRequest instance
	 * @throws CustomerReviewException 
	 * @returns reviews       :Customer Review instance
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    *****************************************************************************************************/
	
	@CrossOrigin
	@GetMapping("/viewreviewbycustidandbookid/{custid}/{bookid}")
	public CustomerReview viewReviewByCustIdAndBookId(@PathVariable("custid") int customerId,@PathVariable("bookid") int bookId, HttpServletRequest request) throws CustomerReviewException {
		return customerReviewService.viewReviewByCustIdAndBookId(customerId, bookId);
	}
	
	
	/******************************************************************************************************
	 * Method                 :viewReviewsByReviewId
     * Description            :To provide the service of getting Customer Review for the "/viewreviewbyreviewid/{reviewid}" URL.
	 * @param reviewId        :reviewId(int)
	 * @param request         :HttpServletRequest instance
	 * @throws CustomerReviewException 
	 * @returns reviews       :Customer Review instance
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    *****************************************************************************************************/
	
	@CrossOrigin
	@GetMapping("/viewreviewbyreviewid/{reviewid}")
	public CustomerReview viewReviewByReviewId(@PathVariable("reviewid") int reviewId, HttpServletRequest request) throws CustomerReviewException {
		return customerReviewService.viewReviewByReviewId(reviewId);
	}
	
	
	
	
	/*******************************************************************************************************************
	 ******								 Delete Customer Review Methods												****                         
    ********************************************************************************************************************/
	
	
	
	/******************************************************************************************************
	 * Method                 :removeReviewsByCustIdAndBookId
     * Description            :To provide the service of removing Customer Review for the "/removereviewbycustomeridandbookid/{custid}/{bookid}" URL.
	 * @param customerId      :custId(int)
	 * @param bookId          :bookId(int)
	 * @param request         :HttpServletRequest instance
	 * @throws CustomerReviewException 
	 * @returns boolean       :true, review deleted successfully
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    *****************************************************************************************************/
	
	@CrossOrigin
	@DeleteMapping("/removereviewbycustomeridandbookid/{custid}/{bookid}")
	public String removeReviewByCustIdAndBookId(@PathVariable("custid") int customerId,@PathVariable("bookid") int bookId, HttpServletRequest request) throws CustomerReviewException {
		return customerReviewService.removeReviewByCustIdAndBookId(customerId, bookId);
	}
	
	
	
	/******************************************************************************************************
	 * Method                 :removeReviewsByCustIdAndBookId
     * Description            :To provide the service of removing Customer Review for the "/removereviewbyreviewid/{reviewid}" URL.
	 * @param customerId      :custId(int)
	 * @param bookId          :bookId(int)
	 * @param request         :HttpServletRequest instance
	 * @throws CustomerReviewException 
	 * @returns boolean       :true, review deleted successfully
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    *****************************************************************************************************/
	
	@CrossOrigin
	@DeleteMapping("/removereviewbyreviewid/{reviewid}")
	public String removeReviewByReviewId(@PathVariable("reviewid") int reviewId, HttpServletRequest request) throws CustomerReviewException {
		return customerReviewService.removeReviewByReviewId(reviewId);
	}
}
