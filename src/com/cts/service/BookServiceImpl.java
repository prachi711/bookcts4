package com.cts.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Dao.BookDao;
import com.cts.Entity.Book;
@Service("BookService")
public class BookServiceImpl implements BookService {
    
	@Autowired
	BookDao bookDao;
	
	

	public void save(Book book) throws Exception {
		// TODO Auto-generated method stub
		String temp=book.getBookName();
		
		//System.out.println(temp);
		
		 Random rand = new Random();
		    int ran = 10+rand.nextInt(90); 
	       
	   String ranstr=Integer.toString(ran);
	       // System.out.println("Random Integers: "+ran); 
	        String genid=temp.substring(0, 4).concat(ranstr);
	        
	        //System.out.println(genid);
	        book.setBookCode(genid);
		bookDao.save(book);
	}

	public void delete(String bookcode) {
		// TODO Auto-generated method stub
		bookDao.delete(bookcode);
	}

	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
	}

	public Book getBookByBookcode(String bookcode) {
		// TODO Auto-generated method stub
		return bookDao.getBookByBookcode(bookcode);
	}

	public List<Book> getBookByBooktype(String booktype) {
		return bookDao.getBookByBooktype(booktype);
	}

}
