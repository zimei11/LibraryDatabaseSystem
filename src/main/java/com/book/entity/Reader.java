package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Reader
{
    String mail;
    String password;
    String name;
    String sex;
    Date birth;
    String image;
    String phone;
    String state;
    Date open_time;
}
