package org.book.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.book.app.pojo.Book;
import org.book.data.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;

	@PersistenceContext
	private EntityManager entityManager;

	public void createBook(Book book) {
		repo.save(book);
	}
	
	public List<Book> getBooks() {
		return repo.findAll();
	}
	
	public List<Book> getBooksByKeywords(String keywords) {
		return repo.findAll();
	}

}
