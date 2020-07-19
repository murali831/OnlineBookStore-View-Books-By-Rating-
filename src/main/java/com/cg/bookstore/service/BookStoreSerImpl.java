package com.cg.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookstore.dao.BookStoreDao;
import com.cg.bookstore.entity.BookInformation;
import com.cg.bookstore.exceptions.BookException;
import com.cg.bookstore.util.BookStoreConstants;
@Service
@Transactional
public class BookStoreSerImpl implements BookStoreSer {
	@Autowired
	private BookStoreDao dao;
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	
	@Override
	public List<BookInformation> viewFavoredBookser() throws BookException {
		List<BookInformation> bookslist = dao.viewFavoredBooksdao();
		if(bookslist.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		return bookslist;
	}
	@Override
	public List<BookInformation> viewAllBooksdao() {
		
		return dao.viewAllBooksdao();
	}
	@Override
	public BookInformation viewBookById(int bookId) {
		
		return dao.viewBookById(bookId);
	}
	@Override
	public List<BookInformation> viewBooksByCategory(int categoryId) {
		
		return dao.viewBooksByCategory(categoryId);
	}
	

}
