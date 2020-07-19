package com.cg.bookstore;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.bookstore.entity.BookInformation;
import com.cg.bookstore.service.BookStoreSer;
import com.cg.bookstore.service.BookStoreSerImpl;
import com.cg.bookstore.web.ViewBooksController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ViewBooksController.class)
public class ViewBooksByRatingTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookStoreSer service;
	
	@Test
    public void viewBookTestExample() throws Exception {
    String Json = "{\"api\"books\"favoured}";
//    List<BookInformation> expectedResult = ".......";
//    Mockito.when(service.viewFavoredBookser()).thenReturn(expectedResult);
//    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books/favoured").accept(MediaTypes.)
    }

}
