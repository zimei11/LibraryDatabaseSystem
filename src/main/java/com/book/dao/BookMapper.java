package com.book.dao;

import com.book.entity.Borrow;
import  com.book.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper
{
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "mail", property = "mail"),
                    @Result(column = "bid", property = "book_id"),
                    @Result(column = "borrow_time", property = "borrow_time"),
                    @Result(column = "return_time", property = "return_time")
            }
    )
    @Select("select * from borrow ,reader ,book where borrow.bid=book.bid and reader.mail=borrow.mail and return_time is null order by borrow_time desc")
    List<Borrow> getBorrowList();

    @Insert("insert into borrow(id,mail,bid,borrow_time,return_time) values(null,#{mail},#{book_id},now(),null)")
    void addBorrow(@Param("mail") String mail, @Param("book_id") int book_id);

    @Delete("delete from borrow where id = #{id} ")
    void deleteBorrow(String id);

    @Update("update borrow set return_time=now() where id = #{id}")
    void updateBorrow(int id);

    //得到图书列表
    @Results(
            {
                    @Result(column = "bid", property = "book_id"),
            }
    )
    @Select("select * from book order by library_time desc")
    List<Book> getBookList();

    @Delete("delete from book where bid=#{bid}")
    void deleteBook(int bid);

    @Insert("insert into book(name, ISBN, type, author, publisher,library_time,  bookshelf_id,state) values(#{name},#{ISBN},#{type},#{author},#{publisher},now(),#{bookshelf_id},0)")
    void addBook(@Param("name") String name, @Param("ISBN") String ISBN,
                 @Param("type") String type, @Param("author") String author,
                 @Param("publisher") String publisher,
                 @Param("bookshelf_id") int bookshelf_id);

    //更改图书借阅状态
    @Update("update book set state= !state where bid=#{id}")
    void updateBookState(int bid);

    //查阅当前归还图书id
    @Select("select bid from borrow where id=#{id}")
    int getReturnBookId(int id);
}
