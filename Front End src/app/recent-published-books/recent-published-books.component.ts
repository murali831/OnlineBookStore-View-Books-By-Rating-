import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookstoreserviceService } from '../bookstoreservice.service';
import { BookInformation } from '../book-information';

@Component({
  selector: 'app-recent-published-books',
  templateUrl: './recent-published-books.component.html',
  styleUrls: ['./recent-published-books.component.css']
})
export class RecentPublishedBooksComponent implements OnInit {

  books: BookInformation[] = [];
  pickedbooks: BookInformation[] = [];
  viewallbooks: Boolean = false;
  
  constructor(private bookService:BookstoreserviceService,private router:Router) {
    this.bookService.getAllRecentlyPublishedBooks().subscribe(data => {
      this.books = data;
    });

    this.bookService.getAllDemoRecentlyPublishedBooks().subscribe(data => {
      this.pickedbooks = data;
    });
   }

  ngOnInit(): void{
  }
  viewallrecentbooks(): void {
    this.viewallbooks = true;
  }

}
