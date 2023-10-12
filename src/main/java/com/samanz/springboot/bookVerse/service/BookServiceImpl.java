package com.samanz.springboot.bookVerse.service;

import com.samanz.springboot.bookVerse.dao.BookDAO;
import com.samanz.springboot.bookVerse.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class BookServiceImpl implements BookService {


    private BookDAO bookDAO;

    @Autowired

    public BookServiceImpl(BookDAO theBookDAO) {
        bookDAO = theBookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findById(int theId) {
        return bookDAO.findById(theId);
    }

    @Transactional
    @Override
    public Book save(Book theBook) {
        return bookDAO.save(theBook);
    }


    @Transactional
    @Override
    public void deleteById(int theId) {

        bookDAO.deleteById(theId);

    }
}
