import { Component, OnInit } from '@angular/core';
import { BookstoreserviceService } from '../bookstoreservice.service';
import { Router } from '@angular/router';
import { BookInformation } from '../book-information';
import { BookCategory } from '../book-category';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit { 
  categoryName : string;
  bookList: BookInformation[] = [];
  categories : BookCategory[] =[];  
  viewBookFlag=true;
  viewFvrtFlag=false;

  constructor(private bookService:BookstoreserviceService,private router:Router) {    
   }

  ngOnInit() { 
    this.bookService.viewcategorys().subscribe(data=>{console.log(data);
      this.categories=data;
    });
    this.getCategories();
    }

  
  getBooksByCategory(categoryId:number,categoryName:string){
    this.categoryName=categoryName;     
    this.bookService.viewbookbycategory(categoryId).subscribe(data=>{                                 
                             this.bookList=data;
                             this.viewBookFlag=false;
                            });                    
   }
   getCategories(){
     this.bookService.viewcategorys().subscribe(data=>{this.categories=data;
    });
   }
  showallbooks(){
    this.bookService.viewallbooks().subscribe(data=>{console.log(data);
      this.bookList=data;
      this.viewBookFlag=true;
      this.viewFvrtFlag=false;
     });
  }
}
