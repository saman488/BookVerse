package com.samanz.springboot.bookVerse.dao;

import com.samanz.springboot.bookVerse.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
