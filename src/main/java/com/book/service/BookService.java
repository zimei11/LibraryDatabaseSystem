package com.book.service;

import com.book.entity.Borrow;
import com.book.entity.Book;


import java.util.List;

public interface BookService
{
    List<Borrow> getBorrowList();
    void returnBook(String id);
    void addBorrow(String mail,int book_id);
    List<Book> getBookList();
    void deleteBook(int bid);
//    List<Book> getActiveBookList();
}
