package com.jpa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import Entities.Book;



@Component
public class BookServices {
	
	private static List<Book> list=new ArrayList<>();
     static {
    	 
    	 list.add(new Book(12,"java complete refrence", "XYZ"));
    	 list.add(new Book(36,"Python complete refrence", "ABC"));
    	 list.add(new Book(11,"C++ complete refrence", "PQR"));
    	 
     }
     public List<Book> getAllBooks(){
    	 return list;
     }
     
     //get single book by id
     public Book getBookById(int Id) {
    	 
    	  Book book=list.stream().filter(e->e.getId()==Id).findFirst().get();
    	  return book;
     }
     
     
     //adding the book
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		 list.add(book);
    	 return book;
		
	}
	
	public void deleteBook(int id) {
		
		list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
//			if(e.getId()!=id) {
//				return true;
//			}else {return false;}
			
//		}).collect(Collectors.toList());	
		
	}
	
	public void updateBook(Book book,int bookId) {
		 list.stream().map(b->{
			 if(b.getId()==bookId) {
				 b.setTitle(book.getTitle());
				 b.setAuthor(book.getAuthor());
			 }
			 return b;
			 
		 }).collect(Collectors.toList());
	}
}

