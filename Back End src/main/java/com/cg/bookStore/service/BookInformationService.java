package com.cg.bookStore.service;

import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.exceptions.BookInformationException;

public interface BookInformationService {

	public BookInformation findById(int bookId) throws BookInformationException;

}