package com.company;

import com.company.profClass.Book;

class BookList {
    class BookNode {
        private Book bk;
        private BookNode next;

        public BookNode(Book bk) {
            this.bk = bk;
            this.next = null;
        }
    }

    BookNode head = null;
    BookNode tail = null;

    public void insert(Book bk) {
        BookNode element = new BookNode(bk);

        if (head == null) {
            head = element;
        } else {
            tail.next = element;
        }
        tail = element;
    }

    public void remove(Book bk) throws Exception {
        BookNode first_element = new BookNode(null);
        first_element.next = head;
        BookNode temp = first_element;
        boolean trovato = false;
        while (temp.next != null) {
            if (temp.next.bk == bk) {
                temp.next = temp.next.next;
                trovato = true;
            } else {
                temp = temp.next;
            }
        }
        head = first_element.next;
        if (!trovato) {
            throw new Exception("Book not found Exception");
        }
    }

    public String[] getbyAuthor(String author) {
        BookNode temp = head;
        StringBuilder result = new StringBuilder();
        while (temp != null) {
            if (temp.bk.getAuthor().equals(author)) {
                result.append(temp.bk.getTitle());
                result.append(";");
            }
            temp = temp.next;
        }
        return result.toString().split(";");
    }

    public Book[] getbyTitle(String title) {
        BookNode temp = head;
        Book[] result = new Book[1];
        int index = 0;
        while (temp != null) {
            if (temp.bk.getTitle().equals(title)) {
                try {
                    result[index] = temp.bk;
                } catch (IndexOutOfBoundsException e) {
                    result = expandArray(result);
                    result[index] = temp.bk;
                }
                index++;
            }
            temp = temp.next;
        }
        return result;
    }

    public Book[] getbyPublisher(String publisher) {
        BookNode temp = head;
        Book[] result = new Book[1];
        int index = 0;
        while (temp != null) {
            if (temp.bk.getPublisher().equals(publisher)) {
                try {
                    result[index] = temp.bk;
                } catch (IndexOutOfBoundsException e) {
                    result = expandArray(result);
                    result[index] = temp.bk;
                }
                index++;
            }
            temp = temp.next;
        }
        return result;
    }

    public Book[] getbyYear(int year) {
        BookNode temp = head;
        String year_s = String.valueOf(year);
        Book[] result = new Book[1];
        int index = 0;

        while (temp != null) {
            if (String.valueOf(temp.bk.getYear()).equals(year_s)) {
                try {
                    result[index] = temp.bk;
                } catch (IndexOutOfBoundsException e) {
                    result = expandArray(result);
                    result[index] = temp.bk;
                }
                index++;
            }
            temp = temp.next;
        }
        return result;
    }

    public String[] getAuthorByPublisher(String pub) {
        BookNode temp = head;
        StringBuilder result = new StringBuilder();
        while (temp != null) {
            if (temp.bk.getPublisher().equals(pub)) {
                if (!result.toString().contains(temp.bk.getAuthor())) {
                    result.append(temp.bk.getAuthor());
                    result.append(";");
                }
            }
            temp = temp.next;
        }
        return result.toString().split(";");
    }

    public String[] getTitleByYear(int year) {
        BookNode temp = head;
        String year_s = String.valueOf(year);
        StringBuilder result = new StringBuilder();

        while (temp != null) {
            if (String.valueOf(temp.bk.getYear()).equals(year_s)) {
                result.append(temp.bk.getTitle());
                result.append(";");
            }
            temp = temp.next;
        }
        return result.toString().split(";");
    }

    private Book[] expandArray(Book[] array) {
        Book[] new_array = new Book[array.length + 1];

        System.arraycopy(array, 0, new_array, 0, array.length);

        return new_array;
    }

//    private void printList()
//    {
//        BookNode temp = head;
//        while (temp!=null)
//        {
//            System.out.print(temp.bk.getAuthor() + " -> ");
//            temp = temp.next;
//        }
//        System.out.println("null");
//    }

}
