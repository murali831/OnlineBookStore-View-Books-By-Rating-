package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;

public interface ListBookInCategoryService {
	
	public List<BookInformation> viewBooksForCategoryId(int categoryId) 
			throws InvalidCategoryIdException;
	public List<BookCategory> viewBooksCategorys();
}
