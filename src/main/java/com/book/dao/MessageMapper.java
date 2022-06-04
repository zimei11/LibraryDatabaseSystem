package com.book.dao;

import com.book.entity.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper
{
    @Select("select * from message order by mid desc")
    List<Message> getMessageList();

    @Insert("insert into message(content,mail,time) values(#{content},#{mail},now())")
    void addMessage(@Param("content") String content,@Param("mail") String mail);

    @Delete("delete from message where mid=#{mid}")
    void deleteMessage(@Param("mid") int mid);
}
