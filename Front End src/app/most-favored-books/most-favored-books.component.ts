import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookstoreserviceService } from '../bookstoreservice.service';
import { BookInformation } from '../book-information';

@Component({
  selector: 'app-most-favored-books',
  templateUrl: './most-favored-books.component.html',
  styleUrls: ['./most-favored-books.component.css']
})
export class MostFavoredBooksComponent implements OnInit {
  books: BookInformation[] = [];
  pickedbooks: BookInformation[] = []; 
  viewallbooks : Boolean = false;
  
  constructor(private bookService:BookstoreserviceService,private router:Router) { 
    this.bookService.viewbooksbyrating().subscribe(data=>{
      this.books=data;
    });

    this.bookService.viewtop4booksbyrating().subscribe(data=>{
      this.pickedbooks=data;
    });
  }

  ngOnInit():void {
  }
  viewallfavoritebooks(): void {
    this.viewallbooks = true
  }

}
