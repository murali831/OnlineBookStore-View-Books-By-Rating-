package com.cg.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookstore.entity.BookInformation;
@Repository
public class BookStoreDaoImpl implements BookStoreDao {
	@PersistenceContext
	private EntityManager em;
//	Find the highest-rated Book,rating,
//	SELECT TITLE , BOOK_RATING FROM BOOKSTORE_BOOK 
//	     NATURAL JOIN BOOKSTORE_CUSTOMER_REVIEW WHERE BOOK_RATING = ( SELECT MAX(BOOK_RATING) FROM BOOKSTORE_CUSTOMER_REVIEW );

//Correct Command in SQL but not in jpql	
//	SELECT title, avg(BOOKSTORE_CUSTOMER_REVIEW.book_rating) FROM BOOKSTORE_BOOK
//	INNER JOIN BOOKSTORE_CUSTOMER_REVIEW  ON BOOKSTORE_CUSTOMER_REVIEW.book_id = BOOKSTORE_BOOK.book_id
//	GROUP BY BOOKSTORE_CUSTOMER_REVIEW.book_id, BOOKSTORE_BOOK.title
//	ORDER BY avg(BOOKSTORE_CUSTOMER_REVIEW.book_rating)  DESC;
	@Override
	public List<BookInformation> viewFavoredBooksdao() {
		TypedQuery<BookInformation> query = em.createQuery("from BookInformation order by rating desc, title asc", BookInformation.class);
        System.out.println(query.getResultList());
		return query.getResultList();
//		String jpql = "from BookInformation order by rating desc, title asc";
//        TypedQuery<BookInformation> query = em.createQuery(jpql, BookInformation.class);
	}
//	inner join fetch b.category c
	@Override
	public List<BookInformation> viewAllBooksdao() {
		TypedQuery<BookInformation> query = em.createQuery("from BookInformation b", BookInformation.class);
        System.out.println(query.getResultList());
		return query.getResultList();
	}
	@Override
	public BookInformation viewBookById(int bookId) {
		return em.find(BookInformation.class, bookId);
	}
	@Override
	public List<BookInformation> viewBooksByCategory(int categoryId) {
		String jpql = "from BookInformation bi inner join fetch bi.category ct where ct.categoryId=:cid";
		TypedQuery<BookInformation> query = em.createQuery(jpql, BookInformation.class);
		query.setParameter("cid",categoryId);
		return query.getResultList();
	}
}
