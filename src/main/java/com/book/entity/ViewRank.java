package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ViewRank
{
    String ISBN;
    String name;
    String author;
    Date public_time;
    int cnt;
}
