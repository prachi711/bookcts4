package com.cts.service;

import java.util.List;

import com.cts.Entity.Book;

public interface BookService {
	
	void save(Book book) throws Exception;

	void delete(String bookcode);

	void update(Book book);

	Book getBookByBookcode(String bookcode);

	List<Book> getBookByBooktype(String booktype);
}
