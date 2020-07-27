package com.cg.bookStore.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entity.BookCategory;
import com.cg.bookStore.entity.BookInformation;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.exceptions.BookException;

@Repository
public class BookStoreDaoImpl implements BookStoreDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	/*
	 * this layer access the db and searches for that category id and fetches the list
	 * of books and return it to the service layer. 
	 */
	@Override
	public List<BookInformation> viewBooksInCategory(int categoryId) {
		String jpql = "from BookInformation binfo inner join fetch binfo.category c where c.categoryId=:cid";
		TypedQuery<BookInformation> query = em.createQuery(jpql, BookInformation.class);
		query.setParameter("cid", categoryId);
		return query.getResultList();
	}
	
	/************************************************************************************
	 * Method: viewfavoredBooksdao(). 
	 * Description: To Fetch list of all books based on average rating given by customer. 
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewfavoriteBooksByRating() {
		TypedQuery<BookInformation> query = em.createQuery("from BookInformation order by rating desc, title asc",
				BookInformation.class);
		System.out.println(query.getResultList());
		return query.getResultList();

	}

	/************************************************************************************
	 * Method: viewAllBooks() 
	 * Description: To Fetch list of all books.
	 * Created By -K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewAllBooksdao() {
		TypedQuery<BookInformation> query = em.createQuery("from BookInformation b", BookInformation.class);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	/************************************************************************************
	 * Method: viewBookById() 
	 * Description: To Fetch the book based on book_Id.
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public BookInformation viewBookById(int bookId) {
		return em.find(BookInformation.class, bookId);
	}

	/************************************************************************************
	 * Method: viewBooksByCategory() 
	 * Description: To Fetch list of all books based on category_Id. 
	 * Created By - K Murali Ramesh 
	 * Created Date - 16-JULY-2020
	 ************************************************************************************/
	@Override
	public List<BookInformation> viewBooksByCategory(int categoryId) {
		String jpql = "from BookInformation bi inner join fetch bi.category ct where ct.categoryId=:cid";
		TypedQuery<BookInformation> query = em.createQuery(jpql, BookInformation.class);
		query.setParameter("cid", categoryId);
		return query.getResultList();
	}

	@Override
	public List<BookCategory> viewallCategories() {
		TypedQuery<BookCategory> query = em.createQuery("from BookCategory c",
				BookCategory.class);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	@Override
	public List<BookInformation> getAllRecentlyPublishedBooks() throws BookException {
		String queryString = "SELECT Book From BookInformation Book where Book.publishDate BETWEEN :Start " + "AND :Stop Order by Book.publishDate Desc";
		TypedQuery<BookInformation> query = em.createQuery(queryString , BookInformation.class);
		query.setParameter("Start", LocalDate.now().minusMonths(2));
		query.setParameter("Stop", LocalDate.now());
		return query.getResultList();
	}
	
	@Override
	public List<CartInformation> getBestSellingBooks() {
		String jpql = "from CartInformation where status='order'";
		TypedQuery<CartInformation> query = em.createQuery(jpql, CartInformation.class);
		return query.getResultList();
	}
		
}
