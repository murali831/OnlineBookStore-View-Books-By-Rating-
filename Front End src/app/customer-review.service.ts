import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { CustomerReview } from './customer-review';
import { BookStoreConstants } from './book-store-constants';
import { CustomerReviewForm } from './customer-review-form';

@Injectable({
  providedIn: 'root'
})
export class CustomerReviewService {

  constructor(private http:HttpClient){}

  public addReview(reviewForm:CustomerReviewForm):Observable<any>{
    return this.http.post(BookStoreConstants.ADD_REVIEW_URL,reviewForm);
  }

  public viewReviewByBookId(bookId:number):Observable<any>{
      return this.http.get(BookStoreConstants.VIEW_REVIEW_BY_BOOK_ID_URL+"/"+bookId);
  }

  public viewReviewsByCustomerId(customerId:number):Observable<any>{
    return this.http.get(BookStoreConstants.VIEW_REVIEWS_BY_CUSTOMER_ID_URL+"/"+customerId);
  }

  public viewReviewsByCustomerIdAndBookId(customerId:number,bookId:number):Observable<any>{
    return this.http.get(BookStoreConstants.vIEW_REVIEW_BY_CUSTOMER_ID_AND_BOOK_ID_URL+"/"+customerId+"/"+bookId);
  }

  public viewReviewsByReviewId(reviewId:number):Observable<any>{
    return this.http.get(BookStoreConstants.VIEW_REVIEW_BY_REVIEW_ID_URL+"/"+reviewId);
  }

  public deleteReviewsByCustomerIdAndBookId(customerId:number,bookId:number):Observable<any>{
    return this.http.delete(BookStoreConstants.REMOVE_REVIEW_BY_CUSTOMER_ID_AND_BOOK_ID_URL+"/"+customerId+"/"+bookId);
  }

  public deleteReviewsByReviewId(reviewId:number):Observable<any>{
    return this.http.delete(BookStoreConstants.REMOVE_REVIEW_BY_REVIEW_ID_URL+"/"+reviewId);
  }


  public getBookByBookId(bookId:number):Observable<any> {
    return this.http.get(BookStoreConstants.VIEW_BOOK_BY_BOOK_ID_URL+bookId);
  }
}
