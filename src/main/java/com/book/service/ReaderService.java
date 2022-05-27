package com.book.service;

import com.book.entity.Reader;

import java.util.Date;
import java.util.List;

public interface ReaderService
{
    List<Reader> getReaderList();
    void deleteReader(String mail);

    void addReader(String mail, String password, String name,String sex
                   ,String phone, String state);
}
