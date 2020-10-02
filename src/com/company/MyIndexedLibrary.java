package com.company;

import com.company.profClass.Book;
import com.company.profClass.IndexedBook;
import com.company.profClass.IndexedLibrary;

public class MyIndexedLibrary extends MyLibrary implements IndexedLibrary {
    private int code = 0;

    private IndexedBook[] books;

    public MyIndexedLibrary() {
        books = new IndexedBook[1];
    }

    @Override
    public IndexedBook getByIndex(int index) {
        if (index > code) {
            return null;
        }
        return books[index-1];//perchè in Java si parte da 0
    }

    private IndexedBook[] expandBooksArray(IndexedBook[] array) {
        IndexedBook[] new_array = new IndexedBook[array.length + 1];

        System.arraycopy(array, 0, new_array, 0, array.length);

        return new_array;
    }

    @Override
    public void insert(Book b) {
        IndexedBook indexedBook = new MyIndexedBook(b.getAuthor(), b.getTitle(), b.getPublisher(), b.getYear(), code, "");
        boolean inserito = false;
        while(!inserito) {
            try {
                books[code] = indexedBook;
                inserito = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                books = expandBooksArray(books);
            }
        }
        super.insert(indexedBook);
        code++;
    }

    @Override
    public void remove(int index) throws Exception {
        if (index > code) {
            throw new Exception("Book not found Exception");
        }

        IndexedBook[] result = new IndexedBook[books.length - 1];

        System.arraycopy(books, 0, result, 0, index);
        System.arraycopy(books, index + 1, result, index, books.length - index - 1);
        books = result;
        printList();
    }
    private void printList(){
        for (IndexedBook book : books) {
            System.out.print(book.getTitle() + ";");
        }
    }
}
