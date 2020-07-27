import { BookCategory } from './book-category';

export class BookInformation {
    bookId:number;
    title:string;
    author:string;
    description:string;
    rating:number;
    isbnNumber:string;
    publishDate:Date;
    lastUpdateTime:Date;
    price:number;
    category:BookCategory=new BookCategory();
}
