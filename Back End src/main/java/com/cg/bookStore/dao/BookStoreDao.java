package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.exceptions.InvalidCategoryIdException;

public interface BookStoreDao {
	
	
	public List<BookInformation> viewBooksInCategory(int categoryId) 
			throws InvalidCategoryIdException;

	public List<BookInformation> viewfavoriteBooksByRating();

	public List<BookInformation> viewAllBooksdao();

	public BookInformation viewBookById(int bookId);

	public List<BookInformation> viewBooksByCategory(int categoryId);
	
	public List<BookCategory> viewallCategories();
	
	public List<BookInformation> getAllRecentlyPublishedBooks() throws BookException;
	
	public List<CartInformation>  getBestSellingBooks();
	

}
