package com.cg.bookStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;
@Service
public class ListBookInCategoryServiceImpl implements ListBookInCategoryService{

	@Autowired
	public BookStoreDao dao;
	
	@Override
	public List<BookInformation> viewBooksForCategoryId(int categoryId) 
			throws InvalidCategoryIdException {
		List<BookInformation> booksList = dao.viewBooksByCategory(categoryId);
		if(booksList.isEmpty())
			throw new InvalidCategoryIdException("No books are available");
		
		return booksList;
	}

	@Override
	public List<BookCategory> viewBooksCategorys() {
		return dao.viewallCategories();
	}

	/*
	 * this method accepts category id as parameter and returns list of book
	 * which are present in that respective category.
	 * if list is empty it gives no book message.
	 */
}
