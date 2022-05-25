package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Book
{
    int book_id;
    String name;
    String ISBN;
    String type;
    String author;
    String publisher;
    Date public_time;
    String price;
    Date library_time;
    int bookshelf_id;
    int state;
}
