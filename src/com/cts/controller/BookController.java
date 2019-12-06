package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.Dao.BookDao;
import com.cts.Entity.Book;
import com.cts.Entity.User;
import com.cts.service.BookService;
import com.cts.service.UserService;

@Controller
public class BookController {

	
	
	@Autowired
	  public BookService bookService;
	 @Autowired
	  public UserService userService;
	 @Autowired 
	public BookDao bookDao;
	// @Autowired 
	//public User user;
	  @RequestMapping(value = "/bookreg", method = RequestMethod.GET)
	  public ModelAndView showBooks() {
	    ModelAndView mav = new ModelAndView("bookreg");
	    mav.addObject("book", new Book());
	  
		//((Model) mav).addAttribute("Name", user.getName());
	    return mav;
	  }
	  
	  @RequestMapping(value = "/bookregistration", method = RequestMethod.POST)
	  public ModelAndView addBook(@ModelAttribute("book") Book book) throws Exception {
	  bookService.save(book);
	// System.out.print("register book");
	return new ModelAndView("redirect:/bookview");
	  }
	  
	    @RequestMapping("/bookview")    
	    public String viewBook(Model m){    
	        List<Book> list=bookDao.getBook();    
	        m.addAttribute("list",list); 
	    
			//m.addAttribute("Name", user.getName());
	        //System.out.print( user.getName());
	        return "booksview";  
	        
	    }    
	  
	    @RequestMapping(value="/deletebook/{bookcode}",method = RequestMethod.GET)    
	    public ModelAndView delete(@PathVariable String bookcode){    
	        bookService.delete(bookcode);   
	       // System.out.print("register book");
	        return new ModelAndView("redirect:/bookview");    
	    } 
	    
	    
	    
	    
	    
	    //only edit trial
	    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("book") Book book){    
	      
	    	bookService.update(book);    
	        return "redirect:/bookview";    
	    }    
	    @RequestMapping(value="/editbook/{bookcode}")    
	    public String edit(@PathVariable String bookcode, Model m){    
	        Book book=bookService.getBookByBookcode(bookcode);    
	        m.addAttribute("command",book);  
	        return "bookeditform";    
	    }    
	    /* It updates model object. */    
	   
	    @RequestMapping("/searchbook")    
	    public String searchBook(Model m){    
	        List<Book> list=bookDao.getBook();    
	        m.addAttribute("list",list); 
	       m.addAttribute("book", new Book());
			
	       // m.addAttribute("Name", user.getName());
	        return "viewbook";    
	    }    
	    
	    @RequestMapping(value="/viewselectedbook",method = RequestMethod.POST)    
	    public String viewselectedbook(@ModelAttribute("book") Book book, Model m){    
	    	//System.out.println(book.getBooktype());
	    	
		//	System.out.println(book.getDescription());
			
	    	 List<Book> list = bookDao.getBookByBooktype(book.getBookType());  
	     //	 System.out.println(list);
	    	  m.addAttribute("list",list); 
	       // System.out.print("register book");
	        return "viewselectedbook";    
	    } 
	   
	    
	   /* @ModelAttribute("book")
		public Book bookObject() {
			Book book = new Book();
			return book;

		}*/
	   
	
}
