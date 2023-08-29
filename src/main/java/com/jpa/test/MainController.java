package com.jpa.test;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Entities.Book;

@RestController
public class MainController {
@Autowired(required=true)
private  BookServices bookService;	
	     //get all book handler
	     @GetMapping("/books")
         public List<Book> getBooks() {
        	
        	return this.bookService.getAllBooks();
         }
	     
	     //get single book handler
	     @GetMapping("/books/{Id}")
         public Book getBookById(@PathVariable("Id") int Id) {
        	
        	return this.bookService.getBookById(Id);
         }
	     
	     
	     //add book handler
	     @PostMapping("/books")
         public Book addBook(@RequestBody Book book) {
        	
        	Book b=this.bookService.addBook(book);
        	return b;
         }
	     
	     @DeleteMapping("/books/{bookId}")
	     public void deleteBook(@PathVariable("bookId") int bookId) {
	    	 this.bookService.deleteBook(bookId);
	    	 
	     }
	     //Update book handler
	     @PutMapping("/books/{bookId}")
	     public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
	    	 this.bookService.updateBook(book,bookId);
	    	 return book;
	     }
	     
	     
	     
}
