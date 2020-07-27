package com.cg.bookStore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bookStore.exceptions.CustomerReviewException;
import com.cg.bookStore.util.BookStoreConstants;

/******************************************************************************************
 *          @author           Sai Neel
 *          Description       It is a Rest Controller Advice class that globally Handles 
 *                                       that Exception that raised in the Rest Controller.
 *          @version          1.0
 *          Created Date      16-07-2020
*******************************************************************************************/

@RestControllerAdvice
public class BookStoreExceptionAdvice {

	Logger logger = LoggerFactory.getLogger(BookStoreExceptionAdvice.class);

	/***********************************************************************************************
	 * Method                 :handleException
     * Description            :To handle the CustomerReviewException.
	 * @param ex              :Exception instance
	 * @returns void
     * Created By             :Sai Neel
     * Created Date           :17-07-2020                          
    ************************************************************************************************/
	@ExceptionHandler(value = { CustomerReviewException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = BookStoreConstants.CUSTOMER_REVIEW_EXCEPTION)
	public void handleException(Exception ex) {
		logger.error(ex.getMessage());
	}

	
}
