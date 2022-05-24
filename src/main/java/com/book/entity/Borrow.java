package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow
{
    int id;
    String mail;
    int book_id;
    Date borrow_time;
    Date return_time;
}
