package com.cg.bookstore.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.BookInformation;
import com.cg.bookstore.exceptions.BookException;
import com.cg.bookstore.service.BookStoreSerImpl;

@RestController
@RequestMapping("/books")
public class ViewBooksController {
	@Autowired
	public BookStoreSerImpl service;
	
	@CrossOrigin
	@GetMapping("/favoured")
	public List<BookInformation> viewfavoredBooksWeb() throws BookException {
		return service.viewFavoredBookser();
	}
	@CrossOrigin
	@GetMapping
	public List<BookInformation> viewAllBooks() {
		return service.viewAllBooksdao();
	}
	@CrossOrigin
	@GetMapping("/{bookId}")
	public BookInformation viewBookById(@PathVariable("bookId") int bookId,HttpServletRequest request) {
		return service.viewBookById(bookId);
	}
	@CrossOrigin
	@GetMapping("/category/{categoryId}")
	public List<BookInformation> viewAllBooksWeb(@PathVariable("categoryId") int categoryId,HttpServletRequest request) {
		return service.viewBooksByCategory(categoryId);
	}
	
}
