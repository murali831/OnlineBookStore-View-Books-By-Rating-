import { BookInformation } from './book-information';

export class CustomerReview {
    reviewId:number;
    customerId:number;
    bookRating:number;
    reviewHeadline:string;
    reviewComment:string;
    book:BookInformation=new BookInformation();
}
