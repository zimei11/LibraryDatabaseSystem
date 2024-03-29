package com.book.service;

import com.book.entity.Borrow;
import com.book.entity.Book;


import java.util.List;

public interface BookService
{
    List<Borrow> getBorrowList();
    List<Borrow> getBorrowListByType(String mail);
    void returnBook(int id);
    void addBorrow(String mail,int book_id);
    List<Book> getBookList();
    void deleteBook(int bid);
    void addBook(String name, String ISBN, String type,
                 String author, String publisher,
                int bookshelf_id);

//    List<Book> getActiveBookList();
}
