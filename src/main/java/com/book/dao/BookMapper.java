package com.book.dao;

import com.book.entity.Borrow;
import org.apache.ibatis.annotations.*;

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
    @Select("select * from borrow ,reader ,book where borrow.bid=book.bid and reader.mail=borrow.mail and return_time is null")
    List<Borrow> getBorrowList();

    @Delete("delete from borrow where id = #{id} ")
    void deleteBorrow(String id);

    @Update("update borrow set return_time=now() where id = #{id}")
    void updateBorrow(String id);
}
