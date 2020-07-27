import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BookStoreConstants } from './book-store-constants';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookstoreserviceService {

  constructor(private http: HttpClient) { }
  viewallbooks():Observable<any>{
    return this.http.get(BookStoreConstants.VIEW_BOOKS_URL)
  }
  viewbooksbyrating():Observable<any>{
  return this.http.get(BookStoreConstants.VIEW_BOOKS_BY_RATING_URL);
  }
  viewtop4booksbyrating():Observable<any>{
    return this.http.get(BookStoreConstants.VIEW_4_BOOKS_BY_RATING_URL);
    }
  viewcategorys():Observable<any>{
    return this.http.get(BookStoreConstants.VIEW_CATEGORY_URL);
    }
  viewbookbycategory(categoryId : Number):Observable<any>{
    return this.http.get(BookStoreConstants.VIEW_CATEGORY_URL + '/' + categoryId);
    }
  getAllRecentlyPublishedBooks(): Observable<any> {
      return this.http.get(BookStoreConstants.VIEW_BOOKS_BY_DATE_URL);
    }
  getAllDemoRecentlyPublishedBooks(): Observable<any> {
      return this.http.get(BookStoreConstants.VIEW_4_BOOKS_BY_DATE_URL);
    }
}
