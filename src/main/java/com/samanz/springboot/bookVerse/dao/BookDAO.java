package com.samanz.springboot.bookVerse.dao;

import com.samanz.springboot.bookVerse.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> findAll();

    Book findById(int theId);

    Book save(Book theBook);


    void deleteById(int theId);
}
