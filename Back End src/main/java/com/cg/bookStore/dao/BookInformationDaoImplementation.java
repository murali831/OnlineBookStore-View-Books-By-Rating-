package com.cg.bookStore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.cg.bookStore.entity.BookInformation;


/************************************************************************************
 *          @author          Sohaib Khan
 *          Description      It is a dao class that provides the book information
 *          Version          1.0
 *          Created Date     16-JULY-2020
 ************************************************************************************/
@Repository("BookInformationDao")
public class BookInformationDaoImplementation implements BookInformationDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BookInformation findBookId(int bookId) {
		return entityManager.find(BookInformation.class, bookId);
	}
}

