package org.book.controller;

import java.util.List;

import org.book.app.pojo.Book;
import org.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/book" , consumes={MediaType.APPLICATION_JSON_VALUE} , produces={MediaType.APPLICATION_JSON_VALUE})
public class BookController2 {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method=RequestMethod.GET, value="/all}")
	public List<Book> getAllBooks() {
		return bookService.getBooks();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{keyword}")
	public List<Book> getSearchResults(@PathVariable("keyword") String keyword) {
		return bookService.getBooksByKeywords(keyword);
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public void createBook(@RequestBody Book book) {
		bookService.createBook(book);
	}
}
