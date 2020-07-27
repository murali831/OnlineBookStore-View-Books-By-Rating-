package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.BookException;

public interface BookStoreService {
	List<BookInformation> viewfavoriteBooksByRating() throws BookException;
	
	List<BookInformation> viewtop4favoriteBooksByRating() throws BookException;

	List<BookInformation> viewAllBooksSer() throws BookException;

	BookInformation viewBookById(int bookId);

	List<BookInformation> viewBooksByCategory(int categoryId);
	
	public List<BookCategory> viewBooksCategorys();
	
	public  List<BookInformation> getAllRecentlyPublishedBooks() throws  BookException;
	
	public  List<BookInformation> getAll4RecentlyPublishedBooks() throws  BookException;

	public List<BookInformation> getBestSellingBooks();
	
	
}
