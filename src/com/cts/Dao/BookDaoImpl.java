package com.cts.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.Entity.Book;


@Repository("BookDao")
public class BookDaoImpl implements BookDao {

	
	@Autowired
	  DataSource dataSource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	 


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void save(Book book) {
		// TODO Auto-generated method stub
		String sql = "insert into book values(?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { book.getBookCode(), book.getBookName(), book.getBookType(), 
	     book.getPrice(), book.getDescription() });
	}
	
	public int delete(String bookcode) {
		// TODO Auto-generated method stub
		 String sql="delete from book where bookcode='"+bookcode+"'";    
		    return jdbcTemplate.update(sql);  
	}    

	public List<Book> getBook(){    
	    return jdbcTemplate.query("select * from book",new RowMapper<Book>(){    
	        public Book mapRow(ResultSet rs, int row) throws SQLException {    
	            Book b=new Book();    
	            b.setBookCode(rs.getString(1));    
	            b.setBookName(rs.getString(2));    
	            b.setBookType(rs.getString(3));    
	            b.setPrice(rs.getString(4));
	            b.setDescription(rs.getString(5)); 
	            return b;    
	        }    
	    });    
	}


	public Book getBookByBookcode(String bookcode) {
		// TODO Auto-generated method stub
		 String sql="select * from book where bookcode=?";    
		    return jdbcTemplate.queryForObject(sql, new Object[]{bookcode},new BeanPropertyRowMapper<Book>(Book.class));  
		
	}


	public int update(Book book) {
		// TODO Auto-generated method stub
		 String sql="update book set Bookname='"+book.getBookName()+"', Booktype='"+book.getBookType()+"', Price="+book.getPrice()+",Description='"+book.getDescription()+"' where bookcode='"+book.getBookCode()+"'";    
		    return jdbcTemplate.update(sql);  
		
	}


	public List<Book> getBookByBooktype(String booktype) {
		
	
	//	System.out.println("Deependra");
	
		  return jdbcTemplate.query("select * from book where booktype='"+booktype+"'",new RowMapper<Book>(){    
		        public Book mapRow(ResultSet rs, int row) throws SQLException {    
		            Book b=new Book();    
		            b.setBookCode(rs.getString(1));    
		            b.setBookName(rs.getString(2));    
		            b.setBookType(rs.getString(3));    
		            b.setPrice(rs.getString(4));
		            b.setDescription(rs.getString(5)); 
		            return b;    
		        }    
		    });    

	
	}
}
