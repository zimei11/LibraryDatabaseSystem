package com.book.dao;

import com.book.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper
{
    @Select("select * from message")
    List<Message> getMessageList();

    @Insert("insert into message(content,mail) values(#{content},#{mail})")
    void addMessage(@Param("content") String content,@Param("mail") String mail);
}
