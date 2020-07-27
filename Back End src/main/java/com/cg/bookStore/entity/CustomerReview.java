package com.cg.bookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/********************************************************************************************************
 *          @author          Sai Neel
 *          Description      It is an Entity class of Customer Review that is mapped with the Oracle DataBase
 *                                       of table bookstore_customer_review.
 *          @version         1.0
 *          Created Date     16-07-2020
 ********************************************************************************************************/

@Entity
@Table(name="bookstore_customer_review")
@DynamicInsert
@DynamicUpdate
public class CustomerReview {
	
	@Id
	@Column(name="review_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reviewIdGenerator")
	@SequenceGenerator(name="reviewIdGenerator", initialValue=1000)
	private int reviewId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="book_rating")
	@Min(1)
	@Max(5)
	private int bookRating;
	
	@Column(name="review_headline")
	@Size(min=20,max=128)
	private String reviewHeadline;
	
	@Column(name="review_comment",length=300)
	@Size(min=100,max=300)
	private String reviewComment;

	@ManyToOne
	@JoinColumn(name="book_id", referencedColumnName = "book_id")
	private BookInformation book = new BookInformation();

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookRating() {
		return bookRating;
	}

	public void setBookRating(int bookRating) {
		this.bookRating = bookRating;
	}

	public String getReviewHeadline() {
		return reviewHeadline;
	}

	public void setReviewHeadline(String reviewHeadline) {
		this.reviewHeadline = reviewHeadline;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public BookInformation getBook() {
		return book;
	}

	public void setBook(BookInformation book) {
		this.book = book;
	}

	
	
	
	
}
