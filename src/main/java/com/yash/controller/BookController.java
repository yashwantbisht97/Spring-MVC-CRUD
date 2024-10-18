package com.yash.controller;

import com.yash.entity.Book;
import com.yash.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv= new ModelAndView();
        mv.addObject("book",new Book());
        mv.setViewName("index");
        return mv;

    }
    @PostMapping("/book")
    public ModelAndView saveBook(Book book){
        ModelAndView mv= new ModelAndView();
         boolean status=service.saveBook(book);
        if (status) {
            mv.addObject("succMsg", "Book Saved");
        } else {
            mv.addObject("errMsg", " Failed to save");
        }

        mv.setViewName("index");

        return mv;
    }

    @GetMapping("/books")
    public ModelAndView getAllBooks(){
        ModelAndView mv = new ModelAndView();
        List<Book> allBooks = service.getAllBooks();
        mv.addObject("books", allBooks);
        mv.setViewName("booksView");
        return mv;
    }

}



