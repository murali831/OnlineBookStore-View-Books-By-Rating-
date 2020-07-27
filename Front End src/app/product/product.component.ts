import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerReview } from '../customer-review';
import { CustomerReviewForm } from '../customer-review-form';
import { CustomerReviewService } from '../customer-review.service';
import { BookInformation } from '../book-information';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @ViewChild('reviewform')
  form:NgForm;

  review:CustomerReview=new CustomerReview();
  reviewForm:CustomerReviewForm=new CustomerReviewForm();
  reviews:Array<CustomerReview>=[];
  customer_id:number;
  message:string;
  errorMessage:string;
  bookId:number;
  book:BookInformation=new BookInformation();
  sub: any;
  pathurl:any;
  
  constructor(private customerReviewService:CustomerReviewService,private route:ActivatedRoute) { }

  ngOnInit() {
    this.customer_id=501;
    this.sub = this.route.params.subscribe(params => {
                                this.bookId = +params['bookId']; 
                                 this.customerReviewService.getBookByBookId(this.bookId).subscribe(data=>{this.book=data;},
      error=>{console.log(error); 
        this.errorMessage=error.error.message});
    this.customerReviewService.viewReviewByBookId(this.bookId).subscribe(data=>{this.reviews=data;},
      error=>{console.log(error); 
            this.errorMessage=error.error.message});
        this.pathurl="../assets/images/"+this.bookId+".jpg";                                                                                   
  });
  }

  addReview(){
    this.reviewForm.customerId=this.customer_id;
    this.reviewForm.bookId=this.bookId;
    console.log(this.review.bookRating);
    console.log(this.review.reviewHeadline);
    console.log(this.review.reviewComment);
    this.customerReviewService.addReview(this.reviewForm).subscribe(data=>{this.message=data;
                                                                      this.errorMessage=undefined;
                                                                alert("Review Successfully Added")},
                                                      error=>{console.log(error); 
                                                                this.errorMessage=error.error.message;});
    alert("Review Added Successfully");
  }

  viewReviewByBookId(){
    this.customerReviewService.viewReviewByBookId(this.bookId).subscribe(data=>{this.reviews=data;},
      error=>{console.log(error); 
        this.errorMessage=error.error.message});
  }

  viewBookByBookId(){
    this.customerReviewService.getBookByBookId(this.bookId).subscribe(data=>{this.book=data;},
      error=>{console.log(error); 
        this.errorMessage=error.error.message});
  }


}
