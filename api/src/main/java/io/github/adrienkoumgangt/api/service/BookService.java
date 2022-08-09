package io.github.adrienkoumgangt.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.adrienkoumgangt.api.model.Book;
import io.github.adrienkoumgangt.api.repository.BookRepository;

import lombok.Data;

@Data
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Optional<Book> getBook(final Integer id) {
		return bookRepository.findById(id);
	}
	
	public Iterable<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	public void deleteBook(final Integer id) {
		bookRepository.deleteById(id);
	}
	
	public Book saveBook(Book book) {
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}

}
