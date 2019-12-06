package com.cts.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.Entity.User;



@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    }

	public int registerUser(User user)
	{
		String sql = "insert into users values('"+user.getUserName()+"',"+user.getName()+"',"+user.getPassword()+"',"+user.getDob()+"',"+user.getAddress()+"')";
	    return template.update(sql);
	}

	
		  
		
	

	@Override
	public int loginUser(User user)  {
		
		 String sql = "select * from users where username='" + user.getUserName() + "' and password='" + user.getPassword()
		    + "'";
		return template.update(sql);
		
	}
}






	








