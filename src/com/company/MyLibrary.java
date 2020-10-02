package com.company;

import com.company.profClass.Book;
import com.company.profClass.Library;

public class MyLibrary implements Library {
    BookList library;

    public MyLibrary(){
        library = new BookList();
    }

    @Override
    public String[] getByAuthor(String aut) {
        return library.getbyAuthor(aut);
    }

    @Override
    public Book[] getByTitle(String tit) {
        return library.getbyTitle(tit);
    }

    @Override
    public Book[] getByPublisher(String pub) {
        return library.getbyPublisher(pub);
    }

    @Override
    public Book[] getByYear(int y) {
        return library.getbyYear(y);
    }

    @Override
    public String[] getAuthorByPublisher(String pub) {
        return library.getAuthorByPublisher(pub);
    }

    @Override
    public String[] getTitleByYear(int year) {
        return library.getTitleByYear(year);
    }

    @Override
    public void remove(Book b) throws Exception {
        library.remove(b);
    }

    @Override
    public void insert(Book b) {
        library.insert(b);
    }
}
