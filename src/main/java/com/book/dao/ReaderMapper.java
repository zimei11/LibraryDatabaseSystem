package com.book.dao;

import com.book.entity.Reader;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReaderMapper
{
    @Select("select * from reader")
    List<Reader> getReaderList();
}
