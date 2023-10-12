package com.samanz.springboot.bookVerse.dao;

import com.samanz.springboot.bookVerse.entity.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class BookDAOJpaImpl implements BookDAO {


    private EntityManager entityManager;


    @Autowired

    public BookDAOJpaImpl(EntityManager theEntityManager) {

        entityManager = theEntityManager;
    }

    @Override
    public List<Book> findAll() {

        TypedQuery<Book> theQuery = entityManager.createQuery("From Book ", Book.class);

        List<Book> books = theQuery.getResultList();
        return books;
    }

    @Override
    public Book findById(int theId) {


        Book theBook = entityManager.find(Book.class, theId);
        return theBook;
    }

    @Override
    public Book save(Book theBook) {


        Book dbBook = entityManager.merge(theBook);


        return dbBook;
    }

    @Override
    public void deleteById(int theId) {

        Book theBook = entityManager.find(Book.class, theId);

        entityManager.remove(theBook);

    }
}
