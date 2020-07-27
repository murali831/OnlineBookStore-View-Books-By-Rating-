package com.cg.bookStore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.exceptions.BookException;
import com.cg.bookStore.util.BookStoreConstants;
@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService {
	@Autowired
	private BookStoreDao bookdao;
	/************************************************************************************
	 * Method: viewfavoredBookser(). 
	 * Description: To Fetch list of all books based on average rating given by customer But throws the exception if no books was available.
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewfavoriteBooksByRating() throws BookException {
		List<BookInformation> bookslist = bookdao.viewfavoriteBooksByRating();
		if(bookslist.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookslist.subList(0, 8);
		return booklist2;
	}
	/************************************************************************************
	 * Method: viewfavoredBooksSer(). 
	 * Description: To Fetch list of all books based on average rating given by customer But throws the exception if no books was available. 
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewAllBooksSer() throws BookException {
		List<BookInformation> bookslist = bookdao.viewAllBooksdao();
		if(bookslist.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		return bookslist;
	}
	@Override
	public BookInformation viewBookById(int bookId) {
		
		return bookdao.viewBookById(bookId);
	}
	@Override
	public List<BookInformation> viewBooksByCategory(int categoryId) {
		
		return bookdao.viewBooksByCategory(categoryId);
	}
	@Override
	public List<BookCategory> viewBooksCategorys() {
		return bookdao.viewallCategories();
	}
	@Override
	public List<BookInformation> getAllRecentlyPublishedBooks() throws  BookException {
		List<BookInformation> bookList = bookdao.getAllRecentlyPublishedBooks();
		if(bookList.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookList.subList(0, 8);
		return booklist2;
	}
	@Override
	public List<BookInformation> getAll4RecentlyPublishedBooks() throws  BookException {
		List<BookInformation> bookList = bookdao.getAllRecentlyPublishedBooks();
		if(bookList.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookList.subList(0, 4);
		return booklist2;
	}
	@Override
	public List<BookInformation> viewtop4favoriteBooksByRating() throws BookException {
		List<BookInformation> bookslist = bookdao.viewfavoriteBooksByRating();
		if(bookslist.isEmpty())
			throw new BookException(BookStoreConstants.BOOK_NOT_AVAILABLE);
		List<BookInformation> booklist2 = bookslist.subList(0, 4);
		return booklist2;
	}
	@Override
	public List<BookInformation> getBestSellingBooks(){
		List<CartInformation> cartList = bookdao.getBestSellingBooks();
		List<BookInformation> bookList=new ArrayList<BookInformation>();
		int i=0;
		while(i<cartList.size()) {
			bookList.add(cartList.get(i).getBook());
			i++;
		}
		Map<Integer,BookInformation> booksMap=new HashMap<Integer, BookInformation>();
		List<BookInformation> sellingBooks=new ArrayList<BookInformation>();
		i=0;
		while(i<bookList.size()) {
			if(booksMap.put(bookList.get(i).getBookId(), bookList.get(i)) != null) {
				sellingBooks.add(bookList.get(i));
			}
			i++;
		}
		bookList.clear();
		booksMap.clear();
		List<BookInformation> sellingbooklist2 = sellingBooks.subList(0, 4);
		return sellingbooklist2;
	}
	@Override
	public List<BookInformation> get4BestSellingBooks() {
		List<CartInformation> cartList = bookdao.getBestSellingBooks();
		List<BookInformation> bookList=new ArrayList<BookInformation>();
		int i=0;
		while(i<cartList.size()) {
			bookList.add(cartList.get(i).getBook());
			i++;
		}
		Map<Integer,BookInformation> booksMap=new HashMap<Integer, BookInformation>();
		List<BookInformation> sellingBooks=new ArrayList<BookInformation>();
		i=0;
		while(i<bookList.size()) {
			if(booksMap.put(bookList.get(i).getBookId(), bookList.get(i)) != null) {
				sellingBooks.add(bookList.get(i));
			}
			i++;
		}
		bookList.clear();
		booksMap.clear();
		List<BookInformation> sellingbooklist2 = sellingBooks.subList(0, 8);
		return sellingbooklist2;
	}
}
