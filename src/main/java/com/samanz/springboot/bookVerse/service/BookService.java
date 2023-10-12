package com.samanz.springboot.bookVerse.service;

import com.samanz.springboot.bookVerse.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    Book save(Book theBook);


    void deleteById(int theId);


}
