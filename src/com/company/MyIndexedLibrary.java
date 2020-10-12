package com.company;

import com.company.profClass.Book;
import com.company.profClass.IndexedBook;
import com.company.profClass.IndexedLibrary;

public class MyIndexedLibrary extends MyLibrary implements IndexedLibrary {
    private int code = 0;

    public MyIndexedLibrary() {

    }

    @Override
    public IndexedBook getByIndex(int index) {
        BookList.BookNode bl = library.getFirstBook();
        while(bl != null){
            IndexedBook book = (IndexedBook) bl.bk;
            if(book.getIndex() == index){
                return book;
            }
            bl=bl.next;
        }
        return null;
    }

    @Override
    public void insert(Book b) {
        super.insert(new MyIndexedBook(b.getAuthor(), b.getTitle(), b.getPublisher(), b.getYear(), code++));
    }

    public void insert(IndexedBook b) {
        super.insert(new MyIndexedBook(b.getAuthor(), b.getTitle(), b.getPublisher(), b.getYear(), code++, b.getGenre()));
    }

    @Override
    public void remove(int index) throws Exception {
        super.remove(getByIndex(index));
    }
}
