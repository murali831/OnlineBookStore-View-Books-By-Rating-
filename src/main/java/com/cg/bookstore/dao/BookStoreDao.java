package com.cg.bookstore.dao;

import java.util.List;

import com.cg.bookstore.entity.BookInformation;

public interface BookStoreDao {
	List<BookInformation> viewFavoredBooksdao();

	List<BookInformation> viewAllBooksdao();

	BookInformation viewBookById(int bookId);

	List<BookInformation> viewBooksByCategory(int categoryId);
}
