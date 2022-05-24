package com.book.dao;

import com.book.entity.Borrow;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper
{
    @Results(
            {
                    @Result(column = "id",property="id"),
                    @Result(column = "mail",property="mail"),
                    @Result(column = "bid",property="book_id"),
                    @Result(column = "borrow_time",property="borrow_time"),
                    @Result(column = "return_time",property="return_time")
            }
    )
    @Select("select * from borrow ,reader ,book where borrow.bid=book.bid and reader.mail=borrow.mail")
    List<Borrow> getBorrowList();
}
