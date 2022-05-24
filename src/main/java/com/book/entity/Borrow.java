package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow
{
    int id;
    String mail;
    int bid;
    Date borrow_time;
    Date return_time;
}
