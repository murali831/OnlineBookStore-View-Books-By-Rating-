package com.cg.bookStore.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookStore.dao.BestSellingBooksDao;
import com.cg.bookStore.entity.BookInformation;


@Service
public class BestSellingBookServiceImpl implements BestSellingBookService{

	@Autowired
	public BestSellingBooksDao dao;
	/************************************************************************************
	 * Method: getBestSellingBooks
     * Description: To Fetch list of all Best sold copies .
     * Created By                     - E Hemanth
     * Created Date                   - 16-JULY-2020                           
	 ************************************************************************************/
	
	@Override
	public List<BookInformation> getBestSellingBooks(){
		List<BookInformation> booksList = dao.getBestSellingBooks();
		return booksList;
	}


}
