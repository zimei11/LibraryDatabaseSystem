package com.book.service;

import com.book.entity.Reader;

import java.util.List;

public interface ReaderService
{
    List<Reader> getReaderList();
    void deleteReader(String mail);
}
