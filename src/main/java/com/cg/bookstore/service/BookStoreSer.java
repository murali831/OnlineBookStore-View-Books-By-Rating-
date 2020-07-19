package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entity.BookInformation;
import com.cg.bookstore.exceptions.BookException;

public interface BookStoreSer {
	List<BookInformation> viewFavoredBookser() throws BookException;

	List<BookInformation> viewAllBooksdao();

	BookInformation viewBookById(int bookId);

	List<BookInformation> viewBooksByCategory(int categoryId);
}
