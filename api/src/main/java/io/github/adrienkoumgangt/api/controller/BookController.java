package io.github.adrienkoumgangt.api.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.adrienkoumgangt.api.model.Book;
import io.github.adrienkoumgangt.api.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/book")
	public Book createBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	
	/**
	 * Read - Get one Book
	 * @param id The id of the book
	 * @return A book object full filled
	 */
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") final Integer id) {
		Optional<Book> book = bookService.getBook(id);
		if(book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}
	
	
	/**
	 * Read - Get all books
	 * @return - An Iterable object of Book full filled
	 */
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		return bookService.getBooks();
	}
	
	
	/**
	 * Update - Update an existing Book
	 * @param id - The id of the Book to uodate
	 * @param book - The book object updated
	 * @return
	 */
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable("id") final Integer id, @RequestBody Book book) {
		Optional<Book> b = bookService.getBook(id);
		if(b.isPresent()) {
			Book currentBook = b.get();
			
			String name = book.getName();
			if(name != null) {
				currentBook.setName(name);
			}
			
			String author = book.getAuthor();
			if(author != null) {
				currentBook.setAuthor(author);
			}
			
			String codeISBN = book.getCodeISBN();
			if(codeISBN != null) {
				currentBook.setCodeISBN(codeISBN);
			}
			
			String dateAdd = book.getDateAdd();
			if(dateAdd != null) {
				currentBook.setDateAdd(dateAdd);
			}
			
			String dateDelete = book.getDateDelete();
			if(dateDelete != null) {
				currentBook.setDateDelete(dateDelete);
			}
			
			String genere = book.getGenere();
			if(genere != null) {
				currentBook.setGenere(genere);
			}
			
			Long numberOfRead = book.getNumberOfRead();
			if(numberOfRead >= 0) {
				currentBook.setNumberOfRead(numberOfRead);
			}
			
			String description = book.getDescription();
			if(description != null) {
				currentBook.setDescription(description);
			}
			
			String content = book.getContent();
			if(content != null) {
				currentBook.setContent(content);
			}
			
			Long numberOfLike = book.getNumberOfLike();
			if(numberOfLike >= 0) {
				currentBook.setNumberOfLike(numberOfLike);
			}
			
			return currentBook;
		} else {
			return null;
		}
	}
	
	/**
	 * Update - Update an existing Book : incremented the number of read
	 * @param id - The id of the Book to update
	 */
	@PutMapping("/book/read/{id}")
	public void updateReadBook(@PathVariable("id") final Integer id) {
		Optional<Book> b = bookService.getBook(id);
		if(b.isPresent()) {
			Book currentBook = b.get();
			currentBook.incrNumberOfRead();
		}
	}
	
	@PutMapping("/book/like/{id}")
	public void updateLikeBook(@PathVariable("id") final Integer id) {
		Optional<Book> b = bookService.getBook(id);
		if(b.isPresent()) {
			Book currentBook = b.get();
			currentBook.incrNumberOfLike();
		}
	}
	
	@PutMapping("/book/unlike/{id}")
	public void updateUnlikeBook(@PathVariable("id") final Integer id) {
		Optional<Book> b = bookService.getBook(id);
		if(b.isPresent()) {
			Book currentBook = b.get();
			currentBook.decrNumberOfLike();
		}
	}
	
	
	@DeleteMapping("/book/{id}")
	public void delteBook(@PathVariable("id") final Integer id) {
		bookService.deleteBook(id);
	}

}
