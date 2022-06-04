package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Message
{
    int mid;
    String content;
    String mail;
    Date time;
}
