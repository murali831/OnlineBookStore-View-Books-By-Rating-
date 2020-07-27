package com.cg.bookStore.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.BookInformationException;
import com.cg.bookStore.service.BookInformationService;

/************************************************************************************
 *          @author          Sohaib Khan
 *          Description      It is a controller class that provides request methods
 *          Version          1.0
 *          Created Date     16-JULY-2020
 ************************************************************************************/

@RestController
public class BookInformationController {

	@Autowired
	private BookInformationService bookInformationService;
	@CrossOrigin
	@GetMapping("/getBookById/{bookId}")
	public ResponseEntity<Object> getBookInformationById(@PathVariable("bookId") int bookId)
			throws BookInformationException {
		BookInformation book = bookInformationService.findById(bookId);
		if (book != null) {
			return new ResponseEntity<Object>(book, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}
}

