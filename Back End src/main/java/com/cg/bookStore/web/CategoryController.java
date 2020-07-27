package com.cg.bookStore.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;
import com.cg.bookStore.service.ListBookInCategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private ListBookInCategoryService service;
	
	
	@CrossOrigin
	@GetMapping("/viewcategory/{category_id}") //it is fetching the data from the url using path variable "category_id"
	public List<BookInformation> viewCategory(@PathVariable("category_id") int category_id, HttpServletRequest request)
	                           throws InvalidCategoryIdException {
		List<BookInformation> list = service.viewBooksForCategoryId(category_id);
		return list;
	}
	
	/*
	 * this receives the jason request through url, and returns the list of books 
	 * in that category for a given category_id 
	 * if the list is empty it throws exception
	 */
		
}