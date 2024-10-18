package com.yash.service;

import com.yash.entity.Book;

import java.util.List;


public interface BookService {
    public List<Book> getAllBooks();
    public boolean saveBook(Book book);


}
