package com.company;

import com.company.profClass.IndexedBook;

public class MyIndexedBook extends MyBook implements IndexedBook {
    int code;
    String genre;

    public MyIndexedBook(String author, String title, String publisher, int year, int code, String genre) {
        super(author, title, publisher, year);
        this.code = code;
        this.genre = genre;
    }
    public MyIndexedBook(String author, String title, String publisher, int year, int code) {
        super(author, title, publisher, year);
        this.code = code;
        this.genre = "undefined";
    }

    @Override
    public int getIndex() {
        return code;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public boolean sameGenre(IndexedBook b) {
        return genre.equals(b.getGenre());
    }
}
