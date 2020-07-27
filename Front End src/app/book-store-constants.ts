export class BookStoreConstants {
    public static SPRING_WEB="http://localhost:8082/api/";

    public static VIEW_BOOKS_URL= BookStoreConstants.SPRING_WEB +"books/viewallBooks";

    public static VIEW_CATEGORY_URL = BookStoreConstants.SPRING_WEB +"books/category";
    
    public static VIEW_BOOKS_BY_RATING_URL= BookStoreConstants.SPRING_WEB+"books/viewfavoritebooks";

    public static VIEW_4_BOOKS_BY_RATING_URL = BookStoreConstants.SPRING_WEB + "books/viewtop4favoritebooks";

    public static VIEW_BOOKS_BY_DATE_URL= BookStoreConstants.SPRING_WEB+"books/recentlyPublishedBooks";

    public static VIEW_4_BOOKS_BY_DATE_URL = BookStoreConstants.SPRING_WEB + "books/viewtop4Publishedbooks";

    public static ADD_REVIEW_URL= BookStoreConstants.SPRING_WEB +"addreview";

    public static VIEW_REVIEW_BY_BOOK_ID_URL= BookStoreConstants.SPRING_WEB +"viewreviewsbybookid";

    public static VIEW_REVIEWS_BY_CUSTOMER_ID_URL= BookStoreConstants.SPRING_WEB +"viewreviewbycustomerid";
    
    public static vIEW_REVIEW_BY_CUSTOMER_ID_AND_BOOK_ID_URL= BookStoreConstants.SPRING_WEB +"viewreviewbycustidandbookid";

    public static VIEW_REVIEW_BY_REVIEW_ID_URL= BookStoreConstants.SPRING_WEB +"viewreviewbyreviewid";

    public static REMOVE_REVIEW_BY_CUSTOMER_ID_AND_BOOK_ID_URL= 
                                    BookStoreConstants.SPRING_WEB +"removereviewbycustomeridandbookid";

    public static REMOVE_REVIEW_BY_REVIEW_ID_URL= BookStoreConstants.SPRING_WEB +"removereviewbyreviewid";

    public static VIEW_BOOK_BY_BOOK_ID_URL=BookStoreConstants.SPRING_WEB+"books/";

}
