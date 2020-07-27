package com.cg.bookStore.exceptions;

/****************************************************************************************
 *          @author          Ganesh
 *          Description      It is a customized Exception class of LoanRequestException.
 *          @version         1.0
 *          Created Date     10-APR-2020
*****************************************************************************************/

public class InvalidCategoryIdException extends Exception {

	public InvalidCategoryIdException() {
		super();
	}

	public InvalidCategoryIdException(String message) {
		super(message);
	}

}
