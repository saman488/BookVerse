package com.samanz.springboot.bookVerse.entity;


import jakarta.persistence.*;

@Entity
@Table(name="book")

public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="book_name")
    private String book_name;
    @Column(name="author")
    private String author;


    @Column(name="price")

    private int price;




    public Book(){

    }

    public Book(String book_name, String author, int price) {
        this.book_name = book_name;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
