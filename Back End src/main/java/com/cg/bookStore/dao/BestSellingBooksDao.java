package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entity.BookInformation;



public interface BestSellingBooksDao {
	public List<BookInformation> getBestSellingBooks();

}
