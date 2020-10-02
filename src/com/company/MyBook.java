package com.company;

import com.company.profClass.Book;

public class MyBook implements Book {
    String author,title,publisher;
    int year;

    public MyBook(String author, String title, String publisher, int year) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean sameAuthor(Book b) {
        return author.equals(b.getAuthor());
    }

    @Override
    public boolean sameTitle(Book b) {
        return title.equals(b.getTitle());
    }

    @Override
    public boolean samePublisher(Book b) {
        return publisher.equals(b.getPublisher());
    }

    @Override
    public boolean sameYear(Book b) {
        return year == b.getYear();
    }

    @Override
    public boolean sameWork(Book b) {
        return sameAuthor(b) && sameTitle(b);
    }

    @Override
    public boolean equals(Book b) {
        return sameAuthor(b) && samePublisher(b) && sameTitle(b) && sameYear(b);
    }
}
