package com.book.dao;

import com.book.entity.Borrow;
import  com.book.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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
    @Insert("insert into borrow(id,mail,bid,borrow_time,return_time) values(null,#{mail},#{book_id},now(),null)")
    void addBorrow(@Param("mail") String mail,@Param("book_id") int book_id);
    @Delete("delete from borrow where id = #{id} ")
    void deleteBorrow(String id);

    @Update("update borrow set return_time=now() where id = #{id}")
    void updateBorrow(String id);

    //得到图书列表
    @Results(
            {
                    @Result(column = "bid",property="book_id"),
            }
    )
    @Select("select * from book")
    List<Book> getBookList();

    @Delete("delete from book where bid=#{bid}")
    void deleteBook(int bid);

    @Insert("insert into book values(null,#{name},#{ISBN},,#{type},#{author},#{publisher},#{public_time}"+
            ",#{price},now(),#{bookshelf_id},0")
    void addBook(@Param("name") String name, @Param("ISBN") String ISBN,
                 @Param("type") String type, @Param("author") String author,
                 @Param("publisher") String publisher, @Param("public_time") String public_time,
                 @Param("price") float price, @Param("bookshelf_id") int bookshelf_id);
}
