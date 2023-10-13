package com.samanz.springboot.bookVerse.rest;

import com.samanz.springboot.bookVerse.entity.Book;
import com.samanz.springboot.bookVerse.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService theBookService) {
        bookService = theBookService;
    }


    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // add mapping for GET /book/{bookId}
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {

        Book theBook = bookService.findById(bookId);

        if (theBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);

        }
        return theBook;
    }

    //add mapping for POST/books - add new book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {

        // in Case they pass an id in JSON  set the id to 0 to force a save of new item instead of update

        theBook.setId(0);

        Book dbBook = bookService.save(theBook);

        return dbBook;
    }

    //add mapping for PUT/ books-update existing book

    @PutMapping("/books")
    public Book updateBooks(@RequestBody Book theBook){
        Book dbBook = bookService.save(theBook);

        return dbBook;
    }
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId){

        Book theBook = bookService.findById(bookId);

        //throw an exception if null

        if(theBook == null){
            throw new RuntimeException("Book id not found - " + bookId);
        }
         bookService.deleteById(bookId);

        return "Deleted book id -" + bookId;
    }

}



