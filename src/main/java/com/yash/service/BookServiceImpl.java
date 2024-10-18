package com.yash.service;

import com.yash.entity.Book;
import com.yash.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public boolean saveBook(Book book) {
        Book savedBook = bookRepo.save(book);
        if(savedBook.getBookId() != null) {
            return true;
        }
        return false;
    }
}


